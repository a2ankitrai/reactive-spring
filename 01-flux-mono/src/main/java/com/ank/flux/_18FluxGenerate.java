package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _18FluxGenerate {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {

            String country = Util.faker().country().name();
            System.out.println("Emitting: " + country);

            synchronousSink.next(country);

            // Calling next again will throw an error.
            // synchronousSink.next("Another");
        })
            .take(2)
            .subscribe(Util.subscriber());
    }
}
