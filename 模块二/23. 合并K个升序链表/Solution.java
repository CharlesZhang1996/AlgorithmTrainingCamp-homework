/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode result = mergeHalf(lists, 0, lists.length - 1);
        return result;
    }

    private ListNode mergeHalf(ListNode[] lists, int start, int stop){
        if (start == stop) {
            return lists[stop];
        }
        if (stop - start == 1) {
            return mergeTwoLists(lists[start], lists[stop]);
        }
        int mid = (start + stop)/2;
        ListNode left = mergeHalf(lists, start, mid);
        ListNode right = mergeHalf(lists, mid + 1, stop);
        return mergeTwoLists(left, right);

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode protect = new ListNode(0, null);
        ListNode head = protect;
        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
            } else {
                head.next = list2;
                list2 = list2.next;
            }
            head = head.next;
        }
        // 将没有遍历完的链表直接接在答案的尾部
        head.next = list1 == null ? list2 : list1;
        return protect.next;
    }
}