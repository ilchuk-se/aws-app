package com.ailchuck.aws.mapper;

import com.ailchuck.aws.dto.ImageInfoDTO;
import com.ailchuck.aws.entity.Image;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImageMapper {

    ImageInfoDTO toImageInfoDTO(Image image);

}
