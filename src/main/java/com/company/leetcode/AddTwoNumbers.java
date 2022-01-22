package com.company.leetcode;

//provided
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

//https://leetcode.com/problems/add-two-numbers
public class AddTwoNumbers {

    public java.math.BigInteger computeVal (ListNode l1) {
        java.math.BigInteger mult = java.math.BigInteger.valueOf(1);
        java.math.BigInteger val1 = java.math.BigInteger.valueOf(0);
        do {
            java.math.BigInteger adder = mult.multiply(java.math.BigInteger.valueOf(l1.val));
            val1 = val1.add(adder);
            mult = mult.multiply(java.math.BigInteger.valueOf(10));
        } while ((l1 = l1.next) != null);
        return val1;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        java.math.BigInteger v1 = computeVal(l1);
        java.math.BigInteger v2 = computeVal(l2);

        String res = v1.add(v2).toString();
        System.out.println(v1+" "+" "+v2+" "+res);

        ListNode ret = new ListNode();
        for (char c:res.toCharArray()){
            ret.val = Integer.parseInt(c+"");
            ListNode newLN = new ListNode();
            newLN.next=ret;
            ret=newLN;
        }

        return ret.next;

    }


}
