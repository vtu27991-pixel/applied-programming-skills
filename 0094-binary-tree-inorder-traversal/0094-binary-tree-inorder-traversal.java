 class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        // Left
        inorder(node.left, result);

        // Root
        result.add(node.val);

        // Right
        inorder(node.right, result);
    }
}