package leetcode._2022._03._0319;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {

            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


    public static boolean hasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {

            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        if (head.next == head) return true;
        ListNode nextNode = head.next;
        head.next = head;
        return hasCycle(nextNode);

    }

    public boolean hasCycle3(ListNode head) {
        if ( head == null ) return false;
        if( head.val == 0xcafebabe ) return true;
        head.val = 0xcafebabe; // Mark this node as visited
        return hasCycle(head.next);
    }

    public static void main(String[] args) {
    }
}
