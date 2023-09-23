package com.example.finalprojectbinaaz.model;

import com.example.finalprojectbinaaz.enums.SellerType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SellerDto {
    private Long id;
    @NotBlank(groups = BasicInfo.class)
    private String name;
    @Pattern(
            regexp = "^\\+994(77|70|50|51|10|55|99)[0-9]{7}$",
            message = "The phone number format does not match",
            groups = BasicInfo.class
    )
    private String telNumber;
    @Email(groups = BasicInfo.class)
    private String email;
    /* owner or agent of object */
    private SellerType sellerType;
    /* information about agency */
    @Column(columnDefinition = "TEXT")
    private String agencyDescription;
    /* location of the agency for GoogleMap*/
    @NotBlank(groups = AdvanceInfo.class)
    private String location;
}
