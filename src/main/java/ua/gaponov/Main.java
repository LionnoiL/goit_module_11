package ua.gaponov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Peter");
        names.add("Andriy");
        names.add("Angelina");
        names.add("Semen");
        names.add("Marina");
        names.add("Polina");

        String[] digits = {"1, 2, 0", "4, 5"};

        Utils.printNamesList(names);

        System.out.println(Utils.getSortNames(names));

        System.out.println(Utils.getArraysDigit(digits));

        long a = 25214903917L;
        long c = 11L;
        long m = 2 ^ 48L;

        Stream<Long> randomInt = Utils.getRandomInt(a, c, m);

        System.out.println(Arrays.toString(randomInt.limit(10).toArray()));


        Stream<Integer> first = Stream.of(1, 2, 3, 4, 5, 6, 7);
        Stream<Integer> second = Stream.of(10, 20, 30, 40);

        System.out.println(Utils.zip(first, second).collect(Collectors.toList()));

    }
}