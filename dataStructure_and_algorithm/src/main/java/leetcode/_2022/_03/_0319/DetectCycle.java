package leetcode._2022._03._0319;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import leetcode._2022.ListNode;
import org.junit.Test;

public class DetectCycle {

    public ListNode detectCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (null != head) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        Map<ListNode, Integer> map = new HashMap<>();
        Integer count = 0;
        while (null != head) {
            head.val = count++;
            if (map.containsKey(head)) {
                return head;
            }
            map.put(head, count);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {

        ListNode fast = head, slow = head;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    @Test
    public void test() {
        DetectCycle detectCycle = new DetectCycle();
        ListNode listNode = new ListNode(-1);
        ListNode listNode2 = generateList(listNode, 5);
        listNode2.next = listNode.next.next;
//        while ( listNode != null ){
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }
        detectCycle.detectCycle(listNode);
    }

    private ListNode generateList(ListNode head, int size) {
        if (size < 0) {
            return head;
        }
        head.next = new ListNode(-1);
        return generateList(head.next, --size);
    }
}
