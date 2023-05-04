package com.shop.ShoesShop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_products;
    @Column(name = "name_products")
    private String nameProducts;
    @Column(name = "season")
    private String season;
    @Column(name = "amount")
    private int amount;
    @Column(name = "size")
    private String size;
    @Column(name = "cost")
    private int cost;
    @Column(name = "gender")
    private String gender;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "products", orphanRemoval = true)
    private List<Images> image = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dataOfCreated;

    @PrePersist
    private void init() {
        dataOfCreated = LocalDateTime.now();
    }

    public void addImageToProduct(Images images) {
        images.setProducts(this);
        image.add(images);
    }


    public Products(String nameProducts, String season, int amount, String size, int cost, String gender) {
        this.nameProducts = nameProducts;
        this.season = season;
        this.amount = amount;
        this.size = size;
        this.cost = cost;
        this.gender = gender;
    }
}
