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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int size = 0;
        ListNode ptr = head;

        while(ptr != null){
            ptr = ptr.next;
            size++;
        }

        k = k % size;
        if (k == 0) {
            return head;
        }

        int req = size - k-1;

        ListNode slow2 = head;
        ListNode end = head;
        int i = 0;
        while(end.next != null){
            end = end.next;
            if(i < req){
                i++;
                slow2 = slow2.next;
            }
        }

        ListNode newHead = slow2.next;

        slow2.next = null;

        end.next = head;

        return newHead;




    }
}