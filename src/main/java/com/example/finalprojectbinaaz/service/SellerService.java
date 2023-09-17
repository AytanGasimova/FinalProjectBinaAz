package com.example.finalprojectbinaaz.service;

import com.example.finalprojectbinaaz.dao.entity.SellerEntity;
import com.example.finalprojectbinaaz.dao.repository.SellerRepository;
import com.example.finalprojectbinaaz.exception.NotFoundException;
import com.example.finalprojectbinaaz.mapper.SellerMapper;
import com.example.finalprojectbinaaz.model.SellerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SellerService {
    private final SellerRepository sellerRepository;
    private final SellerMapper sellerMapper;

    public List<SellerDto> getSellers(){
        log.info("ActionLog.getSellers.start");
        List<SellerEntity> sellerEntityList = sellerRepository.findAll();
        log.info("ActionLog.getSellers.end");
        return sellerMapper.mapListEntityToListDto(sellerEntityList);
    }


    public SellerDto getSeller(Long id){
        log.info("ActionLog.getSeller.start");
        SellerEntity sellerEntity = sellerRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Seller was not found with id " + id)
        );
        log.info("ActionLog.getSeller.end");
        return sellerMapper.mapEntityToDto(sellerEntity);
    }

    public void saveSeller(SellerDto sellerDto){
        log.info("ActionLog.saveSeller.start");
        sellerRepository.save(sellerMapper.mapDtoToEntity(sellerDto));
        log.info("ActionLog.saveSeller.end");
    }

    public void editSeller(SellerDto sellerDto, Long id){
        log.info("ActionLog.editSeller.start");
        sellerDto.setId(id);
        sellerRepository.save(sellerMapper.mapDtoToEntity(sellerDto,id));
        log.info("ActionLog.editSeller.end");
    }

    public boolean deleteSeller(Long id){
        log.info("ActionLog.deleteSeller.start");
        sellerRepository.deleteById(id);
        log.info("ActionLog.deleteSeller.end");
        return true;
    }
}
