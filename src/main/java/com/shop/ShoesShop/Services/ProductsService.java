package com.shop.ShoesShop.Services;

import com.shop.ShoesShop.models.Images;
import com.shop.ShoesShop.models.Products;
import com.shop.ShoesShop.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public void saveProducts(Products products, MultipartFile file1, MultipartFile file2, MultipartFile file3) throws IOException {
        Images image1;
        Images image2;
        Images image3;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            products.addImageToProduct(image1);
        }
        if (file2.getSize() != 0) {
            image2 = toImageEntity(file2);
//            image2.setPreviewImage(false);
            products.addImageToProduct(image2);
        }
        if (file3.getSize() != 0) {
            image3 = toImageEntity(file3);
//            image3.setPreviewImage(false);
            products.addImageToProduct(image3);
        }
        Products productsFromDB= productsRepository.save(products);
        productsFromDB.setPreviewImageId(productsFromDB.getImage().get(0).getId_images());
//        log.info("Saving new Product name:{}", products);
        productsRepository.save(products);
    }

    private Images toImageEntity(MultipartFile file) throws IOException {
        Images images = new Images();
        images.setName_images(file.getName());
        images.setUrl_images(file.getOriginalFilename());
        images.setContentType(file.getContentType());
        images.setSize(file.getSize());
        images.setBytes(file.getBytes());
        return images;
    }

    public Products getProductById(Long id)
    {
        return productsRepository.findById(id).orElse(null);
    }


}
