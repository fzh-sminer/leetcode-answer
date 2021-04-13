package daily;

/**
 * 783. 二叉搜索树节点最小距离
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 *
 *
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 *
 * 提示：
 *
 * 树中节点数目在范围 [2, 100] 内
 * 0 <= Node.val <= 105
 */
public class DAY202104130783 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    private int minDiff = Integer.MAX_VALUE;
    private int lastNodeVal = -1;

    // 递归实现中序遍历求解
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    // 递归中序遍历
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left );
        if (lastNodeVal >= 0) {
            minDiff = Math.min(minDiff, root.val - lastNodeVal);
        }
        lastNodeVal = root.val;
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(90);
        root.left = new TreeNode(69);
        root.left.left = new TreeNode(49);
        root.left.right = new TreeNode(89);
        root.left.left.right = new TreeNode(52);


        System.out.println(new DAY202104130783().minDiffInBST(root));
    }
}
