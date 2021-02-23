package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _12FluxToMono {

    public static void main(String[] args) {

        Flux.range(1, 10)
            .filter(i -> i > 3)
            .next()
            .subscribe(Util.onNext(),
                       Util.onError(),
                       Util.onComplete()
            );

    }
}
