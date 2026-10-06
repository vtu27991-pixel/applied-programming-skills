  class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    private void dfs(TreeNode node, int remaining,
                     List<Integer> path,
                     List<List<Integer>> result) {

        if (node == null) {
            return;
        }

        path.add(node.val);
        remaining -= node.val;

        // Check if current node is a leaf
        if (node.left == null && node.right == null) {
            if (remaining == 0) {
                result.add(new ArrayList<>(path));
            }
        } else {
            dfs(node.left, remaining, path, result);
            dfs(node.right, remaining, path, result);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }
}