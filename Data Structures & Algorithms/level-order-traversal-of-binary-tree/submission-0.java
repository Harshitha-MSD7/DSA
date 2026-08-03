/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // At each level we have to read the node at that level and then push it into the Queue
        // pop all the nodes at that level once we are done and then add it to the arraylist for each of the node we added to the arraylist traverse it and see if the right and left pointer exists if it does exist then that is going to be the next level 
        // continue doing this process     
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.add(cur);

        while(queue.size() > 0){
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i< n; i++){
                cur = queue.poll();
                level.add(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            result.add(level);
        } 
        return result;   
    }
}
