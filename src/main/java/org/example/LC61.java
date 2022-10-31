package org.example;

public class LC61 {
    /**
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null) return head;
            ListNode help = new ListNode(0);
            help.next = head;
            ListNode one = help, second = help;
            int i;
            for (i = 0; one.next != null; i++) {
                one = one.next;
            }

            for (int j = i - k % i; j > 0; j--) {
                second = second.next;
            }

            one.next = help.next;
            help.next = second.next;
            second.next = null;

            return help.next;
        }
    }
     **/
}
