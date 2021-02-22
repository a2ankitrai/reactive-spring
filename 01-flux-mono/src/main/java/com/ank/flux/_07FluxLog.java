package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _07FluxLog {

    public static void main(String[] args) {

        Flux.range(1, 4)
            .log()
            .map(val -> Util.faker().name().fullName())
            .log()
            .subscribe(Util.onNext());
    }
}
