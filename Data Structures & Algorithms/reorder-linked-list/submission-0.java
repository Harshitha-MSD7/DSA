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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        } 
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;

        // reverse 
        ListNode prev = null;
        ListNode curr = head2;
        while (curr != null) {
            ListNode next = curr.next;  // 1. SAVE the rest
            curr.next = prev;           // 2. flip this link
            prev = curr;                // 3. advance prev
            curr = next;                // 4. advance curr
        }
        head2 = prev;   // new head

        while(head2 != null){
            ListNode tmp1 = head1.next;
            head1.next = head2;
            head1 = tmp1;
            ListNode tmp2 = head2.next;
            head2.next = head1;
            head2 = tmp2;
        }

    }
}
