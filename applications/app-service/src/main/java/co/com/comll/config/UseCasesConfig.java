package co.com.comll.config;

import co.com.comll.model.gateways.UserGateway;
import co.com.comll.r2dbc.UserRepository;
import co.com.comll.r2dbc.mapper.Mapper;
import co.com.comll.r2dbc.service.UserService;
import co.com.comll.usecase.UserUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "co.com.comll.usecase",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$")
        },
        useDefaultFilters = false)
public class UseCasesConfig {
        @Bean
        public UserUseCase userUseCase(UserGateway userGateway) {
                return new UserUseCase(userGateway);

        }

        @Bean
        public UserGateway userGateway(UserRepository userRepository,
                                       Mapper mapper) {
                return new UserService(userRepository, mapper);
        }
}
