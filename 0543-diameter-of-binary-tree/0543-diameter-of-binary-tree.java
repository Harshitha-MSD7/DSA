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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;

    }
    private int dfs(TreeNode root){
        // base case 
        if(root == null){
            return -1;
        }

        int left_height = dfs(root.left); 
        int right_height = dfs(root.right);

        int max = Math.max(left_height, right_height);

        diameter = Math.max(diameter, left_height + right_height + 2);

        return max + 1;
    }
}