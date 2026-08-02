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
    
    public int diameterOfBinaryTree(TreeNode root) {
       /* The maximum of the left height and the right height of the binary tree is the      maximum possible diameter */

       if(root == null) return 0;
       int left = diameterOfBinaryTree(root.left);
       int right = diameterOfBinaryTree(root.right);

       int diameter = maxHeight(root.left) + maxHeight(root.right);

       return diameter;
    }

    public int maxHeight(TreeNode root){
        if(root == null) return 0;

        return 1 + Math.max(maxHeight(root.left), maxHeight(root.right));

    }
}
