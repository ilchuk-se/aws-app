package com.ailchuck.aws.service;

import com.ailchuck.aws.dto.ImageUploadDTO;
import org.springframework.http.ResponseEntity;

public interface AWSImageService {

    ResponseEntity<?> uploadImage(ImageUploadDTO dto);

    ResponseEntity<?> downloadImage(String fileName);

    ResponseEntity<?> getImagesInfo(String fileName, Boolean randomEnable);

    ResponseEntity<?> invokeImageLambda();

}
