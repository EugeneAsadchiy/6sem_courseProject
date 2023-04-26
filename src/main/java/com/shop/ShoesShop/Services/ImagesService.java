package com.shop.ShoesShop.Services;

import com.shop.ShoesShop.models.Images;
import com.shop.ShoesShop.repository.ImagesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImagesService {
    private final ImagesRepository imagesRepository;
    public Images getUrl(Long url_images) {
        return imagesRepository.findUrlImagesByIdImages(url_images);
    }
}
