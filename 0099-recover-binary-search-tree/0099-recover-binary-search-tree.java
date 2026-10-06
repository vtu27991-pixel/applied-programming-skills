class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        inorder(root);

        // Swap the values of the two incorrect nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // Left
        inorder(node.left);

        // Current node
        if (prev != null && prev.val > node.val) {

            // First incorrect node
            if (first == null) {
                first = prev;
            }

            // Second incorrect node
            second = node;
        }

        prev = node;

        // Right
        inorder(node.right);
    }
}