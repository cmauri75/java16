package com.company.leetcode;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

//Intre & https://leetcode.com/problems/next-greater-element-iii
public class MaxNumber {
    public static void main(String[] args) {
        SolutionLC solutionLC = new SolutionLC();
        System.out.println("1234 = " + (solutionLC.nextGreaterElement(1234) == 1243));
        System.out.println("1321 = " + (solutionLC.nextGreaterElement(1321) == 2113));
        System.out.println("4321 = " + (solutionLC.nextGreaterElement(4321) == -1));
        System.out.println("9999 = " + (solutionLC.nextGreaterElement(9999) == -1));
        System.out.println("987654321 = " + (solutionLC.nextGreaterElement(987654321) == -1));
        System.out.println("2147483486 = " + (solutionLC.nextGreaterElement(2147483486) == -1));
        System.out.println("198765432 = " + (solutionLC.nextGreaterElement(198765432) == 213456789));
        System.out.println("1999999999 = " + (solutionLC.nextGreaterElement(1999999999) == 213456789));
        //System.out.println("198765432 = " + resolve("198765432"));
        System.out.println("1999999999 = " + resolve("1999999999"));


        if (3 == 3) return;
        System.out.println("1234 = " + resolve("1234").equals("1243"));
        System.out.println("1321 = " + resolve("1321").equals("2113"));
        System.out.println("4321 = " + resolve("4321").equals("4321"));
        System.out.println("9999 = " + resolve("9999").equals("9999"));
        System.out.println("987654321 = " + resolve("987654321").equals("987654321"));
        System.out.println("319014690630 = " + resolve("319014690630").equals("319014693006"));
        System.out.println("9876543210 = " + resolve("9876543210").equals("9876543210"));
        System.out.println("2147483486 = " + resolve("2147483486").equals("2147483648"));
    }

    static void permutation(Set<String> perm, String prefix, String str) {
        int n = str.length();
        if (n == 0) perm.add(prefix);
        else for (int i = 0; i < n; i++)
            permutation(perm, prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
    }

    static Set<String> permutation(String prefix, String str, String lowerLimit) {
        Set<String> perm = new HashSet<>();

        int n = str.length();
        if (n == 0) {
            perm.add(prefix);
            return perm;
        } else for (int i = 0; i < n; i++) {

            String leftPart = prefix + str.charAt(i);
            double checker = (Double.parseDouble(leftPart) + 1) * (Math.pow(10, lowerLimit.length() - leftPart.length())) - 1;
            //System.err.println("checker: "+checker+ " vs "+lowerLimit);
            if (checker > Double.parseDouble(lowerLimit)) {
                Set<String> newPerm = permutation(leftPart, str.substring(0, i) + str.substring(i + 1, n), lowerLimit);
                perm.addAll(newPerm);
            }
        }

        return perm;
    }

    static boolean isPermutation(long dv1, String v2) {
        char[] str1 = Long.toString(dv1).toCharArray();
        char[] str2 = v2.toCharArray();

        int NO_OF_CHARS = 58;
        int count[] = new int[NO_OF_CHARS];

        for (int i = 0; i < str1.length; i++) {
            count[str1[i]]++;
            count[str2[i]]--;
        }

        for (int i = 48; i < NO_OF_CHARS; i++)
            if (count[i] != 0)
                return false;
        return true;
    }

    public static boolean maxNum(String s1) {
        char array1[] = s1.toCharArray();
        List<Integer> arrI = new ArrayList<>();
        for (int i = 0; i < array1.length; i++)
            arrI.add(Character.getNumericValue(array1[i]));
        arrI.sort(Comparator.reverseOrder());

        StringBuffer s2 = new StringBuffer();
        for (int i : arrI)
            s2.append(i);

        return s1.equals(s2.toString());
    }

    public static String resolve(String numeroBase) {
        if (maxNum(numeroBase)) return numeroBase;

        Long nb = Long.parseLong(numeroBase);

        var maxDigit = numeroBase.chars().mapToObj(c -> Character.getNumericValue(c)).mapToInt(v -> v).max().getAsInt();
        Double mc = (maxDigit + 1) * Math.pow(10, numeroBase.length() - 1) - 1;
        long maxCandidate = mc.longValue();
        //System.out.println(numeroBase + " maxCandidate = " + BigDecimal.valueOf(maxCandidate).toString());


        for (long candidate = nb + 1; candidate < maxCandidate; candidate++) {
            System.err.println(candidate);
            if (isPermutation(candidate, numeroBase))
                return BigDecimal.valueOf(candidate).toString();
        }
        return numeroBase;

        /*
        Set<String> permAll = new HashSet<>();
        permutation(permAll, "", numeroBase);

        Set<String> perm = permutation("", numeroBase, numeroBase);
        List<Integer> candidates = perm.stream().map(x -> Integer.parseInt(x)).sorted().collect(Collectors.toList());

        System.out.println("all        = " + (permAll));
        System.out.println("candidates = " + (candidates));


        int pos = candidates.indexOf(Integer.parseInt(numeroBase));
        return pos < candidates.size() - 1 ? candidates.get(pos + 1).toString() : numeroBase;
        */


    }
}

class SolutionLC {
    static boolean isPermutationSlow(int dv1, String v2) {
        String v1 = Integer.valueOf(dv1).toString();

        List<Character> sb = new LinkedList<>(v2.chars().mapToObj(e -> (char) e).collect(Collectors.toList()));
        for (char c : v1.toCharArray()) {
            int idx = sb.indexOf(c);
            if (idx == -1) return false;
            sb.remove(idx);
        }
        return true;
    }

