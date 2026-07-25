/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node tmp = head;

        while(tmp != null){
            Node node = new Node(tmp.val);
            map.put(tmp,node);
            tmp = tmp.next;
        }

        tmp = head;
        Node newHead = map.get(tmp);
        Node curr = newHead;

        while(tmp!= null){
            // setting the next pointer
            curr.next = map.get(tmp.next);
            // setting the random pointer 
            if(tmp.random == null) curr.random = null;
            else curr.random = map.get(tmp.random);

            tmp = tmp.next;
            curr = curr.next;
        }

        return newHead;
    }

}
