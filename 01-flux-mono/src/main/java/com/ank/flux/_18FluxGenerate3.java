package com.ank.flux;

import com.ank.util.Util;
import reactor.core.publisher.Flux;

public class _18FluxGenerate3 {

    public static void main(String[] args) {

        Flux.generate(() -> 1,
                      (counter, sink) -> {
                          String country = Util.faker().country().name();
                          sink.next(country);
                          if (counter >= 10 || country.toLowerCase().equals("canada"))
                              sink.complete();
                          return counter + 1;
                      })
            .take(3)
            .subscribe(Util.subscriber());
    }
}
