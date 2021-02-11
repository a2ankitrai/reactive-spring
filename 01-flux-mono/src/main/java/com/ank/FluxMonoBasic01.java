package com.ank;

import lombok.extern.java.Log;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log
public class FluxMonoBasic01 {

    public static void main(String[] args) {

        log.info("\nFlux just: ");
        Flux<Integer> just = Flux.just(1, 2, 3, 4);
        just.log().subscribe();

        log.info("\nMono just: ");
        Mono<Integer> monoJust = Mono.just(1);
        monoJust.log().subscribe();
    }
}
