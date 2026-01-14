package com.phinderuserproject.userproject.service;

import java.util.List;

import com.phinderuserproject.userproject.dto.UserDTO;

public interface IUserService {

    List<UserDTO> findAll();
    UserDTO findUserByID(Integer id);
    UserDTO createUser(UserDTO userDto);
    UserDTO updateUser(Integer id, UserDTO dto);
    void deleteUser(Integer id);
}
