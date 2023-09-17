package com.example.finalprojectbinaaz.controller;

import com.example.finalprojectbinaaz.dao.entity.SellerEntity;
import com.example.finalprojectbinaaz.model.AdvanceInfo;
import com.example.finalprojectbinaaz.model.BasicInfo;
import com.example.finalprojectbinaaz.model.ProductDto;
import com.example.finalprojectbinaaz.model.SellerDto;
import com.example.finalprojectbinaaz.service.ProductService;
import com.example.finalprojectbinaaz.service.SellerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sellers")
@RequiredArgsConstructor
public class SellerController {
    private final SellerService sellerService;

    @GetMapping
    public List<SellerDto> getSellers(){
        return sellerService.getSellers();
    }
    @GetMapping("/{sellerId}")
    public SellerDto getSeller(@PathVariable Long sellerId){
        return sellerService.getSeller(sellerId);
    }

    @PostMapping
    public void saveSeller(@Valid @RequestBody SellerDto sellerDto){
        sellerService.saveSeller(sellerDto);
    }

    @PutMapping("/{sellerId}")
    @Validated(BasicInfo.class)
    public void editSeller(@RequestBody SellerDto sellerDto,
                            @PathVariable Long sellerId){
        sellerService.editSeller(sellerDto,sellerId);
    }

    @DeleteMapping("/{sellerId}")
    public boolean deleteSeller(@PathVariable Long sellerId){
        return sellerService.deleteSeller(sellerId);
    }
}
