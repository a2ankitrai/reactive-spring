package com.ank.flux;

import com.ank.flux.helper.NameProducer;
import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _15FluxCreateMultipleThreads {

    public static void main(String[] args) {

        var nameProducer = new NameProducer();

        Flux.create(nameProducer)
            .subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;

        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);
    }
}
