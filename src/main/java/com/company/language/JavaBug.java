package com.company.language;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class JavaBug {
    public static void main(String[] args) {
        var listOf = List.of("ONE", "two", "Three", "four", "five");
        var count = listOf.stream().peek(System.err::println).map(e -> e.toLowerCase(Locale.ROOT)).count();
        System.out.println(count);

        var list = new ArrayList<String>();
        var cont = listOf.stream().map(s -> {
            list.add(s);
            return s.toLowerCase();
        }).count();
        System.err.println(list + " " + cont);

    }
}
