package com.gitee.passerr.leetcode.problem.algorithm.page3;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * @author xiehai
 * @date 2019/07/31 11:09
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see Solution105
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 类似前序中序转树
        // 后续最后一个数字为根节点 在中序中根据根节点分为两段 左边为左树 右边为右树
        // 后续中以根节点向前分为两段先右树 再左树 长度对应中序中左右树长度

        int length = inorder.length;
        // 缓存中序元素值及索引
        Map<Integer, Integer> cache = IntStream.range(0, length)
            .boxed()
            .collect(Collectors.toMap(t -> inorder[t], t -> t));

        TrFunction<Integer, Integer, Integer, TreeNode> recursion =
            new TrFunction<Integer, Integer, Integer, TreeNode>() {
                @Override
                public TreeNode apply(Integer index, Integer inOrderBegin, Integer inOrderEnd) {
                    int rootValue = postorder[index];
                    TreeNode node = new TreeNode(rootValue);
                    // 根节点在中序中的索引位置
                    int inOrderIndex = cache.get(rootValue);
                    // 右树长度
                    int rightLength = inOrderEnd - inOrderIndex;
                    // 存在右树
                    if (rightLength > 0) {
                        // 递归生成右树
                        node.right = this.apply(index - 1, inOrderIndex + 1, inOrderEnd);
                    }
                    // 存在左树
                    if (inOrderIndex - inOrderBegin > 0) {
                        // 递归生成左树
                        node.left = this.apply(index - rightLength - 1, inOrderBegin, inOrderIndex - 1);
                    }
                    return node;
                }
            };

        return length == 0 ? null : recursion.apply(length - 1, 0, length - 1);
    }

    private interface TrFunction<T1, T2, T3, R> {
        R apply(T1 t1, T2 t2, T3 t3);
    }
}
