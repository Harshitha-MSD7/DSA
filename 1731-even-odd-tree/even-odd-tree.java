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
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return false;
        int prev = 0;
        int level = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            if(level %2 == 0) prev = Integer.MIN_VALUE;
            else prev = Integer.MAX_VALUE;
            // delare prev
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                // Even level
                if(level % 2 == 0) {          
                    if(node.val % 2 == 0) return false;
                    if(prev >= node.val) return false;
                     
                }
                // odd level
                else {      
                    if(node.val % 2 == 1) return false; 
                    if(prev <= node.val) return false;
                    
                }
                
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                prev = node.val;
            }
          
        }

        return true;
    }
}