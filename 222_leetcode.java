/*
222. Count Complete Tree Nodes

Solution 1: Using queue O(n)
Runtime: 4 ms
Memory Usage: 42.3 MB
*/
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
            count++;
        }
        return count;
    }
}
/*
Solution 2: Recursion O(n)
Runtime: 0 ms
Memory Usage: 41.7 MB
*/
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

