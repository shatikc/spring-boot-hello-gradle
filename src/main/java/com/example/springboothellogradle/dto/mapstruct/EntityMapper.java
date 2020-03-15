package com.example.springboothellogradle.dto.mapstruct;

import com.example.springboothellogradle.dto.UserDtoModel;
import com.example.springboothellogradle.dto.UserResponseDTO;
import com.example.springboothellogradle.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EntityMapper {

    @Mapping(source = "email", target = "user_email")
    User toUser(UserDtoModel userDtoModel);

    @Mapping(source = "user_email", target = "email")
    UserDtoModel toUserDtoModel(User user);

    @Mapping(source = "user_email", target = "email")
    UserResponseDTO toUserResponseDTO(User user);
}
