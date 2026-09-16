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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;
        int var1 = 0;
        int var2 = 0;

        while(l1 != null || l2 != null || carry != 0){
            if(l1!= null)
                var1 = l1.val;
            else 
                var1 = 0;

            if(l2!= null)
                var2 = l2.val;
            else 
                var2 = 0;

            int sum = var1 + var2 + carry;

            // 1   15
            carry = sum / 10;
            sum = sum%10;

            curr.next = new ListNode(sum);
            curr = curr.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;

            
        }

        return dummy.next;
    }
}
