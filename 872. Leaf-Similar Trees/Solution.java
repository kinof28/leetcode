import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> firstLeafSequence = new LinkedList<>();
        List<Integer> secondLeafSequence = new LinkedList<>();
        getLeafSequence(root1, firstLeafSequence);
        getLeafSequence(root2, secondLeafSequence);
        if (firstLeafSequence.size() != secondLeafSequence.size())
            return false;
        for (int i = 0; i < firstLeafSequence.size(); i++) {
            if (firstLeafSequence.get(i) != secondLeafSequence.get(i))
                return false;
        }
        return true;
    }

    private void getLeafSequence(TreeNode root, List<Integer> sequence) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sequence.add(root.val);
            return;
        }
        getLeafSequence(root.left, sequence);
        getLeafSequence(root.right, sequence);
    }
}