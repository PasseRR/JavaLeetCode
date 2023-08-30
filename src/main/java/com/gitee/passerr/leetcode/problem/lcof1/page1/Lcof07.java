package com.gitee.passerr.leetcode.problem.lcof1.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 例如，给出
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * |    3
 * |   / \
 * |  9  20
 * |    /  \
 * |   15   7
 * <p>
 * 限制：
 * 0 <= 节点个数 <= 5000
 * @author xiehai
 * @date 2020/07/04 14:31
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof07 {
    // #region snippet
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 缓存索引
        Map<Integer, Integer> cacheIndex =
            IntStream.range(0, inorder.length)
                .boxed()
                .collect(Collectors.toMap(it -> inorder[it], it -> it));

        // 前序第一个节点为根节点
        // 中序根节点左边为左树 右边为右树
        // pre = [3, 9, 20, 15, 7] in = [9, 3, 15, 20, 7]
        // 在中序中3左边部分[9]为左树 3右边部分[15, 20, 7]为右树
        // 递归生成左右树
        BiFunction<Integer, int[], TreeNode> recursion = new BiFunction<Integer, int[], TreeNode>() {
            @Override
            public TreeNode apply(Integer preIndex, int[] inIndices) {
                // 超出范围或者左右树索引错误
                if (preIndex >= preorder.length || inIndices[0] > inIndices[1]) {
                    return null;
                }
                TreeNode node = new TreeNode(preorder[preIndex]);
                // 找到前序节点值在中序中的位置
                int mid = cacheIndex.get(preorder[preIndex]);
                // 递归左树 当前根节点前序下一位置开始
                node.left = this.apply(preIndex + 1, new int[]{inIndices[0], mid - 1});
                // 递归右树 当前根节点+左树索引长度
                node.right = this.apply(preIndex + mid - inIndices[0] + 1, new int[]{mid + 1, inIndices[1]});

                return node;
            }
        };

        return recursion.apply(0, new int[]{0, inorder.length - 1});
    }
    // #endregion snippet
}
