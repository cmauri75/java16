package com.company.language;

import java.util.*;

public class LinkedArrayListQueue {
    /**
     * ArrayList    vs  LinkedList
     *
     * 1) ArrayList internally uses a dynamic array to store the elements.
     * LinkedList internally uses a doubly linked list to store the elements.
     *
     * 2) Manipulation with ArrayList is slow because it internally uses an array. If any element is removed from the array, all the bits are shifted in memory.
     * Manipulation with LinkedList is faster than ArrayList because it uses a doubly linked list, so no bit shifting is required in memory.
     *
     * 3) An ArrayList class can act as a list only because it implements List only.
     * LinkedList class can act as a list and queue both because it implements List and Deque interfaces.
     *
     * ******
     * ArrayList is better for storing and accessing data.
     * LinkedList is better for manipulating data.
     * ******
     */
    public static void main(String[] args) {
        List<String> al = new ArrayList<String>();//creating arraylist
        al.add("1-Ravi");
        al.add("2-Vijay");
        al.add("3-Ravi");
        al.add("4-Ajay");
        al.removeIf(S -> S.startsWith("4"));

        al.add(2,"2,5-Pollo");

        //As you declare you can use as List or as Que
        Queue<String> ll = new LinkedList<>();
        ll.add("1-James"); //add
        ll.add("2-Serena");
        ll.add("3-Swati");
        ll.add("4-Junaid");

        ll.peek();    //read
        ll.remove();  //remove

        Deque<String> dq = new LinkedList<>();
        dq.push("1-James"); //add
        dq.push("2-Serena");
        dq.push("3-Swati");
        dq.push("4-Junaid");

        dq.pop();    //read

        al.stream().forEach(System.out::println);
        System.out.println("---");
        ll.stream().forEach(System.out::println);
        System.out.println("---");
        dq.stream().forEach(System.out::println);


        //Other queues:
        //ArrayDeque, LinkedBlockingDeque, LinkedList
        Queue<String> q = new ArrayDeque<String>();
        /**
            First Element (Head)	Last Element (Tail)
        Throws exception	Special value	Throws exception	Special value
        Insert	addFirst(e)	offerFirst(e)	addLast(e)	offerLast(e)
        Remove	removeFirst()	pollFirst()	removeLast()	pollLast()
        Examine	getFirst()	peekFirst()	getLast()	peekLast()
        **/

    }
}
