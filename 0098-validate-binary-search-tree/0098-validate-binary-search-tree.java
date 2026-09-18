class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
    private boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        
        // Current node's value must be between low and high
        if ((low != null && node.val <= low) || (high != null && node.val >= high)) {
            return false;
        }
        
        // Validate left subtree (upper bound becomes node.val) and right subtree (lower bound becomes node.val)
        return validate(node.left, low, node.val) && validate(node.right, node.val, high);
    }
}