package com.shop.ShoesShop.Services;

import com.shop.ShoesShop.models.Images;
import com.shop.ShoesShop.models.Products;
import com.shop.ShoesShop.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
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
        productsFromDB.setPreviewImageId(productsFromDB.getImage().get(0).getIdImages());
//        log.info("Saving new Product name:{}", products);
        productsRepository.save(products);
    }

    private Images toImageEntity(MultipartFile file) throws IOException {
        Images images = new Images();
        images.setName_images(file.getName());
        images.setUrlImages(file.getOriginalFilename());
        images.setContentType(file.getContentType());
        images.setSize(file.getSize());
        images.setBytes(file.getBytes());
        return images;
    }
    public List<Products> sortProducts(String products_name,String min_price, String max_price,
                                       String gender,String season)
    {
        return productsRepository.findByNameProductsAndCostBetweenAndGenderAndSeason(products_name, Integer.parseInt(min_price),
                Integer.parseInt(max_price), gender,season);
    }
    public List<Products> sortProductsbyPrice(String min_price, String max_price)
    {
        return productsRepository.findByCostBetween(Integer.parseInt(min_price),
                Integer.parseInt(max_price));
    }
    public List<Products> sortProductsbyPriceAndGenderAndSeason(String min_price, String max_price, String gender, String season)
    {
        return productsRepository.findByCostBetweenAndGenderAndSeason(Integer.parseInt(min_price),
                Integer.parseInt(max_price), gender,season);
    }
    public List<Products> sortProductsNamePrice(String products_name,String min_price, String max_price)
    {
        return productsRepository.findByNameProductsAndCostBetween(products_name,Integer.parseInt(min_price),
                Integer.parseInt(max_price));
    }
    public List<Products>  sortASCandDESC(String min,String max, String sort)
    {
        return productsRepository.findByCostBetween(Integer.parseInt(min),
                Integer.parseInt(max), Sort.by(Sort.Direction.fromString(sort), "cost"));
    }
//    public List<Products> sortProductsByDESCAndASC(String sort_by_price)
//    {
//        return productsRepository.findByCost(Sort.by(Sort.Direction.fromString(sort_by_price), "cost"));
//    }

    public Products getProductById(Long id)
    {
        return productsRepository.findById(id).orElse(null);
    }
    public List<Products> getProductByName(String name)
    {
        if (name == null) return productsRepository.findAll();
        if (name.length() >= 1) return productsRepository.findByNameProducts(name);
        return  productsRepository.findAll();
//        return productsRepository.findByNameProducts(name);
    }


}
