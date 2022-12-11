import java.util.HashMap;
import java.util.Map;

class Solution {

    Map<TreeNode, Integer> treeSizes = new HashMap<>();

    public int maxPathSum(TreeNode root) {
        if (root == null)
            return Integer.MIN_VALUE;
        return (int) Math.max(treeSum(root), Math.max(maxPathSum(root.left), maxPathSum(root.right)));
    }

    public int treeSum(TreeNode root) {
        if (root == null)
            return 0;
        else if (treeSizes.containsKey(root))
            return treeSizes.get(root);
        else {
            int result = root.val + treeSum(root.left) + treeSum(root.right);
            treeSizes.put(root, result);
            return result;
        }
    }
}