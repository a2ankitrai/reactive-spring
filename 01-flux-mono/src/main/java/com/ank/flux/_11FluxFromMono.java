package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class _11FluxFromMono {

    public static void main(String[] args) {

        Mono<String> mono = Mono.just("a");

        Flux.from(mono)
            .subscribe(Util.onNext(),
                       Util.onError(),
                       Util.onComplete());

    }

}
