package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _06FluxRange {

    public static void main(String[] args) {

        Flux.range(2, 5)
            .subscribe(Util.onNext());

        System.out.println();

        Flux.range(10, 4)
            .map(val -> Util.faker().name().fullName())
            .subscribe(Util.onNext());
    }
}
