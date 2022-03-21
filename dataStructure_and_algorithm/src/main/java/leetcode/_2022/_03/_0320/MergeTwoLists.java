package leetcode._2022._03._0320;

import leetcode._2022.ListNode;

public class MergeTwoLists {

    @Deprecated
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = list1;
        while (list1 != null) {

            while (list2 != null) {
                if (list1.val <= list2.val) {
                    ListNode temp = list1.next;
                    list1.next = list2;
                    list2.next = temp;
                } else {
                    ListNode temp = list2.next;
                    list1.next = list2;
                    list2.next = temp;
                }
            }
            list1 = list1.next;
        }
        return dummyHead.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode(-1);
        while ( list1 != null || list2 != null){
            if ( list1 == null || ((list2 != null) && list1.val >= list2.val) ){
                dummyHead.next = list2;
                dummyHead = list2;
                list2 = dummyHead.next;
            }else {
                dummyHead.next = list1;
                dummyHead = list1;
                list1 = dummyHead.next;
            }

        }
        return dummyHead.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
