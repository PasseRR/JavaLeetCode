package com.gitee.passerr.leetcode.problem.algorithm.page4;

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * 实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。
 * 调用 next() 将返回二叉搜索树中的下一个最小的数。
 * <p>
 * 示例：
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // 返回 3
 * iterator.next();    // 返回 7
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 9
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 15
 * iterator.hasNext(); // 返回 true
 * iterator.next();    // 返回 20
 * iterator.hasNext(); // 返回 false
 * @author xiehai
 * @date 2019/07/26 15:29
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution173 {
    // 中序遍历树 获得树list的迭代器
}

class BSTIterator {
    private Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        // 中序遍历树
        List<Integer> list = new ArrayList<>();
        // 中序遍历树
        Consumer<TreeNode> inorderTraversal = new Consumer<TreeNode>() {
            @Override
            public void accept(TreeNode node) {
                if (node == null) {
                    return;
                }
                this.accept(node.left);
                list.add(node.val);
                this.accept(node.right);
            }
        };
        inorderTraversal.accept(root);
        // 初始化迭代器
        this.iterator = list.iterator();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return this.iterator.next();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
}
