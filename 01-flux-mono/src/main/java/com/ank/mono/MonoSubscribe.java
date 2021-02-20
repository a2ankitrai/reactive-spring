package com.ank.mono;

import reactor.core.publisher.Mono;

public class MonoSubscribe {

    public static void main(String[] args) {

        Mono<String> data = Mono.just("data");

        /**1: this will make the mono emit data
         * but as we are no doing anything in subscribe, no value will be printed
         */
        //data.subscribe();

        /**
         * 2. Providing onNext, onError & onComplete implementation
         * */
        data.subscribe(
                val -> System.out.println("Received : " + val),
                err -> System.out.println("Error occurred : " + err.getMessage()),
                () -> System.out.println("Mono Complete")
        );
    }
}
