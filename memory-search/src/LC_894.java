import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述： Todo
 */

public class LC_894 {

    public static void main(String[] args) {
        List<TreeNode> result = allPossibleFBT(7);
        return;
    }
    // 分治，递归

    static Map<Integer, List<TreeNode>> memo;

    public static List<TreeNode> allPossibleFBT(int n) {
        memo = new HashMap<Integer, List<TreeNode>>() {
            {
                put(0, new ArrayList<TreeNode>());
                put(1, new ArrayList<TreeNode>() {
                    {
                        add(new TreeNode(0));
                    }
                });
                put(2, new ArrayList<TreeNode>());

            }
        };
        return dfs(n);
    }

    public static List<TreeNode> dfs(int n) {
        if (!memo.containsKey(n)) {
            List<TreeNode> res = new ArrayList<>();
            for (int i = 1; i < n - 1; i++) {
                List<TreeNode> left = dfs(i);
                List<TreeNode> right = dfs(n - 1 - i);

                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        TreeNode root = new TreeNode(0);
                        root.left = l;
                        root.right = r;
                        res.add(root);
                    }
                }
            }
            memo.put(n, res);
        }
        return memo.get(n);
    }

    static class TreeNode {
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

}
