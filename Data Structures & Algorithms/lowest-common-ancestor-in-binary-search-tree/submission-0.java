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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // We have to check is p is in the subtree of s or if s is in the subtree of p 
        // if it is just return the parent 
        // if not then then it means that the Common ancestor is either not there or is there as an parent of both p and q 
        // so we have to cheack both these conditions as we iterateis
        TreeNode curr = root;

        while(curr != null){
            if(curr.val < p.val && curr.val < q.val){
                curr = curr.right;
            }
            else if(curr.val > p.val && curr.val > q.val){
                curr = curr.left;
            }
            else {
                return curr;
            }
        }
        
        return null;
    }
}
