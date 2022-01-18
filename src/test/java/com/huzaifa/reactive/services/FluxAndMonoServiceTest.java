package com.huzaifa.reactive.services;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class FluxAndMonoServiceTest {

    FluxAndMonoService fluxAndMonoService
            = new FluxAndMonoService();

    @Test
    void fruitsFlux() {
        var fruitsFlux = fluxAndMonoService.fruitsFlux();
        StepVerifier.create(fruitsFlux)
                .expectNext("Mango","Orange","Banana")
                .verifyComplete();
    }

    @Test
    void fruitsMono() {
        var fruitsMono = fluxAndMonoService.fruitsMono();
        StepVerifier.create(fruitsMono)
                .expectNext("Mango")
                .verifyComplete();
    }

    @Test
    void fruitsFluxMap() {
        var fruitsFluxMap = fluxAndMonoService.fruitsFluxMap();
        StepVerifier.create(fruitsFluxMap)
                .expectNext("MANGO","ORANGE","BANANA")
                .verifyComplete();
    }

    @Test
    void fruitsMonoMap() {
        var fruitsMonoMap = fluxAndMonoService.fruitsMonoMap();
        StepVerifier.create(fruitsMonoMap)
                .expectNext("mango")
                .verifyComplete();
    }

    @Test
    void fruitsFluxFilter() {
        var fruitsFluxFilter = fluxAndMonoService.fruitsFluxFilter(5).log();
        StepVerifier.create(fruitsFluxFilter)
                .expectNext("Orange","Banana")
                .verifyComplete();
    }
}