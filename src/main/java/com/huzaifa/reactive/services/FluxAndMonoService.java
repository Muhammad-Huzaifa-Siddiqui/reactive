package com.huzaifa.reactive.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static java.lang.System.out;
import java.util.List;

public class FluxAndMonoService {
    public Flux<String> fruitsFlux(){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana")).log();
    }
    public Mono<String>fruitsMono(){
        return Mono.just("Mango").log();
    }

    public Flux<String> fruitsFluxMap(){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .map(String::toUpperCase)
                .log();
    }
    public Mono<String>fruitsMonoMap(){
        return Mono.just("Mango")
                .map(String::toLowerCase)
                .log();
    }

    public Flux<String> fruitsFluxFilter(int number){
        return Flux.fromIterable(List.of("Mango", "Orange", "Banana"))
                .filter(fruit->fruit.length()>number)
                .log();
    }

    public static void main(String[] args) {
        FluxAndMonoService fluxAndMonoService
                = new FluxAndMonoService();

        fluxAndMonoService.fruitsFlux()
                .subscribe(fruits ->{
                    out.println("fruits = " + fruits);
                });
        fluxAndMonoService.fruitsMono()
                .subscribe(fruit ->{
                    out.println("Mono -> Fruit = "+fruit);
                });
    }
}
