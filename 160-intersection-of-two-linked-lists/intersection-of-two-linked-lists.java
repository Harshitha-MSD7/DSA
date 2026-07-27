/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode list1 = headA;
        ListNode list2 = headB;
        HashSet<ListNode> set = new HashSet<>();

        while(list1 != null && list2 != null){
            set.add(list1);
            list1 = list1.next;
        }
        while(list2 != null){
            if(set.contains(list2)) return list2;
            set.add(list2);
            list2 = list2.next;
        }
        return null;

    }
}