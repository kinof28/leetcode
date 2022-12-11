class Solution {
    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        maxPathSumRecursive(root);
        return maxSum;
    }

    public int maxPathSumRecursive(TreeNode root) {
        if (root == null)
            return 0;
        int leftSubTree = Math.max(maxPathSumRecursive(root.left), 0);
        int rightSubTree = Math.max(maxPathSumRecursive(root.right), 0);
        maxSum = Math.max(maxSum, leftSubTree + rightSubTree + root.val);
        return Math.max(root.val + leftSubTree, root.val + rightSubTree);
    }

}