package com.example.finalprojectbinaaz.dao.entity;

import com.example.finalprojectbinaaz.enums.SellerType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sellers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String telNumber;
    private String email;
    /* owner or agent of object */
    @Enumerated(EnumType.STRING)
    private SellerType sellerType;
    /* information about agency */
    @Column(columnDefinition = "TEXT")
    private String agencyDescription;
    /* location of the agency for GoogleMap*/
    private String location;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sellerEntity", fetch = FetchType.LAZY)
    /* all advertisements of this agency */
    private List<ProductEntity> productEntityList = new ArrayList<>();
}
