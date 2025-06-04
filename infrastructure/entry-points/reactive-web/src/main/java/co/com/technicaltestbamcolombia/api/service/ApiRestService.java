package co.com.technicaltestbamcolombia.api.service;

import co.com.comll.model.UserDTO;
import co.com.comll.usecase.UserUseCase;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class ApiRestService {
    private final UserUseCase userUseCase;
    private final ObjectMapper objectMapper;



    public Mono<Void> newUser(JsonNode body) {
        var userInfo = objectMapper.convertValue(body, UserDTO.class);
        return userUseCase.registerNewUser(userInfo);

    }




}
