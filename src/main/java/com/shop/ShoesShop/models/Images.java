package com.shop.ShoesShop.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_images;
    @Column(name="name_images")
    private String name_images;
    @Column(name="url_images")
    private String url_images;


    public Images(String name_images, String url_images) {
        this.name_images = name_images;
        this.url_images = url_images;
    }
}
