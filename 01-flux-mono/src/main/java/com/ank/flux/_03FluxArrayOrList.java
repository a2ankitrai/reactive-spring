package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class _03FluxArrayOrList {

    public static void main(String[] args) {

        List<String> stringList = List.of("a", "b", "c", "d");

        Flux.fromIterable(stringList)
            .subscribe(Util.onNext());

        System.out.println("\n\n");

        Integer[] arr = { 1, 2, 3, 4 };
        Flux.fromArray(arr)
            .subscribe(Util.onNext());


    }
}
