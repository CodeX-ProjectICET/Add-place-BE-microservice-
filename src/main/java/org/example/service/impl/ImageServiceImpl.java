package org.example.service.impl;

import org.example.dto.Image;
import org.example.entity.ImageEntity;
import org.example.repository.ImageRepository;
import org.example.service.ImageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    ModelMapper modelMapper;

    public Long save(Image image) {
        ImageEntity entity = modelMapper.map(image, ImageEntity.class);

        String generateId = generateImageId();
        entity.setImageId(generateId);

        ImageEntity savedEntity = imageRepository.save(entity);
        return savedEntity.getId();
    }

    public String generateImageId() {
        ImageEntity latestImage = imageRepository.findTopByOrderByIdDesc().orElse(null);
        Long latestId = (latestImage == null) ? 0 : latestImage.getId();
        String generatedId = String.format("P%04d", latestId + 1);
        return generatedId;
    }

}
