package com.ank.util;

import com.github.javafaker.Faker;

import java.util.stream.Stream;

public class FakerDemo {

    public static void main(String[] args) {

        Faker faker = Faker.instance();

        System.out.println("Names: ");
        Stream.generate(() -> faker.name().fullName())
              .limit(5)
              .forEach(System.out::println);

        System.out.println("\n\nPokemon:");
        Stream.generate(() -> faker.pokemon().name())
              .limit(5)
              .forEach(System.out::println);

        System.out.println("\n\nChuck Norris:");
        Stream.generate(() -> faker.chuckNorris().fact())
              .limit(5)
              .forEach(System.out::println);

        System.out.println("\n\nBeer:");
        Stream.generate(() -> faker.beer().name())
              .limit(5)
              .forEach(System.out::println);
    }
}
