package com.shop.ShoesShop.repository;

import com.shop.ShoesShop.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Long> {
//    List<Products> findById_products (Long id_products);

//    List<Products> findByName_products(String name_products);
}
