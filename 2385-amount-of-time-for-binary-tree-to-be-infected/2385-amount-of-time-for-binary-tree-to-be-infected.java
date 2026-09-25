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
    TreeNode first = null;
    public int amountOfTime(TreeNode root, int start) {
        if(root == null || (root.left == null && root.right == null)) return 0;
        // Children -> Parent
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        // Populating the map
        buildMap(root, parent, start);
        HashSet<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(first);
        set.add(first);
        int time = -1;

        while(!q.isEmpty()){
            int size = q.size();
            time++;
            for(int i = 0; i<size; i++){
                TreeNode node = q.poll();
                // if it has a parent
                if(parent.containsKey(node) && !set.contains(parent.get(node))){
                    q.add(parent.get(node));
                    set.add(parent.get(node));
                }
                if(node.left != null && !set.contains(node.left)){
                    q.add(node.left);
                    set.add(node.left);
                }
                if(node.right != null && !set.contains(node.right)) {
                    q.add(node.right);
                    set.add(node.right);

                }
            }
        }

        return time;
    }
    // dfs traversal to populate the HashMap
    // Root Node will not be in hte map
    public void buildMap(TreeNode root, HashMap<TreeNode, TreeNode> parent, int start){
        if(root == null) return;
        if(root.val == start) first = root;
        if(root.left != null) parent.put(root.left, root);
        if(root.right != null) parent.put(root.right, root);
        buildMap(root.left, parent, start);
        buildMap(root.right, parent, start);
    }
}