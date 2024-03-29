package com.gitee.passerr.leetcode.problem.lcof2.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;

/**
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1个节点）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一个用完全二叉树初始化的数据结构CBTInserter，它支持以下几种操作：
 * <p>
 * CBTInserter(TreeNode root)使用根节点为root的给定树初始化该数据结构；
 * CBTInserter.insert(int v) 向树中插入一个新节点，节点类型为 TreeNode，值为 v 。
 * 使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的根节点。
 * <p>
 * 示例 1：
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 * <p>
 * 示例 2：
 * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
 * <p>
 * 提示：
 * 最初给定的树是完全二叉树，且包含1到1000个节点。
 * 每个测试用例最多调用CBTInserter.insert 操作10000次。
 * 给定节点或插入节点的每个值都在0到5000之间。
 * <p>
 * 注意：本题与主站 919题相同：https://leetcode.cn/problems/complete-binary-tree-inserter/
 * @author xiehai
 * @date 2022/01/14 16:45
 */
public class Lcof043 {
}

// #region snippet
class CBTInserter {
    TreeNode root;
    Queue<TreeNode> queue = new ArrayDeque<>();

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue.offer(root);
        // 保证队列里面的节点没有完整的子节点(缺少左或右子树)
        while (Objects.nonNull(queue.peek().left) && Objects.nonNull(queue.peek().right)) {
            queue.offer(queue.peek().left);
            queue.offer(queue.poll().right);
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode head = queue.peek();
        // 若头结点的左子节点不存在 则头结点还可以继续添加右子节点
        if (Objects.isNull(head.left)) {
            head.left = node;
        } else if (Objects.isNull(head.right)) {
            // 当队列头结点右子树为空时，表名此节点已经是完全树
            head.right = node;
            // 弹出头结点 添加当天节点左右树进队列
            queue.poll();
            queue.offer(head.left);
            queue.offer(head.right);
        }

        return head.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
// #endregion snippet
