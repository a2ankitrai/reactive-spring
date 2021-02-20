package com.ank.mono;

import com.ank.util.Util;
import reactor.core.publisher.Mono;

public class MonoEmptyOrError {

    public static void main(String[] args) {

        System.out.println("\nValid scenario");
        userRepository(1)
                .subscribe(Util.onNext(),
                           Util.onError(),
                           Util.onComplete());

        System.out.println("\nEmpty scenario");
        userRepository(2)
                .subscribe(Util.onNext(),
                           Util.onError(),
                           Util.onComplete());

        System.out.println("\nError scenario");
        userRepository(3)
                .subscribe(Util.onNext(),
                           Util.onError(),
                           Util.onComplete());

    }

    private static Mono<String> userRepository(int id) {

        if (id == 1) {
            return Mono.just(Util.faker().name().fullName());
        } else if (id == 2) {
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("Invalid id provided"));
        }
    }
}
