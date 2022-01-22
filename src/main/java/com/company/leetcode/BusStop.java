package com.company.leetcode;

import java.util.*;

public class BusStop {

    public static void main(String[] args) throws java.lang.Exception {

        String input = """
                [[7, 2, 1],[3, 6, 7],[8, 9],[2, 10, 11]]""";

        /**
         String listOfPairs = input.substring(2, input.length()-2);
         String removeQuote = listOfPairs.replaceAll("\"","");
         String divide = removeQuote.replaceAll("\\], \\[","-");
         String finalS = divide.replaceAll(", ",":");
         **/


    /*


    Map<String,List<String>> routes = new HashMap<>();
    String[] pairs = finalS.split("-");
    for (int i=0;i<pairs.length;i++) {
        String pair = pairs[i];
        String[] keyValue = pair.split(":");

        List<String> dest = routes.get(keyValue[0]);
        if (dest== null)
          dest = new ArrayList<>();

        routes.put(keyValue[0], dest);
    }
    */

    /*
        StringBuilder ret = new StringBuilder("[\"");
        String current="JFK";
        while (current!=null){
            ret.append(current).append("\", \"");
            current = flights.get(current);
        }
        String path = ret.toString().substring(0, ret.length()-3)+"]";
    */
        String step1 = input.substring(2, input.length() - 2).replaceAll("\\],\\[", ";").replaceAll(" ", "");

        String[] stops = step1.split(";");

        String[][] nodes = new String[stops.length][];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = stops[i].split(",");
        }


        for (String[] ss : nodes) {
            for (String s : ss)
                System.out.print("x" + s + "x,");
        }
        System.out.println();

        String[] arr = {"10", "25", "23", "14", "85", "65"};
        String key = "14";
        boolean val = Arrays.stream(arr).anyMatch(i -> i == key);
        System.out.println("Array contains " + key + "? \n" + val);

        System.out.println(numBusesToDestination(nodes, "1", "8"));
        System.out.println(numBusesToDestination(nodes, "7", "1"));
        System.out.println(numBusesToDestination(nodes, "2", "3"));
        System.out.println(numBusesToDestination(nodes, "3", "10"));
    }

    public static <T> int numBusesToDestination(T[][] routes, T start, T end) {
        if (start.equals(end)) return 0;

        int numOfRoutes = routes.length;

        //initialization
        List<List<Integer>> crossesList = new ArrayList();
        for (int i = 0; i < numOfRoutes; i++) {
            crossesList.add(new ArrayList());
        }

        // Build the list of crosses, every row contains wich other route is crossed, and viceversa
        for (int i = 0; i < numOfRoutes; i++)
            for (int j = i + 1; j < numOfRoutes; j++) {
                //System.err.println(Arrays.toString(routes[i])+" "+Arrays.toString(routes[j])+ " --> "+intersect(routes[i], routes[j]));
                if (intersect(routes[i], routes[j])) {
                    crossesList.get(i).add(j);
                    crossesList.get(j).add(i);
                }
            }

        Set<Integer> startLocations = new HashSet();
        Set<Integer> endLocations = new HashSet();
        Queue<Pair> queue = new LinkedList<>();

        // Initialize startLocations (routes containing start), queue (path from start to end), endLocation(routes containing end).
        for (int i = 0; i < numOfRoutes; i++) {
            if (contains(routes[i],start)) {
                startLocations.add(i);
                queue.add(new Pair(i, 0));
            }
            if (contains(routes[i],end))
                endLocations.add(i);
        }

        while (!queue.isEmpty()) {
            Pair info = queue.remove();
            int node = info.x, depth = info.y;
            if (endLocations.contains(node))
                return depth + 1;

            for (Integer nextNode : crossesList.get(node)) {
                if (!startLocations.contains(nextNode)) {
                    startLocations.add(nextNode);
                    queue.add(new Pair(nextNode, depth + 1));
                }
            }
        }

        return -1;
    }

    static <T> boolean intersect(T[] firstArr, T[] secondArr) {
        for (T search : firstArr)
            if (contains(secondArr,search)) return true;
        return false;

    }

    static <T> boolean contains(T[] arr, T value) {
        return Arrays.stream(arr).anyMatch(check -> check.equals(value));
    }

    private record Pair(int x, int y) {
    }


}


/**
 * Integer[][] nodesI = new Integer[4][];
 * nodesI[0] = new Integer[3];
 * nodesI[0][0] = 7;
 * nodesI[0][1] = 2;
 * nodesI[0][2] = 1;
 * <p>
 * nodesI[1] = new Integer[3];
 * nodesI[1][0] = 3;
 * nodesI[1][1] = 6;
 * nodesI[1][2] = 7;
 * <p>
 * nodesI[2] = new Integer[2];
 * nodesI[2][0] = 8;
 * nodesI[2][1] = 9;
 * <p>
 * nodesI[3] = new Integer[3];
 * nodesI[3][0] = 2;
 * nodesI[3][1] = 10;
 * nodesI[3][2] = 11;
 */