package ua.gaponov;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static String printNamesList(List<String> names) {
        StringJoiner result = new StringJoiner(", ");
        IntStream.range(0, names.size())
                .forEach(index -> {
                    if (index % 2 != 0) {
                        result.add("" + index + ". " + names.get(index));
                    }
                });
        return result.toString();
    }

    public static List<String> getSortNames(List<String> names) {
        return names
                .stream()
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public static String getArraysDigit(String[] digits) {
        BinaryOperator<String[]> concatArrays = (array1, array2) -> {
            String[] result = new String[array1.length + array2.length];
            System.arraycopy(array1, 0, result, 0, array1.length);
            System.arraycopy(array2, 0, result, array1.length, array2.length);
            return result;
        };


        List<String> result = Arrays.stream(Arrays.stream(digits)
                        .map(digit -> digit.split(", "))
                        .reduce(concatArrays::apply)
                        .orElse(null))
                        .map(Integer::parseInt)
                        .sorted()
                        .map(String::valueOf)
                        .collect(Collectors.toList());


        return String.join(", ", result);
    }


    public static Stream<Long> getRandomInt(long a, long c, long m) {
        long seed = System.currentTimeMillis();

        return Stream.iterate(new long[]{seed}, x -> new long[]{(a * x[0] + c) % m})
                .map(x -> x[0]).skip(1);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){

        List<T> resultList = new ArrayList<>();

        List<T> firstList = first.collect(Collectors.toList());
        List<T> secondList = second.collect(Collectors.toList());

        long sizeFirst = firstList.size();
        long sizeSecond = secondList.size();

        long minSize = Math.min(sizeFirst, sizeSecond);

        for (int i = 0; i < minSize; i++){
            resultList.add(firstList.get(i));
            resultList.add(secondList.get(i));
        }

        return resultList.stream();

    }

}
