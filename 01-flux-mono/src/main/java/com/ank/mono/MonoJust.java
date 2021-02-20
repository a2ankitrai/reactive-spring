package com.ank.mono;

import reactor.core.publisher.Mono;

public class MonoJust {

    public static void main(String[] args) {

        final Mono<Integer> just = Mono.just(1);

        System.out.println(just);

        just.subscribe(val -> System.out.println("Received value " + val));

    }
}
