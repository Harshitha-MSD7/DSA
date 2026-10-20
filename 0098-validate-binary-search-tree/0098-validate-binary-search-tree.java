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
    public boolean isValidBST(TreeNode root) {
        // Base
        //if(root.left == null && root.right == null) return true;

        return dfs(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode parent, long min, long max){

        if(parent == null) return true;

        if(min < parent.val && parent.val < max){
            // true
            return dfs(parent.left, min, parent.val) && dfs(parent.right, parent.val, max);
        }
        
        return false;
        
    }
}