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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode curr = root;
        queue.add(curr);
        int level = 0;
        while(queue.size() > 0){
            int n = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i<n; i++){
                curr = queue.poll();
                list.add(curr.val);
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            if(level%2 == 0) result.add(list);
            else { 
                Collections.reverse(list);
                result.add(list);}

            level++;
        }

        return result;
    }
}