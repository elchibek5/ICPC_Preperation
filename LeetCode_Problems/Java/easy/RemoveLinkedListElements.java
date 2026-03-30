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
    ListNode start_point;

    public ListNode removeElements(ListNode head, int val) {
        return removeElement(head, val);
    }

    private ListNode removeElement(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElement(head.next, val);

        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }
}
