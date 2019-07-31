package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.problem.algorithm.TreeNode;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * @author xiehai
 * @date 2019/07/25 17:23
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = inorder.length;
        // 缓存中序元素值及索引
        Map<Integer, Integer> cache = IntStream.range(0, length)
            .boxed()
            .collect(Collectors.toMap(t -> inorder[t], t -> t));

        TrFunction<Integer, Integer, Integer, TreeNode> recursion =
            new TrFunction<Integer, Integer, Integer, TreeNode>() {
                /**
                 * 递归根据前序、中序生成树
                 * @param index 根节点在前序中的索引
                 * @param inOrderBegin 左树/右树在中序中开始索引
                 * @param inOrderEnd 左树/右树在中序中结束索引
                 * @return
                 */
                @Override
                public TreeNode apply(Integer index, Integer inOrderBegin, Integer inOrderEnd) {
                    int rootValue = preorder[index];
                    TreeNode node = new TreeNode(rootValue);
                    // 根节点在中序中的索引位置
                    int inOrderIndex = cache.get(rootValue);
                    // 左树长度
                    int leftLength = inOrderIndex - inOrderBegin;
                    // 存在左树
                    if (leftLength > 0) {
                        // 递归生成左树
                        node.left = this.apply(index + 1, inOrderBegin, inOrderIndex - 1);
                    }
                    // 存在右树
                    if (inOrderEnd - inOrderIndex > 0) {
                        // 递归生成右树
                        node.right = this.apply(index - inOrderBegin + inOrderIndex + 1, inOrderIndex + 1, inOrderEnd);
                    }
                    return node;
                }
            };

        // 兼容空數組
        return length == 0 ? null : recursion.apply(0, 0, length - 1);
    }

    private interface TrFunction<T1, T2, T3, R> {
        R apply(T1 t1, T2 t2, T3 t3);
    }
}
