package com.gitee.passerr.leetcode.problem.lcof2.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.Objects;

/**
 * 给定一个二叉树 根节点root，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
 * 节点 node 的子树为node 本身，以及所有 node的后代。
 * <p>
 * 示例 1:
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 * <p>
 * 示例 2:
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 * 解释:
 * <p>
 * 示例 3:
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 * 解释:
 * <p>
 * 提示:
 * 二叉树的节点个数的范围是 [1,200]
 * 二叉树节点的值只会是 0 或 1
 * <p>
 * 注意：本题与主站 814题相同：https://leetcode-cn.com/problems/binary-tree-pruning/
 * @author xiehai
 * @date 2022/01/17 11:47
 */
public class Lcof047 {
    public TreeNode pruneTree(TreeNode root) {
        // 根节点为空
        if (root == null) {
            return null;
        }

        root.left = this.pruneTree(root.left);
        root.right = this.pruneTree(root.right);

        // 若左右子树为空 根节点值为0 全部剪枝
        if (Objects.isNull(root.left) && Objects.isNull(root.right) && root.val == 0) {
            return null;
        }

        return root;
    }
}
