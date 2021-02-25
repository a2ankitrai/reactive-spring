package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _17FluxTakeWithCancelled {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            String country;

            /*
             * without the !fluxSink.isCancelled() the create method will keep on emitting the items
             * even when take() operator has cancelled the subscription.
             * */
            do {
                country = Util.faker().country().name();
                System.out.println("Emitting: " + country);
                fluxSink.next(country);
            } while (!country.toLowerCase().equals("india") && !fluxSink.isCancelled());

            fluxSink.complete();
        })
            .take(3)
            .subscribe(Util.subscriber());
    }
}
