package com.example.finalprojectbinaaz.model;

import com.example.finalprojectbinaaz.enums.CategoryType;
import com.example.finalprojectbinaaz.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductFilterDto {
    private Long id;
    private Double productArea;
    private Integer onWhatFloor;
    private Integer countOfRoom;
    private Double price;
    private String city;
    private String district;
    private String metro;
    private String mark;
    private CategoryType categoryType;
    private TransactionType transactionType;
}
