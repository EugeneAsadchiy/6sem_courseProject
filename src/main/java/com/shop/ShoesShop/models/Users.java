package com.shop.ShoesShop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_users;
    @Column(name="user_login")

    private String userLogin;
    @Column(name="user_password")
    private String userPassword;
    @Column(name="role")
    private int role;
    public static int session=1;
    public static String profile="admin@mail.ru";
    public Users(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }
}
