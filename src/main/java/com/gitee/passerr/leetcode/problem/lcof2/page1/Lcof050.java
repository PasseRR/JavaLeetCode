package com.gitee.passerr.leetcode.problem.lcof2.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

/**
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 示例 1：
 * 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 * 输出：3
 * 解释：和等于 8 的路径有 3 条，如图所示。
 * <p>
 * 示例 2：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：3
 * <p>
 * 提示:
 * 二叉树的节点个数的范围是 [0,1000]
 * -10<sup>9</sup> <= Node.val <= 10<sup>9</sup>
 * -1000<= targetSum<= 1000
 * <p>
 * 注意：本题与主站 437题相同：https://leetcode-cn.com/problems/path-sum-iii/
 * @author xiehai
 * @date 2022/01/17 16:14
 */
public class Lcof050 {
    public int pathSum(TreeNode root, int targetSum) {
        // 1000个10^9已经int溢出了 前缀用long
        Map<Long, Integer> prefix = new HashMap<>(16);
        // 当前前缀和刚好和目标值相等
        prefix.put(0L, 1);

        BiFunction<Long, TreeNode, Integer> backtrack = new BiFunction<Long, TreeNode, Integer>() {
            @Override
            public Integer apply(Long current, TreeNode node) {
                if (Objects.isNull(node)) {
                    return 0;
                }
                current += node.val;
                // 若刚好存在一个前缀和与当前前缀和差值为目标值
                int result = prefix.getOrDefault(current - targetSum, 0);

                prefix.merge(current, 1, Integer::sum);
                // 左树递归
                result += this.apply(current, node.left);
                // 右树递归
                result += this.apply(current, node.right);
                // 树回溯遍历
                prefix.merge(current, -1, Integer::sum);

                return result;
            }
        };

        return backtrack.apply(0L, root);
    }
}
