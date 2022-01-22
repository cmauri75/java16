package com.company.language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toCollection;

public class ExactOne {
    public static void main(String[] args) throws Exception {

        List<String> one = List.of("1", "2", "3");
        List<String> multi = List.of("1", "2", "3", "2");

        var testCase = Arrays.asList(one, multi);

        for (var data : testCase) {
            boolean unique = true;
            List<String> mMulti = data.stream().collect(toCollection(ArrayList::new));
            mMulti.sort(String::compareTo);
            for (int i = 1; i < mMulti.size(); i++) {
                if (mMulti.get(i).equals(mMulti.get(i - 1))) {
                    unique = false;
                    i = multi.size();
                }
            }
            System.out.println(data+ " "+unique);
        }

        System.out.println(exactMatch(one, s -> s.equals("1")));
        System.out.println(exactMatch(multi, s -> s.equals("2")));
    }

    static <T> T exactMatch(List<T> list, Predicate<T> predicate) throws Exception {
        T result = null;
        for (T element : list) {
            if (predicate.test(element)) {
                if (result != null) throw new Exception("Duplicate");
                result = element;
            }
        }
        if (result == null) throw new NoSuchElementException();
        return result;
    }
}
