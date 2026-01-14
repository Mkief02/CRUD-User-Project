package com.phinderuserproject.userproject.mapper;



import com.phinderuserproject.userproject.dto.DirectionDTO;
import com.phinderuserproject.userproject.dto.UserDTO;
import com.phinderuserproject.userproject.model.Direction;
import com.phinderuserproject.userproject.model.User;

public class Mapper {

    private Mapper (){}
    
    public static UserDTO toDto(User user) {
        if (user == null) return null;

        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .patSurname(user.getPatSurname())
                .matSurname(user.getMatSurname())
                .birthDate(user.getBirthDate())
                .gender(user.getGender())
                .curp(user.getCurp())
                .rfc(user.getRfc())
                .direction(user.getDirection() != null ? toDto(user.getDirection()) : null)
                .build();
    }

    private static DirectionDTO toDto (Direction direction){
        if (direction == null) return null;

        return DirectionDTO.builder()
                .street(direction.getStreet())
                .intNum(direction.getIntNum())
                .extNum(direction.getExtNum())
                .suburb(direction.getSuburb())
                .zipCode(direction.getZipCode())
                .municipality(direction.getMunicipality())
                .state(direction.getState())
                .build();
    }

}
