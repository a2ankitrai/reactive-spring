package com.ank.flux;

import com.ank.flux.helper.NameProducer;
import com.ank.util.Util;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

public class _14FluxCreateRefactor {

    public static void main(String[] args) {

        NameProducer nameProducer = new NameProducer();

        Flux.create(nameProducer)
            .subscribe(Util.subscriber());

        IntStream.range(0, 5)
                 .forEach(i -> {
                     nameProducer.produce();
                 });
    }
}
