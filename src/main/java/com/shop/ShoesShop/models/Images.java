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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idImages;
    @Column(name = "name_images")
    private String name_images;
    @Column(name = "url_images")
    private String urlImages;
    @Column(name = "size")
    private Long size;
    @Column(name = "content_type")
    private String contentType;
    @Column(name = "is_preview_image")
    private boolean isPreviewImage;
    @Lob
    private byte[] bytes;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Products products;
//    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
//    private Orders orders;

    public Images(String name_images, String urlImages) {
        this.name_images = name_images;
        this.urlImages = urlImages;
    }
}
