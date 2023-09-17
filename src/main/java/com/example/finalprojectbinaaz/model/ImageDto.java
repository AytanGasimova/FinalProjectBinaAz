package com.example.finalprojectbinaaz.model;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {
    /* for main photo */
    private boolean isPreviewImage;
    private String image;
}
