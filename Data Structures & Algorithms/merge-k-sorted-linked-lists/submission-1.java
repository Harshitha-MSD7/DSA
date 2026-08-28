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
    /*      {[[]->[]->[]] , [[]->[]->[]]}
              ^              ^
              |              |
              i              k
    */    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode head = dummy;
        while(true){
            int minIndex = -1;
            ListNode min = dummy;
            for(int i = 0; i<lists.length; i++){
                if(lists[i] == null){
                    continue;
                }
                else if(min == dummy || lists[i].val < min.val){
                    min = lists[i]; 
                    minIndex = i;   
                }
            }

            if(min == dummy){
                    break;
            }

            lists[minIndex] = lists[minIndex].next;

            head.next  = min;
            head = head.next;
        }
        return dummy.next;
    }
}

