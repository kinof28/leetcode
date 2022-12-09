class Solution {
    public int maxAncestorDiff(TreeNode root) {
        int v = 0;
        if (root == null || (root.left == null && root.right == null))
            return v;
        v = maxDiff(root.val, root);
        return Math.max(v, Math.max(maxAncestorDiff(root.left), maxAncestorDiff(root.right)));
    }

    public int maxDiff(int rootVal, TreeNode current) {
        if (current == null)
            return Integer.MIN_VALUE;
        else
            return Math.max(Math.abs(rootVal - current.val),
                    Math.max(maxDiff(rootVal, current.left), maxDiff(rootVal, current.right)));
    }
}