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
        // dummy node problem 
        // keep track of the pointer before and after 
        // nodes of the reversal segment
        // dummy.next = start of revesed linked list
        // end has to point to the node we have to connect it with (could be the last node)
        // 1. to find the correct left and right node
        // 2.  Reverse the portion 
        // 3. Connect the reversed portion back 
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l = dummy;
        ListNode r = head;
        int le = left;
        int ri = right;

        // Step 1 - find the correct left and right node
        // r has to be one node ahead of the right integer
        for(int i = 0; i < right; i++) {
            r = r.next;
        }


        // l has to be on node before the left integer
        for (int i = 0; i < left - 1; i++) {
            l = l.next;
        }

        /*
            In context to Example 1,
            curr -> 1
            By the end of the loop we need:
            1. A pointer at 3 (head) 
            2. A pointer at 1 (tail)
            3. Links have to be reversed
        */

        // step 2 - Reverse the portion from left to right 
        ListNode prev = null;
        ListNode curr = l.next;
        ListNode tail = curr;
        while (curr != r) {
            ListNode next = curr.next;  // 1. SAVE the rest
            curr.next = prev;           // 2. flip this link
            prev = curr;                // 3. advance prev
            curr = next;                // 4. advance curr
        }
        //prev is the head and tail is the tail 
        tail.next = r;
        l.next = prev;

        return dummy.next;
    }

}