package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *
 * 示例 1：
 * https://assets.leetcode.com/uploads/2020/09/15/inorder_1.jpg
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 *
 * 示例 3：
 * https://assets.leetcode.com/uploads/2020/09/15/inorder_5.jpg
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 * 示例 4：
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 *
 * 示例 5：
 * https://assets.leetcode.com/uploads/2020/09/15/inorder_4.jpg
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 */
public class BASE0094 {

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

    public List<Integer> inorderTraversal(TreeNode root) {
        return second(root);
    }

    public List<Integer> first(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }


    public List<Integer> second(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
        }

        return list;
    }
}
