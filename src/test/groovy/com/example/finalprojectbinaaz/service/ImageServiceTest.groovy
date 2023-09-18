package com.example.finalprojectbinaaz.service

import com.example.finalprojectbinaaz.dao.entity.ImageEntity
import com.example.finalprojectbinaaz.dao.repository.ImageRepository
import com.example.finalprojectbinaaz.mapper.ImageMapper
import com.example.finalprojectbinaaz.model.ImageDto
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class ImageServiceTest extends Specification {
    private ImageRepository imageRepository;
    private ImageMapper imageMapper;
    private ImageService imageService;

    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    void setup() {
        imageRepository = Mock()
        imageMapper = Mock()
        imageService = new ImageService(imageRepository, imageMapper)
    }

    def "SaveImage successes"() {
        given:
        ImageDto imageDto = random.nextObject(ImageDto)
        ImageEntity imageEntity = random.nextObject(ImageEntity)

        when:
        imageService.saveImage(imageDto)

        then:
        1 * imageMapper.mapDtoToEntity(imageDto) >> imageEntity
        1 * imageRepository.save(imageEntity)
    }
}
