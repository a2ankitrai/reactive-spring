package com.ank.operators;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _03DoCallbacks {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            System.out.println("inside create");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
//            fluxSink.error(new RuntimeException("ook"));
            fluxSink.complete();
            System.out.println("--completed");
        })
            .doOnComplete(() -> System.out.println("doOnComplete"))
            .doFirst(() -> System.out.println("doFirst 1"))
            .doOnNext(o -> System.out.println("doOnNext : " + o))
            .doOnSubscribe(subscription -> System.out.println("doOnSubscribe : " + subscription))
            .doOnRequest(l -> System.out.println("doOnRequest : " + l))
//            .doFirst(() -> System.out.println("doFirst 2"))
            .doOnError(err -> System.out.println("doOnError: " + err))
            .doOnTerminate(() -> System.out.println("doOnTerminate"))
            .doOnCancel(() -> System.out.println("doOnCancel"))
//            .doFirst(() -> System.out.println("doFirst 3"))
            .doFinally(signalType -> System.out.println("doFinally : " + signalType))
            .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard : " + o))
//            .take(2)
            .subscribe(Util.onNext());
    }
}
