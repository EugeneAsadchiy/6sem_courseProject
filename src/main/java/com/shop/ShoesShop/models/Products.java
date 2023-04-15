package com.shop.ShoesShop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_products;
    @Column(name="name_products")
    private String name_products;
    @Column(name="season")
    private String season;
    @Column(name="amount")
    private String amount;
    @Column(name="cost")
    private String cost;
    @Column(name="gender")
    private String gender;

    public Products(String name_products, String season, String amount, String cost, String gender) {
        this.name_products = name_products;
        this.season = season;
        this.amount = amount;
        this.cost = cost;
        this.gender = gender;
    }
}
