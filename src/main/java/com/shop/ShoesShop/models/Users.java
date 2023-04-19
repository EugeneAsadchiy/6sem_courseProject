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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_users;
    @Column(name="user_login")

    private String user_login;
    @Column(name="user_password")
    private String user_password;
    @Column(name="role")
    private int role;

    public Users(String user_login, String user_password) {
        this.user_login = user_login;
        this.user_password = user_password;
    }
}
