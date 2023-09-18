package com.example.finalprojectbinaaz.service;

import com.example.finalprojectbinaaz.dao.repository.ImageRepository;
import com.example.finalprojectbinaaz.mapper.ImageMapper;
import com.example.finalprojectbinaaz.model.ImageDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ImageService {
    private final ImageRepository imageRepository;
    private final ImageMapper imageMapper;


    public void saveImage(ImageDto imageDto) {
        log.info("ActionLog.saveImage.start");
        imageRepository.save(imageMapper.mapDtoToEntity(imageDto));
        log.info("ActionLog.saveImage.end");
    }
}
