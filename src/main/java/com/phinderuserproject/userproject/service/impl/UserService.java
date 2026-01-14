package com.phinderuserproject.userproject.service.impl;


import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.phinderuserproject.userproject.dto.UserDTO;
import com.phinderuserproject.userproject.exception.UserNotFoundException;
import com.phinderuserproject.userproject.mapper.Mapper;
import com.phinderuserproject.userproject.mapper.UserMapper;
import com.phinderuserproject.userproject.model.Direction;
import com.phinderuserproject.userproject.model.User;
import com.phinderuserproject.userproject.repository.UserRepository;
import com.phinderuserproject.userproject.service.IUserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;



    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll().stream().filter(x -> Boolean.TRUE.equals(x.getActive())).map(Mapper::toDto).collect(Collectors.toList());
    }



    @Override
    public UserDTO findUserByID(Integer id) {
        User user = userRepository.findById(id)
            .filter(u -> Boolean.TRUE.equals(u.getActive())) 
            .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado o inactivo"));
            
    return Mapper.toDto(user);
    }

    @Transactional
    @Override
    public UserDTO createUser(UserDTO userDto) {
        
        if (userDto == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        
        if (userDto.getDirection() == null) {
            throw new IllegalArgumentException("La dirección no puede ser nula");
        }

        Direction direction = Direction.builder()
                    .street(userDto.getDirection().getStreet())
                    .intNum(userDto.getDirection().getIntNum())
                    .extNum(userDto.getDirection().getExtNum())
                    .suburb(userDto.getDirection().getSuburb())
                    .zipCode(userDto.getDirection().getZipCode())
                    .municipality(userDto.getDirection().getMunicipality())
                    .state(userDto.getDirection().getState())
                    .build();


        User user = User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .patSurname(userDto.getPatSurname())
                .matSurname(userDto.getMatSurname())
                .birthDate(userDto.getBirthDate())
                .gender(userDto.getGender())
                .curp(userDto.getCurp())
                .rfc(userDto.getRfc())
                .active(true)
                .direction(direction)
                .build();

            userRepository.save(user);

            return Mapper.toDto(user);


    }
    
    @Transactional
    @Override
    public UserDTO updateUser(Integer id, UserDTO dto) {
        
        User user = userRepository.findById(id)
            .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        
        userMapper.updateUserFromDto(dto, user);

        
        userRepository.save(user);

        
        return userMapper.toDto(user);
    }


    @Transactional
    @Override
    public void deleteUser(Integer id) {

        User user = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

        user.setActive(false);
        userRepository.save(user);
    }

}
