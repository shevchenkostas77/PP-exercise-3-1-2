package com.shevchenkostas77.web.dao;

import com.shevchenkostas77.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User, Long> {

    @Modifying
    @Query("UPDATE User u SET u.name = :newName, u.lastName = :newLastName, u.email = :newEmail " +
            "WHERE u.id = :userId AND " +
            "(u.name <> :newName OR u.lastName <> :newLastName OR u.email <> :newEmail)")
    void updateUser(Long userId, String newName, String newLastName, String newEmail);
}
