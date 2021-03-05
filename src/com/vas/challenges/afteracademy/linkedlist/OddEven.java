package com.vas.challenges.afteracademy.linkedlist;

/**
 * Given a singly linked list, write a program to group all odd nodes together
 * followed by the even nodes.
 */
public class OddEven {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        rearrangeEvenOdd(head);
        ListNode current = head;
        while (current != null) {
            System.out.printf("%d ", current.val);
            current = current.next;
        }
    }

    static ListNode rearrangeEvenOdd(ListNode head) {
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (true) {
            if (even != null && even.next != null) {
                odd.next = even.next;
                odd = even.next;
            } else {
                odd.next = evenHead;
                break;
            }
            even.next = odd.next;
            even = odd.next;

        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + (next != null ? "" + next.val : "") +
                    '}';
        }
    }
}