    static boolean isPermutation(int dv1, String v2) {
        char[] str1 = Integer.toString(dv1).toCharArray();
        char[] str2 = v2.toCharArray();

        int NO_OF_CHARS = 58;
        int count[] = new int[NO_OF_CHARS];

        for (int i = 0; i < str1.length; i++) {
            count[str1[i]]++;
            count[str2[i]]--;
        }

        for (int i = 48; i < NO_OF_CHARS; i++)
            if (count[i] != 0)
                return false;
        return true;
    }


    public static boolean maxNum(String s1) {
        char array1[] = s1.toCharArray();
        List<Integer> arrI = new ArrayList<>();
        for (int i = 0; i < array1.length; i++)
            arrI.add(Character.getNumericValue(array1[i]));
        arrI.sort(Comparator.reverseOrder());

        StringBuffer s2 = new StringBuffer();
        for (int i : arrI)
            s2.append(i);

        return s1.equals(s2.toString());
    }

    public int nextGreaterElement(int nb) {
        String numeroBase = Integer.valueOf(nb).toString();
        if (maxNum(numeroBase)) return -1;

        var maxDigit = numeroBase.chars().mapToObj(c -> Character.getNumericValue(c)).mapToInt(v -> v).max().getAsInt();
        Double mc = (maxDigit + 1) * Math.pow(10, numeroBase.length() - 1) - 1;
        long maxCandidate = mc.longValue();

        for (int candidate = nb + 1; candidate < maxCandidate; candidate++) {
            if (candidate < 0) return -1;

            if (isPermutation(candidate, numeroBase))
                return candidate;
        }
        return -1;
    }
}

class BetterSolution {
    public int nextGreaterElement(int n) {
        char[] number = (n + "").toCharArray();
        int i, j;
        // I) Start from the right most digit and
        // find the first digit that is
        // smaller than the digit next to it.
        for (i = number.length - 1; i > 0; i--)
            if (number[i - 1] < number[i])
                break;
        // If no such digit is found, its the edge case 1.
        if (i == 0)
            return -1;
        // II) Find the smallest digit on right side of (i-1)'th
        // digit that is greater than number[i-1]
        int x = number[i - 1], smallest = i;
        for (j = i + 1; j < number.length; j++)
            if (number[j] > x && number[j] <= number[smallest])
                smallest = j;
        // III) Swap the above found smallest digit with
        // number[i-1]
        char temp = number[i - 1];
        number[i - 1] = number[smallest];
        number[smallest] = temp;
        // IV) Sort the digits after (i-1) in ascending order
        Arrays.sort(number, i, number.length);
        long val = Long.parseLong(new String(number));
        return (val <= Integer.MAX_VALUE) ? (int) val : -1;
    }
}
