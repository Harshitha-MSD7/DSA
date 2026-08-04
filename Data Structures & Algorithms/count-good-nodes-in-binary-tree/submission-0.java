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
    int count = 0;

    public int goodNodes(TreeNode root) {
        return greater(root, Integer.MIN_VALUE);
    }

    public int greater(TreeNode root, int num){
        // Base case
        if(root == null) return 0;
        if(root.val >= num){ 
            count++;
            greater(root.left, root.val);
            greater(root.right, root.val);
        }
        else{
            greater(root.left, num);
            greater(root.right, num);
        }
        return count;
    }
}
