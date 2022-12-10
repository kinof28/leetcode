import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<TreeNode, Long> treeSizes;

    public int maxProduct(TreeNode root) {
        treeSizes = new HashMap<>();
        return (int) (maxProductRecursive(root, treeSum(root)) % 1000000007);
    }

    public long maxProductRecursive(TreeNode root, long totalSum) {
        if (root == null || (root.left == null && root.right == null))
            return 0;
        long leftSubTree = treeSum(root.left), rightSubTree = treeSum(root.right);
        return Math.max((Math.max((totalSum - leftSubTree) * leftSubTree,
                (totalSum - rightSubTree) * rightSubTree)),
                Math.max(maxProductRecursive(root.left, totalSum), maxProductRecursive(root.right, totalSum)));
    }

    public long treeSum(TreeNode root) {
        if (root == null)
            return 0;
        else if (treeSizes.containsKey(root))
            return treeSizes.get(root);
        else {
            long result = root.val + treeSum(root.left) + treeSum(root.right);
            treeSizes.put(root, result);
            return result;
        }
    }
}
