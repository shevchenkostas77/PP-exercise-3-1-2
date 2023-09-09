package com.shevchenkostas77.web.controller;

import com.shevchenkostas77.web.model.User;
import com.shevchenkostas77.web.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userServiceImpl;

    @GetMapping("add")
    public String addUserForm(User user) {
        return "add";
    }

    @PostMapping
    public String createUser(User user) {
        userServiceImpl.create(user);
        return "redirect:/users/all";
    }

    @GetMapping("all")
    public String readAllUsers(Model model) {
        model.addAttribute("users", userServiceImpl.readAll());
        return "all";
    }

    @GetMapping("/edit")
    public String editUsersTable(Model model) {
        model.addAttribute("users", userServiceImpl.readAll());
        return "edit-table";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userServiceImpl.read(id));
        return "edit";
    }

    @PatchMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id, User user) {
        userServiceImpl.update(id, user.getName(), user.getLastName(), user.getEmail());
        return "redirect:/users/edit";
    }

    @GetMapping("/delete")
    public String deleteUsersTable(Model model) {
        model.addAttribute("users", userServiceImpl.readAll());
        return "delete";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        userServiceImpl.delete(id);
        return "redirect:/users/delete";
    }
}
