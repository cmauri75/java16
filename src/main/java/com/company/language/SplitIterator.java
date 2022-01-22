package com.company.language;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SplitIterator {
    public static void main(String[] args) {

        List<String> articles = generateElements();
        Spliterator<String> spliterator = articles.spliterator();

        int expected = Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;

        System.out.println(spliterator.characteristics() == expected);  //true

        System.out.println(spliterator.estimateSize());
        System.out.println(spliterator.getExactSizeIfKnown());

        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.add("F");

        Spliterator<String> spliterator1 = list.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();

        spliterator1.forEachRemaining(System.out::println);
        System.out.println("========");
        spliterator2.forEachRemaining(System.out::println);
    }

    public static List<String> generateElements() {
        return Stream.generate(() -> new String(new Random().nextLong()+""))
                .limit(35000)
                .collect(Collectors.toList());
    }


}
