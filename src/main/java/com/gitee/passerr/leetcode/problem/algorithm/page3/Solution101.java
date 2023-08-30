package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.function.BiFunction;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * 说明:
 * 如果你可以运用递归和迭代两种方法解决这个问题，会很加分。
 * @author xiehai
 * @date 2019/07/25 15:34
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution101 {
    // #region snippet
    public boolean isSymmetric(TreeNode root) {
        BiFunction<TreeNode, TreeNode, Boolean> judgeSymmetric = new BiFunction<TreeNode, TreeNode, Boolean>() {
            @Override
            public Boolean apply(TreeNode left, TreeNode right) {
                return
                    // 左右节点都为null
                    (left == null && right == null)
                        // 左右节点都不为null且val一样 且左右满足镜像对称
                        || (left != null && right != null && left.val == right.val
                        && this.apply(left.left, right.right) && this.apply(left.right, right.left));
            }
        };

        // 根节点为null或左右树满足镜像对称
        return root == null || judgeSymmetric.apply(root.left, root.right);
    }
    // #endregion snippet
}
