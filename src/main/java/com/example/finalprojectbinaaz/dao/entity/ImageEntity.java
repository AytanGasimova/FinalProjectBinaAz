package com.example.finalprojectbinaaz.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "images")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /* for main photo */
    private boolean isPreviewImage;
    @Column(columnDefinition = "TEXT")
    private String image;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private ProductEntity productEntity;
}
