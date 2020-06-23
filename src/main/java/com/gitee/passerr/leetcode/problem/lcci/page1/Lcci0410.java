package com.gitee.passerr.leetcode.problem.lcci.page1;

import com.gitee.passerr.leetcode.TreeNode;

/**
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 * <p>
 * 示例1:
 * 输入：t1 = [1, 2, 3], t2 = [2]
 * 输出：true
 * <p>
 * 示例2:
 * 输入：t1 = [1, null, 2, 4], t2 = [3, 2]
 * 输出：false
 * <p>
 * 提示：
 * 树的节点数目范围为[0, 20000]。
 * @author xiehai
 * @date 2020/06/23 09:21
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0410 {
    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        // 子树为空
        if(t2 == null) {
            return true;
        }

        // 主树为空
        if(t1 == null) {
            return false;
        }

        return
            // 节点值是否一致
            t1.val == t2.val
                // 继续比较左右树
                ? this.checkSubTree(t1.right, t2.right) && this.checkSubTree(t1.left, t2.left)
                // 继续用左右树判断
                : (this.checkSubTree(t1.left, t2) || this.checkSubTree(t1.right, t2));
    }
}
