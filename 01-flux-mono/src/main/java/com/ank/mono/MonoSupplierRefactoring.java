package com.ank.mono;

import com.ank.util.Util;
import reactor.core.publisher.Mono;

public class MonoSupplierRefactoring {

    public static void main(String[] args) {

        getName();

        // executing the pipeline
        getName()
                .subscribe(Util.onNext());

        getName();
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
