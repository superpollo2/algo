package co.com.comll.model.gateways;

import co.com.comll.model.UserDTO;
import reactor.core.publisher.Mono;

public interface UserGateway {
    Mono<Void> saveNewUser(UserDTO userDTO);
}
