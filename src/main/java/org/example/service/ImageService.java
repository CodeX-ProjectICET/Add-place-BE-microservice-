package org.example.service;

import org.example.dto.Image;
import org.example.entity.ImageEntity;

public interface ImageService {
    public Long save(Image image);

    public String generateImageId();

}
