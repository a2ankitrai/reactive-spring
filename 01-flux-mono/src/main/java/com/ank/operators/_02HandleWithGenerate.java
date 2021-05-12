package com.ank.operators;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _02HandleWithGenerate {

    public static void main(String[] args) {

        Flux.generate(synchronousSink ->
                              synchronousSink.next(Util.faker().country().name()))
            .map(Object::toString)
            .handle((s, synchronousSink) -> {

                synchronousSink.next(s);
                if (s.equalsIgnoreCase("india")) {
                    synchronousSink.complete();
                }
            })
            .subscribe(Util.subscriber());
    }

}
