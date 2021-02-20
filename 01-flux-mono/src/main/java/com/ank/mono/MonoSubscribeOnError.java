package com.ank.mono;

import reactor.core.publisher.Mono;

public class MonoSubscribeOnError {

    public static void main(String[] args) {

        Mono<Integer> data = Mono.just("data")
                                 .map(String::length)
                                 .map(val -> val / 0);

        data.subscribe(
                val -> System.out.println("Received : " + val),
                err -> System.out.println("Error occurred : " + err.getMessage()),
                () -> System.out.println("Mono Complete")
        );
    }
}
