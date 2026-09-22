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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }
    private boolean dfs(TreeNode root, int curSum, int targetSum){
        if(root == null) return false;

        curSum += root.val;

        if(root.left == null && root.right == null){
            return curSum == targetSum;
        } 

        return dfs(root.left, curSum, targetSum) || dfs(root.right, curSum, targetSum);
    }
}