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
    public boolean isCousins(TreeNode root, int x, int y) {
        // for x and y we need 2 things depth and parent 
        // if same depthand different parent ---> TRUE else FALSE 
        if (root == null) return false;


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode parentX = null;
            TreeNode parentY = null;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    if (node.left.val == x) parentX = node;
                    if (node.left.val == y) parentY = node;
                    queue.offer(node.left);}
                if (node.right != null) {
                    if (node.right.val == x) parentX = node;
                    if (node.right.val == y) parentY = node;
                    queue.offer(node.right);}
            }
            // if both on same level then check it's value
            if(parentX != null && parentY != null) return parentX != parentY;
            // if one node is found in this level
            if(parentX != null || parentY != null) return false;
        }
        return false;
    }
}