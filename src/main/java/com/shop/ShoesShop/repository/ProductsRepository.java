package com.shop.ShoesShop.repository;

import com.shop.ShoesShop.models.Products;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductsRepository extends CrudRepository<Products, Long> {
//    List<Products> findProductsByAmount(String amount);
}
