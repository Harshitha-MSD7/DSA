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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // dfs in root tree if at any point during our dfs
        // the node matched with the subroot then I start another dfs between both tree checking if they are the same till the end 
        // if not return false and also if there exist no node such that out subroot belongs to any node at the root then return false
        if(root == null) return false;
        // if we found a match 
        // From here on we have to check for the subroot 
        if(sub(root, subRoot)){
            return true;
        }
        // if not matched just keep traversing and check for a match
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        
    }
    public boolean sub(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null) return true; 

       
        if(root != null && subRoot != null && root.val == subRoot.val){
            return sub(root.left, subRoot.left) && sub(root.right, subRoot.right); }
        else {
            return false;
    }

    }
}
