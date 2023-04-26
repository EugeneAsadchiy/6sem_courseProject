package com.shop.ShoesShop.controllers;

import com.shop.ShoesShop.models.Images;
import com.shop.ShoesShop.repository.ImagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;

@RestController
@RequiredArgsConstructor
public class ImageController {
    private final ImagesRepository imagesRepository;
    @GetMapping("/images/{id}")
    private ResponseEntity<?> getImageById(@PathVariable Long id)
    {
        Images images = imagesRepository.findById(id).orElse(null);
        return ResponseEntity.ok()
                .header("filename", images.getUrlImages())
                .contentType(MediaType.valueOf(images.getContentType()))
                .contentLength(images.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(images.getBytes())));

    }
}
