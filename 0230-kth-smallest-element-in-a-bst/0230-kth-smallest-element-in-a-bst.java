 class Solution {
    private int count = 0;
    private int answer = 0;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return answer;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        // Left
        inorder(root.left, k);

        // Current node
        count++;
        if (count == k) {
            answer = root.val;
            return;
        }

        // Right
        inorder(root.right, k);
    }
}