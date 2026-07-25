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
        ListNode list1 = l1;
        ListNode list2 = l2;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while(list1 != null || list2 != null){
            int res = carry;
            if(list1 != null){
                res += list1.val;
            }
            if(list2 != null){
                res += list2.val;
            }
            ListNode node = new ListNode(res%10);
            carry = res/10;
            curr.next = node;
            curr = curr.next;
            
            if(list1 != null){
                list1 = list1.next;
            }
            if(list2 != null){
                list2 = list2.next;
            }
        }

        if(carry > 0 ){
            ListNode node = new ListNode(carry);
            curr.next = node;
            curr = curr.next;
        }

        curr.next = null;
        return dummy.next;

    }
}
