package org.example;

import org.w3c.dom.NodeList;

import java.util.List;

public class LC876 {
    public static void main(String[] args) {

    }

    public static ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode[] list = new ListNode[100];

        while (head != null) {
            list[count++] = head;
            head = head.next;
            System.out.println(head.val);
        }
        return list[count / 2];
    }
    public ListNode middleNode2(ListNode head) {

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while(fastPointer!=null && fastPointer.next!=null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public static class ListNode {
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

        public int getData() {
            return val;
        }

        public void setData(int data) {
            this.val = data;
        }

        public ListNode getNextNode() {
            return next;
        }

        public void setNextNode(ListNode nextNode) {
            this.next = nextNode;
        }
    }
}

