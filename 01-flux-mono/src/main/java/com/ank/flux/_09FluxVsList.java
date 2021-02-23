package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class _09FluxVsList {

    public static void main(String[] args) {

        /**
         * Printing the list takes time as it waits for all elements to be accumulated
         * */

        System.out.println("Printing from List");
        List<String> stringList = IntStream.range(1, 6)
                                           .mapToObj(i -> getName())
                                           .collect(Collectors.toList());
        System.out.println(stringList);

        /**
         * Printing from the Stream pipeline generates elements one by one
         * */
        System.out.println("Printing from Stream");
        IntStream.range(1, 6)
                 .mapToObj(i -> getName())
                 .forEach(System.out::println);


        /**
         * Flux provides the elements as soon as they are available.
         * */
        Flux.range(1, 5)
            .map(i -> getName())
            .subscribe(Util.onNext());
    }

    /**
     * time consuming method
     */
    private static String getName() {
        Util.sleepMillis(500);
        return Util.faker().name().fullName();
    }
}
