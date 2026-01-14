package com.phinderuserproject.userproject.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.phinderuserproject.userproject.dto.UserDTO;
import com.phinderuserproject.userproject.model.User;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    void updateUserFromDto(UserDTO dto, @MappingTarget User user);

    UserDTO toDto(User user);
}
