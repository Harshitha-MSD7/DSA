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
    // Node left Right 
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int curSum, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        if (node == null) return;

        // 1. Include the current node in the running sum and path
        curSum += node.val;
        currentPath.add(node.val);

        // 2. Check if it's a leaf node
        if (node.left == null && node.right == null) {
            if (curSum == targetSum) {
                // CRITICAL: Add a *copy* of the path, not the reference itself!
                result.add(new ArrayList<>(currentPath));
            }
        } 
        else {
            // 3. Recurse down left and right subtrees
            dfs(node.left, curSum, targetSum, currentPath, result);
            dfs(node.right, curSum, targetSum, currentPath, result);
        }

        // 4. Backtrack: remove the current node before returning up to the parent
        currentPath.remove(currentPath.size() - 1);
    }
}