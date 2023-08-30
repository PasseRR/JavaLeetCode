package com.gitee.passerr.leetcode.problem.algorithm.page2;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * <p>
 * 示例:
 * 输入: 3
 * 输出:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释:
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * @author xiehai
 * @date 2019/07/25 15:31
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see Solution96
 */
public class Solution95 {
    // #region snippet
    public List<TreeNode> generateTrees(int n) {
        BiFunction<Integer, Integer, List<TreeNode>> generate = new BiFunction<Integer, Integer, List<TreeNode>>() {
            @Override
            public List<TreeNode> apply(Integer start, Integer end) {
                List<TreeNode> list = new ArrayList<>();
                if (start > end) {
                    list.add(null);
                    return list;
                }

                for (int i = start; i <= end; i++) {
                    // 构造左二叉搜索树
                    List<TreeNode> leftTrees = this.apply(start, i - 1);
                    // 构造右二叉搜索树
                    List<TreeNode> rightTrees = this.apply(i + 1, end);
                    // 组合成二叉树
                    for (TreeNode left : leftTrees) {
                        for (TreeNode right : rightTrees) {
                            TreeNode root = new TreeNode(i);
                            root.left = left;
                            root.right = right;
                            list.add(root);
                        }
                    }
                }

                return list;
            }
        };

        return n == 0 ? new ArrayList<>() : generate.apply(1, n);
    }
    // #endregion snippet
}
