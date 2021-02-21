package com.ank.mono;

import com.ank.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class MonoSupplierAsync {

    public static void main(String[] args) {

        getName();

        // executing the pipeline
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext());

        getName();

        Util.sleepSeconds(4);
    }

    private static Mono<String> getName() {
        System.out.println("entered getName method");

        // Building the pipeline
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name..");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
