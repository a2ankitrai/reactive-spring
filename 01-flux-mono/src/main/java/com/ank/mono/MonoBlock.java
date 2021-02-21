package com.ank.mono;

import com.ank.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class MonoBlock {
    public static void main(String[] args) {

        getName();

        // executing the pipeline
        String nameString = getName()
                .subscribeOn(Schedulers.boundedElastic())
                .block();
        System.out.println("Name String Block: " + nameString);

        getName();

        Util.sleepSeconds(2);
    }

    private static Mono<String> getName() {
        System.out.println("entered getName method");

        // Building the pipeline
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name..");
            Util.sleepSeconds(1);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
