package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _01FluxBasic {

    public static void main(String[] args) {

        Flux<Integer> just = Flux.just(1, 2, 3);

        just.subscribe(Util.onNext(),
                       Util.onError(),
                       Util.onComplete()
        );

        Flux<Object> justObject = Flux.just(1, 'a', "String", Util.faker().name());
        justObject.subscribe(Util.onNext(),
                             Util.onError(),
                             Util.onComplete()
        );


    }

}
