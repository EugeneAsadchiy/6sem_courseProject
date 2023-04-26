package com.shop.ShoesShop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_products;
    @Column(name="name_products")
    private String nameProducts;
    @Column(name="season")
    private String season;
    @Column(name="amount")
    private String amount;
    @Column(name = "size")
    private String size;
    @Column(name="cost")
    private String cost;
    @Column(name="gender")
    private String gender;
    @Column(name="id_users")
    private Long idUsers;
    @Column(name="url_images")
    private String urlImages;

//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orders", orphanRemoval = true)
//    private List<Images> image = new ArrayList<>();
//    private Long previewImageId;

}
