package com.ank.flux.helper;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _16FluxTake {

    public static void main(String[] args) {

        Flux.range(1, 10)
            .log()
            .take(3)
            .log()
            .subscribe(Util.subscriber());
    }
}
