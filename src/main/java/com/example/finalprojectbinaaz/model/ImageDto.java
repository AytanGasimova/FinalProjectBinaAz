package com.example.finalprojectbinaaz.model;

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
