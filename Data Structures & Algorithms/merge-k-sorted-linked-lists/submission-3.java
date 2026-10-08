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
    // Have a priority queue put all the the pointer values in the priority queue and increment the pointer 
    // 
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        // pq has to use node.val to sort
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for(ListNode list : lists){
            if (list != null){
                pq.offer(list);
            }
        }
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            head.next = node;
            head = head.next;
            if(node.next != null){
                pq.offer(node.next);
            }
        }
        return dummy.next;
    }
}
