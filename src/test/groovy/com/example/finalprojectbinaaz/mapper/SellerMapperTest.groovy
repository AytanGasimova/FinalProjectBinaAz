package com.example.finalprojectbinaaz.mapper

import com.example.finalprojectbinaaz.dao.entity.SellerEntity
import com.example.finalprojectbinaaz.model.SellerDto
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import org.mapstruct.factory.Mappers
import spock.lang.Specification

class SellerMapperTest extends Specification {
    private SellerMapper sellerMapper = Mappers.getMapper(SellerMapper.class)
    private SellerEntity sellerEntity
    private SellerDto sellerDto
    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    void setup() {
    }

    def "MapEntityToDto successes"() {
        given:
        sellerEntity = random.nextObject(SellerEntity)

        when:
        SellerDto result = sellerMapper.mapEntityToDto(sellerEntity)

        then:
        result != null

        and:
        result.name == sellerEntity.name
        result.telNumber == sellerEntity.telNumber
        result.email == sellerEntity.email
        result.id == sellerEntity.id
        result.agencyDescription == sellerEntity.agencyDescription
        result.sellerType == sellerEntity.sellerType
        result.location == sellerEntity.location

    }


    def "MapDtoToEntity successes"() {
        given:
        sellerDto = random.nextObject(SellerDto)

        when:
        SellerEntity result = sellerMapper.mapDtoToEntity(sellerDto)

        then:
        result != null

        and:
        result.name == sellerDto.name
        result.telNumber == sellerDto.telNumber
        result.email == sellerDto.email
        result.id == sellerDto.id
        result.agencyDescription == sellerDto.agencyDescription
        result.sellerType == sellerDto.sellerType
        result.location == sellerDto.location
    }

    def "TestMapDtoToEntity with id successes"() {
        given:
        sellerDto = random.nextObject(SellerDto)
        Long sellerId = random.nextLong()

        when:
        SellerEntity result = sellerMapper.mapDtoToEntity(sellerDto, sellerId)

        then:
        result != null

        and:
        result.name == sellerDto.name
        result.telNumber == sellerDto.telNumber
        result.email == sellerDto.email
        result.id == sellerDto.id
        result.agencyDescription == sellerDto.agencyDescription
        result.sellerType == sellerDto.sellerType
        result.location == sellerDto.location
    }

    def "MapListEntityToListDto successes"() {
        given:
        List<SellerEntity> sellerEntityList = [random.nextObject(SellerEntity),
                                               random.nextObject(SellerEntity),
                                               random.nextObject(SellerEntity)]

        when:
        List<SellerDto> result = sellerMapper.mapListEntityToListDto(sellerEntityList)

        then:
        result != null
        result != null
        result.size() == sellerEntityList.size()

        and:
        result.eachWithIndex { sellerDto, index ->
            assert sellerDto.name == sellerEntityList[index].name
            assert sellerDto.telNumber == sellerEntityList[index].telNumber
            assert sellerDto.email == sellerEntityList[index].email
            assert sellerDto.id == sellerEntityList[index].id
            assert sellerDto.agencyDescription == sellerEntityList[index].agencyDescription
            assert sellerDto.sellerType == sellerEntityList[index].sellerType
            assert sellerDto.location == sellerEntityList[index].location
        }
    }
}
