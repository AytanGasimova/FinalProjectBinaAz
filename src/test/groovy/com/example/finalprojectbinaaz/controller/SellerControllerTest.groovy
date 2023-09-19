package com.example.finalprojectbinaaz.controller

import com.example.finalprojectbinaaz.model.SellerDto
import com.example.finalprojectbinaaz.service.SellerService
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class SellerControllerTest extends Specification {
    private SellerService sellerService
    private SellerDto sellerDto
    private SellerController sellerController

    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    void setup() {
        sellerService = Mock()
        sellerController = new SellerController(sellerService)
    }

    def "SellerController GetSellers method successes"() {
        given:
        def sellerDtoList = [random.nextObject(SellerDto),
                             random.nextObject(SellerDto),
                             random.nextObject(SellerDto)]

        when:
        def result = sellerController.getSellers()

        then:
        1 * sellerService.getSellers() >> sellerDtoList

        result == sellerDtoList

    }

    def "SellerController GetSeller method successes"() {
        given:
        Long sellerId = random.nextLong()

        when:
        def result = sellerController.getSeller(sellerId)

        then:
        1 * sellerService.getSeller(sellerId) >> sellerDto

        result == sellerDto

    }

    def "SellerController SaveSeller method successes"() {
        given:
        sellerDto = random.nextObject(SellerDto)

        when:
        sellerController.saveSeller(sellerDto)

        then:
        1 * sellerService.saveSeller(sellerDto)

    }

    def "SellerController EditSeller method successes"() {
        given:
        sellerDto = random.nextObject(SellerDto)
        Long sellerId = random.nextLong()

        when:
        sellerController.editSeller(sellerDto, sellerId)

        then:
        1 * sellerService.editSeller(sellerDto, sellerId)

    }

    def "SellerController DeleteSeller method successes"() {
        given:
        Long sellerId = random.nextLong()

        when:
        def result = sellerController.deleteSeller(sellerId)

        then:
        1 * sellerService.deleteSeller(sellerId) >> true

        result == true

    }
}
