package com.example.finalprojectbinaaz.mapper

import com.example.finalprojectbinaaz.dao.entity.ProductEntity
import com.example.finalprojectbinaaz.model.ProductDto
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import org.mapstruct.factory.Mappers
import spock.lang.Specification

class ProductMapperTest extends Specification {
    private ProductMapper productMapper = Mappers.getMapper(ProductMapper.class)
    private ProductDto productDto
    private ProductEntity productEntity

    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    void setup() {
    }

    def "MapEntityToDto successes"() {
        given:
        productEntity = random.nextObject(ProductEntity)

        when:
        def result = productMapper.mapEntityToDto(productEntity)

        then:
        result != null

        and:
        result.id == productEntity.id
        result.district == productEntity.district
        result.metro == productEntity.metro
        result.city == productEntity.city
        result.mark == productEntity.mark
        result.onWhatFloor == productEntity.onWhatFloor
        result.numberOfFloor == productEntity.numberOfFloor
        result.price == productEntity.price
        result.transactionType == productEntity.transactionType
        result.categoryType == productEntity.categoryType
        result.advertisementType == productEntity.advertisementType
        result.creationDate == productEntity.creationDate
        result.productArea == productEntity.productArea
        result.description == productEntity.description
        result.countOfRoom == productEntity.countOfRoom
        result.hasDocument ==productEntity.hasDocument

    }

    def "MapDtoToEntity successes"() {
        given:
        productDto = random.nextObject(ProductDto)

        when:
        def result = productMapper.mapDtoToEntity(productDto)

        then:
        result != null

        and:
        result.id == productDto.id
        result.district == productDto.district
        result.metro == productDto.metro
        result.city == productDto.city
        result.mark == productDto.mark
        result.onWhatFloor == productDto.onWhatFloor
        result.numberOfFloor == productDto.numberOfFloor
        result.price == productDto.price
        result.transactionType == productDto.transactionType
        result.categoryType == productDto.categoryType
        result.advertisementType == productDto.advertisementType
        result.creationDate == productDto.creationDate
        result.productArea == productDto.productArea
        result.description == productDto.description
        result.countOfRoom == productDto.countOfRoom
        result.hasDocument ==productDto.hasDocument
    }

    def "MapDtoToEntity with id successes"() {
        given:
        productDto = random.nextObject(ProductDto)
        Long productId = random.nextLong()

        when:
        def result = productMapper.mapDtoToEntity(productDto,productId)

        then:
        result != null

        and:
        result.id == productDto.id
        result.district == productDto.district
        result.metro == productDto.metro
        result.city == productDto.city
        result.mark == productDto.mark
        result.onWhatFloor == productDto.onWhatFloor
        result.numberOfFloor == productDto.numberOfFloor
        result.price == productDto.price
        result.transactionType == productDto.transactionType
        result.categoryType == productDto.categoryType
        result.advertisementType == productDto.advertisementType
        result.creationDate == productDto.creationDate
        result.productArea == productDto.productArea
        result.description == productDto.description
        result.countOfRoom == productDto.countOfRoom
        result.hasDocument ==productDto.hasDocument

    }
}
