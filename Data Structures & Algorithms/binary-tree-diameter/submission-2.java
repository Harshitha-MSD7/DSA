class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        // Get the height of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Update max diameter if the path through this node is the longest so far
        max = Math.max(max, leftHeight + rightHeight);

        // Return the height of the current node up to its parent
        return 1 + Math.max(leftHeight, rightHeight);
    }
}