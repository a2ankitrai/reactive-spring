package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _13FluxCreate {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {

            String country;
            do {
                country = Util.faker().country().name();
                fluxSink.next(country);
            } while (!country.toLowerCase().equals("india"));

            fluxSink.complete();
        })
            .subscribe(Util.subscriber("MySub1"));
    }
}
