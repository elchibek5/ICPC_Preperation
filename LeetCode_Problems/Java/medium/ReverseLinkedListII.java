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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode before = dummy;

        for (int i = 0; i < left - 1; i++) {
            before = before.next;
        }

        ListNode tail = before.next;
        ListNode current = tail.next;

        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = current.next;
            tail.next = nextNode;
            current.next = before.next;
            before.next = current;
            current = nextNode;
        }

        return dummy.next;
    }
}
