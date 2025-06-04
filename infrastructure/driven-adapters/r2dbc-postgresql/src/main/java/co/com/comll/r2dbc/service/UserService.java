package co.com.comll.r2dbc.service;

import co.com.comll.model.UserDTO;
import co.com.comll.model.config.UserErrorCode;
import co.com.comll.model.config.UserException;
import co.com.comll.model.gateways.UserGateway;

import co.com.comll.r2dbc.UserRepository;
import co.com.comll.r2dbc.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserService implements UserGateway {

    private final UserRepository userRepository;
    private final Mapper mapper;

    @Override
    public Mono<Void> saveNewUser(UserDTO userDTO) {
        var userEntity = mapper.mapToEntity(userDTO);
        return userRepository.save(userEntity)
                .then()
                .onErrorResume(error -> {
                    if (error instanceof DataIntegrityViolationException
                            || error.getMessage().contains("duplicate key")) {
                        return Mono.error(new UserException(
                                HttpStatus.CONFLICT.value(),
                                UserErrorCode.CRB00.getErrorCode(),
                                UserErrorCode.CRB00.getErrorTitle(),
                                "El usuario  ya existe"
                        ));
                    }
                    return Mono.error(error);
                });
    }
}
