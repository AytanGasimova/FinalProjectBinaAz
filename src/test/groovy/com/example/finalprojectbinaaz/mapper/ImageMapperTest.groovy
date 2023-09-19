package com.example.finalprojectbinaaz.mapper

import com.example.finalprojectbinaaz.dao.entity.ImageEntity
import com.example.finalprojectbinaaz.model.ImageDto
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

import org.mapstruct.factory.Mappers

class ImageMapperTest extends Specification {
    private ImageMapper imageMapper = Mappers.getMapper(ImageMapper.class)
    private ImageDto imageDto
    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    void setup() {

    }


    def "MapDtoToEntity successes"() {
        given:
        imageDto = random.nextObject(ImageDto)

        when:
        ImageEntity result = imageMapper.mapDtoToEntity(imageDto)

        then:
        result != null

        and:
        result.image == imageDto.image
        result.isPreviewImage() == imageDto.isPreviewImage()
    }
}