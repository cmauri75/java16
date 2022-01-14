package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class UnaryAndRecord {

    public static void main(String[] args) {
        IntUnaryOperator increment = i -> i == Integer.MAX_VALUE ? Integer.MIN_VALUE : ++i;

        int k = 3;
        int j = increment.applyAsInt(k);

        System.out.format("Start %d --> %d\n", k, j);

        UnaryOperator<MinMax> incrementP = mm -> new MinMax(increment.applyAsInt(mm.min), increment.applyAsInt(mm.max));
        System.out.println(incrementP.apply(new MinMax(0, 10)));

        var list = new ArrayList<String>();
        list.add("good");
        var sc = new ShoppingCart(list);
        list.add("bad");
        System.out.println(sc);

    }

    record MinMax(int min, int max) {
        //canonical contructor in compact form
        MinMax {
            if (min > max) {
                throw new IllegalArgumentException();
            }
        }
    }


    record ShoppingCart(List<String> products) {
        //Good practice
        ShoppingCart(List<String> products) {
            this.products = List.copyOf(products);
        }
    }
}
