package com.shop.ShoesShop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "confirmed_orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmedOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_orders;
    @Column(name="name_products")
    private String nameProducts;
    @Column(name="season")
    private String season;
    @Column(name="amount")
    private int amount;
    @Column(name = "size")
    private String size;
    @Column(name="cost")
    private int cost;
    @Column(name="gender")
    private String gender;
    @Column(name="id_users")
    private Long idUsers;
    private LocalDateTime dataOfCreated;

    @PrePersist
    private void init() {
        dataOfCreated = LocalDateTime.now();
    }

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orders", orphanRemoval = true)
//    private List<Images> image = new ArrayList<>();
//    private Long previewImageId;

}
