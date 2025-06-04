package co.com.comll.usecase;

import co.com.comll.model.UserDTO;
import co.com.comll.model.gateways.UserGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UserUseCase {

    private final UserGateway userGateway;

    public Mono<Void> registerNewUser(UserDTO userDTO) {
        return userGateway.saveNewUser(userDTO);
    }

}
