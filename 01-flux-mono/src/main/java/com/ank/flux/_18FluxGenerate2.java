package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _18FluxGenerate2 {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {

            String countryName = Util.faker().country().name();

            synchronousSink.next(countryName);

            if (countryName.toLowerCase().equals("canada")) {
                synchronousSink.complete();
            }

        }).subscribe(Util.subscriber());

    }
}
