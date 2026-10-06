 class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        // If it's a leaf, check whether its value equals the remaining sum
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        int remaining = targetSum - root.val;

        return hasPathSum(root.left, remaining)
            || hasPathSum(root.right, remaining);
    }
}