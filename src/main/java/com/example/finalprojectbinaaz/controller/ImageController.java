package com.example.finalprojectbinaaz.controller;

import com.example.finalprojectbinaaz.model.ImageDto;
import com.example.finalprojectbinaaz.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImageService imageService;

    @PostMapping
    public void saveImage(@RequestBody ImageDto imageDto){
        imageService.saveImage(imageDto);
    }

}
