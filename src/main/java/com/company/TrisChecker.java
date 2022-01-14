package com.company;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.stream.Collectors;


public class TrisChecker {
    public static void main(String[] args) {
        check();
        System.out.println(resolve("XOX","XOO", "OXX"));
        System.out.println(resolve("XXX","XOX", "XXX"));
        System.out.println(resolve("OOX","OOX", "OOO"));
        System.out.println(resolve("XXX","OOO", "XXX"));
        System.out.println(resolve("XXX","XXX", "XXX"));

    }


    public static String resolve(String topRow, String middleRow, String bottomRow){
        int[] check = {0,1,2,3,4,5,6,7,8,0,3,6,1,4,7,2,5,8,0,4,8,2,4,6};
        List<Integer> iData = (topRow+middleRow+bottomRow).chars().mapToObj(c -> (char) c =='X'?0:1).collect(Collectors.toList());
        int total=0;
        for (int i=0;i<check.length;i+=3) {
            int res = iData.get(check[i]) + iData.get(check[i + 1]) + iData.get(check[i + 2]);
            total = (res==0)?total+1:res==3?total+10:total;
        }
        return total==0?"False":total<=8?"X":total%10==0?"O":"False";
    }


    public static void check(){
        String str = "abcasdfghjicnocnwioecnoiwncoiewincweion";
        int length = 10000;
        try{Thread.sleep(100);} catch (InterruptedException e){};
        boolean useLetters = true;
        boolean useNumbers = false;
        String generatedString = RandomStringUtils.random(length, useLetters, useNumbers);

        List<Character> iData = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        String back = (iData.toString()
                .substring(1, 3 * iData.size() - 1)
                .replaceAll(", ", ""));

        System.err.println(str.equals(back));
    }

}
