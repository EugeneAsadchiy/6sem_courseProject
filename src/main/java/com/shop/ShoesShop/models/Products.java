package com.shop.ShoesShop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

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
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="products", orphanRemoval = true)
    private List<Images> image = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dataOfCreated;
    @PrePersist
    private void init()
    {
        dataOfCreated= LocalDateTime.now();
    }

    public void addImageToProduct(Images images)
    {
        images.setProducts(this);
        image.add(images);
    }


    public Products(String name_products, String season, String amount, String cost, String gender) {
        this.name_products = name_products;
        this.season = season;
        this.amount = amount;
        this.cost = cost;
        this.gender = gender;
    }
}
