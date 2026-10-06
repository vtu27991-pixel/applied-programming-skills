 class Solution {

    class NodeInfo {
        int row;
        int col;
        int val;

        NodeInfo(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<NodeInfo> nodes = new ArrayList<>();

        dfs(root, 0, 0, nodes);

        // Sort by column, then row, then value
        Collections.sort(nodes, (a, b) -> {
            if (a.col != b.col) {
                return Integer.compare(a.col, b.col);
            }

            if (a.row != b.row) {
                return Integer.compare(a.row, b.row);
            }

            return Integer.compare(a.val, b.val);
        });

        List<List<Integer>> result = new ArrayList<>();

        int previousColumn = Integer.MIN_VALUE;

        for (NodeInfo node : nodes) {

            // New column
            if (node.col != previousColumn) {
                result.add(new ArrayList<>());
                previousColumn = node.col;
            }

            result.get(result.size() - 1).add(node.val);
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col,
                     List<NodeInfo> nodes) {

        if (node == null) {
            return;
        }

        nodes.add(new NodeInfo(row, col, node.val));

        dfs(node.left, row + 1, col - 1, nodes);
        dfs(node.right, row + 1, col + 1, nodes);
    }
}
 