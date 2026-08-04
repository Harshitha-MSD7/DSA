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
    // Keep track of how many nodes we've processed (visited)
    int count = 0;
    
    // Store our final answer once we find it
    int result = -1; 

    public int kthSmallest(TreeNode root, int k) {
        // Kick off the helper traversal method
        inorder(root, k);
        // Once the traversal is completely done, our result variable will hold the answer
        return result;
    }

    // Our recursive helper method
    public void inorder(TreeNode node, int k) {
        // Base case: if we hit a null node, just stop and return
        if (node == null) {
            return;
        }
        
        // 1. Traverse Left
        inorder(node.left, k);
        // 2. Process Current Node:
        //    - Increment our global 'count'
        //    - If 'count' exactly equals 'k', we found our target! Save node.val to 'result'
        count++;
        if(count == k) result = node.val;
        // 3. Traverse Right
        inorder(node.right, k);

        
    }
}
