package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class _05FluxStream {

    public static void main(String[] args) {

        //Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5);

        //stream1.forEach(System.out::println);

        /* Using stream second time will throw
               java.lang.IllegalStateException:
               stream has already been operated upon or closed
         */
        // stream1.forEach(System.out::println);

        List<Integer> integerList = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = integerList.stream();

        /*
         * Below ways of creating Flux from Stream can be used only and
         * will throw the Exception if the Flux is subscribed second time.
         * */
        // Flux<Integer> integerFlux = Flux.fromStream(stream);

        // Flux<Integer> integerFlux = Flux.fromStream(() -> stream);


        /*
         * Below is the correct way of the implementing the same.
         * With this implementation, both the subscriber will get the items.
         * */
        Flux<Integer> integerFlux = Flux.fromStream(() -> integerList.stream());

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

    }
}
