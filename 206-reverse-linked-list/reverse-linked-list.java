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
        ListNode tmp = null;
        ListNode current = head;

        while(current != null){
            ListNode next = current.next;
            current.next = tmp;
            tmp = current;
            current = next;
        }
        return tmp;
    }
}