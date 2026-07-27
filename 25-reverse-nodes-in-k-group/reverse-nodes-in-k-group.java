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
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = 0;
        // i++ everytime inside the loop 
        // (i% k == 0) - then perform the reversal
        // 
        // we have to run a loop which increments by k  
        // 
        // gets terminated as soon as we reach the end of the list (null)
        ListNode tmp = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;

        while(left.next != null){
            // keep track of the left pointer
            // keep track of the right pointer (HOW?)

            // this is where our left stops
            
                //this inner loop will give us the right pointer
                ListNode right = left;
                for(int j = 0; j<k; j++){
                    right = right.next;
                    if(right == null) break;
                }
                if(right == null) break;
                ListNode prev = null;
                ListNode curr = left.next;
                ListNode tail = curr;
                ListNode stopNode = right.next;
                while (curr != stopNode) {
                    ListNode next = curr.next;  // 1. SAVE the rest
                    curr.next = prev;           // 2. flip this link
                    prev = curr;                // 3. advance prev
                    curr = next; 
                }
                left.next = prev;
                tail.next = curr;
            
            
            left = tail;
        }

        return dummy.next;
    }
}