package com.shop.ShoesShop.repository;

import com.shop.ShoesShop.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

//    boolean existsByUser_login(String user_login);

    boolean existsUsersByUserLoginAndUserPassword(String userLogin, String userPassword);
    boolean existsUsersByUserLogin(String userLogin);
}
