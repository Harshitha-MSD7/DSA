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
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> q = new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode list : lists){
            if(list != null){
                q.offer(list);
            }
        }
        // In the queue it is going to be sorted
        while(! q.isEmpty()){
            ListNode node = q.poll();
            cur.next = node;
            cur = cur.next;

            if(node.next != null){
                q.offer(node.next);
            }
        }
        

        return dummy.next;
    }
}
