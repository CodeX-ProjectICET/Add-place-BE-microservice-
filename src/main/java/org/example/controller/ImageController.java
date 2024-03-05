package org.example.controller;

import org.example.dto.Image;
import org.example.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin
@RequestMapping("/saveImage")
public class ImageController {
    @Autowired
    private ImageService imageService;

    public String uploadDirectory = System.getProperty("user.dir") + "/src/main/weApp/images";

    @PostMapping("/add")
    public void addImage(@ModelAttribute Image image)  throws IOException {
        MultipartFile file =image.getPlaceImage();
       if (!file.isEmpty()){
           String originalFilename = file.getOriginalFilename();
           Path fileNameAndPath = Paths.get(uploadDirectory, originalFilename);
           Files.write(fileNameAndPath, file.getBytes());
           image.setPlaceImage(file);

       }
       imageService.save(image);
    }


    @GetMapping("/get")
    public String getImageId() {
        return imageService.generateImageId();
    }




}

