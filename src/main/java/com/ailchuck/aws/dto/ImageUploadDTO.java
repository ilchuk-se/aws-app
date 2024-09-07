package com.ailchuck.aws.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageUploadDTO {

    private String name;
    private MultipartFile image;

}
