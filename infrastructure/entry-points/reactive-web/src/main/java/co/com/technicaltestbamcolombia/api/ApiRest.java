package co.com.technicaltestbamcolombia.api;

import co.com.technicaltestbamcolombia.api.service.ApiRestService;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
@Log4j2
public class ApiRest {

    private final ApiRestService apiRestService;


    @ResponseStatus(HttpStatus.OK)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, path = "new/user")
    public Mono<Void> createNewUser(@RequestBody JsonNode body) {
        var init = Instant.now();
        log.info("eso " + body);
        return Mono.just(body)
                .doFirst(() -> log.info("Iniciando registro nuevo usuario"))
                .flatMap(apiRestService::newUser)
                .doAfterTerminate(() ->
                        log.info("Finalización del request, " +
                                        "tiempo procesando la solicitud en milis: {}",
                                ChronoUnit.MILLIS.between(init, Instant.now())));
    }



}