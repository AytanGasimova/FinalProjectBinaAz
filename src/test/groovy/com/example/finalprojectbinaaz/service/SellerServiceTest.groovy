package com.example.finalprojectbinaaz.service

import com.example.finalprojectbinaaz.dao.entity.SellerEntity
import com.example.finalprojectbinaaz.dao.repository.SellerRepository
import com.example.finalprojectbinaaz.exception.NotFoundException
import com.example.finalprojectbinaaz.mapper.SellerMapper
import com.example.finalprojectbinaaz.model.SellerDto
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class SellerServiceTest extends Specification {
    private SellerRepository sellerRepository
    private SellerMapper sellerMapper
    private SellerService sellerService

    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    void setup() {
        sellerRepository = Mock()
        sellerMapper = Mock()
        sellerService = new SellerService(sellerRepository, sellerMapper)
    }

    def "GetSellers successes"() {
        given:
        List<SellerEntity> sellerEntityList = [random.nextObject(SellerEntity),
                                               random.nextObject(SellerEntity),
                                               random.nextObject(SellerEntity)]
        List<SellerDto> sellerDtoList = [random.nextObject(SellerDto),
                                         random.nextObject(SellerDto),
                                         random.nextObject(SellerDto)]

        when:
        def result = sellerService.getSellers()

        then:
        1 * sellerRepository.findAll() >> sellerEntityList
        1 * sellerMapper.mapListEntityToListDto(sellerEntityList) >> sellerDtoList

        result == sellerDtoList
    }

    def "GetSeller successes"() {
        given:
        Long sellerId = random.nextLong()
        SellerEntity sellerEntity = random.nextObject(SellerEntity)
        SellerDto sellerDto = random.nextObject(SellerDto)

        when:
        SellerDto result = sellerService.getSeller(sellerId)

        then:
        1 * sellerRepository.findById(sellerId) >> Optional.of(sellerEntity)
        1 * sellerMapper.mapEntityToDto(sellerEntity) >> sellerDto

        result == sellerDto
    }

    def "GetSeller SellerNotFound exception"() {
        given:
        Long sellerId = random.nextLong()

        when:
        SellerDto result = sellerService.getSeller(sellerId)

        then:
        1 * sellerRepository.findById(sellerId) >> Optional.empty()
        0 * sellerMapper.mapEntityToDto(_)

        def exception = thrown(NotFoundException)
        exception.message == "Seller was not found with id " + sellerId

        result == null
    }

    def "SaveSeller successes"() {
        given:
        SellerDto sellerDto = random.nextObject(SellerDto)
        SellerEntity sellerEntity = random.nextObject(SellerEntity)

        when:
        sellerService.saveSeller(sellerDto)

        then:
        1 * sellerMapper.mapDtoToEntity(sellerDto) >> sellerEntity
        1 * sellerRepository.save(sellerEntity)
    }

    def "EditSeller successes"() {
        given:
        SellerDto sellerDto = random.nextObject(SellerDto)
        Long sellerId = random.nextLong()

        when:
        sellerDto.setId(sellerId)
        sellerService.editSeller(sellerDto,sellerId)

        then:
        1 * sellerMapper.mapDtoToEntity(sellerDto,sellerId) >> _
        1 * sellerRepository.save(_) >> _
    }

    def "DeleteSeller successes"() {
        given:
        Long sellerId = random.nextLong()

        when:
        def result = sellerService.deleteSeller(sellerId)

        then:
        1 * sellerRepository.deleteById(sellerId)
        result == true

    }
}
