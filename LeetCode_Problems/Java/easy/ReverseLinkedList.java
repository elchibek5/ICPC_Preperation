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
    public ListNode reverseList(ListNode head) {
        return reverseListRecursive(head, null);
    }

    private ListNode reverseListRecursive(ListNode currentNode, ListNode previousNode) {
        if (currentNode == null) return previousNode;
        ListNode nextNode = currentNode.next;
        currentNode.next = previousNode;
        return reverseListRecursive(nextNode, currentNode);
    }
}
