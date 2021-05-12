package com.ank.operators;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _01Handle {

    public static void main(String[] args) {

        Flux.range(1, 20)
            .handle((integer, synchronousSink) -> {

                if (integer % 2 == 0) {
                    synchronousSink.next(integer);
                } else {

                    if (integer == 17) {
                        synchronousSink.complete();
                    } else {
                        synchronousSink.next("odd: " + integer);
                    }

                }
            })
            .subscribe(Util.subscriber());

    }
}
