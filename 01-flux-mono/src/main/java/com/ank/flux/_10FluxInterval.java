package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class _10FluxInterval {

    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(1))
            .subscribe(Util.onNext());

        /**
         * first argument: initial delay
         * second argument: periodic interval
         * */
//        Flux.interval(Duration.ofSeconds(3),Duration.ofSeconds(1))
//            .subscribe(Util.onNext());


        Util.sleepSeconds(15);

    }
}
