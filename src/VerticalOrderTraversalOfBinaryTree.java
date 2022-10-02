import java.util.*;

public class VerticalOrderTraversalOfBinaryTree {
    private int[] dep;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Currently only works for balanced trees
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int lo = getLeft(root);
        int hi = getRight(root);
        dep = new int[lo + hi + 1];
        Arrays.fill(dep, -1);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < lo + hi + 1; i++) res.add(new ArrayList<Integer>());
        traverse(lo, 0, root, res);
        return res;
    }

    private int getLeft(TreeNode n) {
        if (n.left == null) return 0;
        else return getLeft(n.left) + 1;
    }

    private int getRight(TreeNode n) {
        if (n.right == null) return 0;
        else return getRight(n.right) + 1;
    }

    private void traverse(int currList, int depth, TreeNode currNode, List<List<Integer>> res) {
        if (currNode.left != null) traverse(currList - 1, depth + 1, currNode.left, res);
        if (currNode.right != null) traverse(currList + 1, depth + 1, currNode.right, res);
        if (dep[currList] != depth) {
            res.get(currList).add(0, currNode.val);
            dep[currList] = depth;
        } else {
            int prev = res.get(currList).get(0);
            if (prev > currNode.val) res.get(currList).add(0, currNode.val);
            else res.get(currList).add(1, currNode.val);
        }

    }
}
