package com.example.finalprojectbinaaz.controller

import com.example.finalprojectbinaaz.model.ImageDto
import com.example.finalprojectbinaaz.service.ImageService
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class ImageControllerTest extends Specification {
    private ImageService imageService
    private ImageDto imageDto
    private ImageController imageController

    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    void setup() {
        imageService = Mock()
        imageController = new ImageController(imageService)

    }

    def "ImageController SaveImage method successes"() {
        given:
        imageDto = random.nextObject(ImageDto)

        when:
        imageController.saveImage(imageDto)

        then:
        1 *  imageService.saveImage(imageDto)

    }
}

