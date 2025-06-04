package co.com.comll.r2dbc.mapper;

import co.com.comll.model.UserDTO;
import co.com.comll.r2dbc.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public UserEntity mapToEntity(UserDTO userDTO){
        return UserEntity.builder()
                .apellidos(userDTO.getApellidos())
                .estadoCivil(userDTO.getEstadoCivil())
                .cedula(userDTO.getCedula())
                .ciudadResidencia(userDTO.getCiudadResidencia())
                .nombres(userDTO.getNombres())
                .fechaNacimiento(userDTO.getFechaNacimiento())
                .build();

    }
}
