package com.example.finalprojectbinaaz.dao.entity;

import com.example.finalprojectbinaaz.enums.AdvertisementType;
import com.example.finalprojectbinaaz.enums.CategoryType;
import com.example.finalprojectbinaaz.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products_ad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /* number of advertisement */
    private Long id;
    private String district;
    private String metro;
    /* shooting - mark (nişangah)*/
    private String mark;
    /* in which city is situated */
    private String city;
    /* on what floor it locate */
    private Integer onWhatFloor;
    /* number of floors */
    private Integer numberOfFloor;
    /* the price of the object, which is for selling or renting */
    private Double price;
    /* selling, rent, agencies, residential complexes */
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    /* new or old apartments, villas, offices, garages, lands, objects */
    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
    /* VIP or simple advertisements */
    @Enumerated(EnumType.STRING)
    private AdvertisementType advertisementType;
    /* information about object */
    @Column(columnDefinition = "TEXT")
    private String description;
    /* date of advertisement's creation */
//    @CreatedDate
//    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;
    private Double productArea;
    private Integer countOfRoom;
    /* the object was renovated or not */
    private boolean isRenovated;
    private boolean hasDocument;
    private boolean isMortgageable;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private SellerEntity sellerEntity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productEntity", fetch = FetchType.LAZY)
    private List<ImageEntity> imageEntityList;

    /* for main photo */
    private Long previewImageId;
}
