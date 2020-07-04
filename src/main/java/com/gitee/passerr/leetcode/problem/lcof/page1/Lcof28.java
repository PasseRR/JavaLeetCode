package com.gitee.passerr.leetcode.problem.lcof.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.function.BiFunction;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * |    1
 * |   / \
 * |  2   2
 * | / \ / \
 * |3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * |    1
 * |   / \
 * |  2   2
 * |   \   \
 * |   3    3
 * <p>
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 * 限制：
 * 0 <= 节点个数 <= 1000
 * @author xiehai
 * @date 2020/07/04 15:53
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof28 {
    public boolean isSymmetric(TreeNode root) {
        BiFunction<TreeNode, TreeNode, Boolean> recursion = new BiFunction<TreeNode, TreeNode, Boolean>() {
            @Override
            public Boolean apply(TreeNode left, TreeNode right) {
                return
                    // 若其中一个为null
                    left == null || right == null
                        // 两者均为null则对称
                        ? left == right
                        // 都不为空 左右对称
                        : left.val == right.val
                        && this.apply(left.left, right.right)
                        && this.apply(left.right, right.left);
            }
        };

        return root == null || recursion.apply(root.left, root.right);
    }
}
