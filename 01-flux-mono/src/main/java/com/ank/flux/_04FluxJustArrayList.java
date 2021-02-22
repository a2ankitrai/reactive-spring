package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class _04FluxJustArrayList {

    public static void main(String[] args) {

        List<String> stringList = List.of("a", "b", "c", "d");
        Flux.just(stringList)
            .subscribe(Util.onNext());

        System.out.println("\n----\n");

        String[] arr = { "w", "x", "y", "z" };
        Flux.just(arr)
            .subscribe(Util.onNext());

    }
}
