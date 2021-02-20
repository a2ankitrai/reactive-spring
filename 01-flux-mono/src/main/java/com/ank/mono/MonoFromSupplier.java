package com.ank.mono;

import com.ank.util.Util;
import reactor.core.publisher.Mono;

public class MonoFromSupplier {

    public static void main(String[] args) {

        /**
         * getName() will get called even when we have not subscribed
         * to the Mono. This leads to eager evaluation
         *
         * Use Mono.just only when you already have the data
         * */
        // Mono<String> just = Mono.just(getName());

        /**
         * creating Mono from Supplier is a lazy evaluation and the getName() method
         * is not executed upon creation but rather on subscribing
         * */
        Mono<String> stringMono = Mono.fromSupplier(MonoFromSupplier::getName);
        stringMono.subscribe(Util.onNext());

    }

    private static String getName() {
        System.out.println("Generating name...");
        // time consuming process
        return Util.faker().name().fullName();
    }
}
