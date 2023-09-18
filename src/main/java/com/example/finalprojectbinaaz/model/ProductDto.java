package com.example.finalprojectbinaaz.model;

import com.example.finalprojectbinaaz.enums.AdvertisementType;
import com.example.finalprojectbinaaz.enums.CategoryType;
import com.example.finalprojectbinaaz.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String city;
    @NotBlank
    private String district;
    private String metro;
    private String mark;
    @Min(1)
    private Integer onWhatFloor;
    @Min(1)
    private Integer numberOfFloor;
    @Positive
    private Double price;
    private TransactionType transactionType;
    private CategoryType categoryType;
    private AdvertisementType advertisementType;
    @Column(columnDefinition = "TEXT")
    private String description;
    private LocalDateTime creationDate;
    @Positive
    private Double productArea;
    @Positive
    private Integer countOfRoom;
    private boolean isRenovated;
    private boolean hasDocument;
    private boolean isMortgageable;
    private SellerDto sellerDto;
    private List<ImageDto> imageDtoList;
    private Long previewImageId;
}
/*
public class UserAccount {

    @NotBlank
    private String name;

    @NotNull
    @Size(min = 4, max = 15)
    private String password;

    // standard constructors / setters / getters / toString

}
*/
/*    @RequestMapping(value = "/saveBasicInfo", method = RequestMethod.POST)
    public String saveBasicInfo(
            @Valid @ModelAttribute("useraccount") UserAccount useraccount,
            BindingResult result,
            ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        return "success";
    }
*/