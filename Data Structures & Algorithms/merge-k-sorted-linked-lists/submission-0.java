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
    public ListNode mergeKLists(ListNode[] lists) {
        // Brute Force Solution
        List<Integer> res = new ArrayList<>();
        // {[[]->[]->[]] , [[]->[]->[]]}
        for(ListNode list : lists){
            while(list!= null){
                res.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(res);
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(int node : res){
            head.next = new ListNode(node);
            head = head.next;
        }
        return dummy.next;
        
    }
}
