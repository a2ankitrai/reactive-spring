package com.ank.flux;

import reactor.core.publisher.Flux;

public class _02FluxMultipleSubscriber {

    public static void main(String[] args) {

        Flux<Integer> just = Flux.just(1, 2, 3, 4);

        Flux<Integer> evenIntegerFlux = just.filter(i -> i % 2 == 0);

        just.subscribe(val -> System.out.println("Sub 1: " + val));

        evenIntegerFlux.subscribe(val -> System.out.println("Sub 2: " + val));

    }

}
