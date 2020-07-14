package com.gitee.passerr.leetcode.problem.lcof.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 示例:
 * 你可以将以下二叉树：
 * |    1
 * |   / \
 * |  2   3
 * |     / \
 * |    4   5
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @author xiehai
 * @date 2020/07/14 12:47
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof37 {
}
class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>(Collections.singletonList(root));

        // 按照层序序列化
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                TreeNode node = queue.poll();
                if (node != null) {
                    sb.append(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                } else {
                    sb.append("null");
                }
                sb.append(",");
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        int start = 0;
        List<String> nums = Arrays.stream(data.split(",")).collect(Collectors.toList());

        // 初始化根节点
        TreeNode root = new TreeNode(Integer.parseInt(nums.get(start)));
        Queue<TreeNode> queue = new ArrayDeque<>(Collections.singletonList(root));

        // 依次解析左右树
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String left = nums.get(++start);
            String right = nums.get(++start);
            if (!"null".equals(left)) {
                TreeNode nodeLeft = new TreeNode(Integer.parseInt(left));
                node.left = nodeLeft;
                queue.offer(nodeLeft);
            }

            if (!"null".equals(right)) {
                TreeNode nodeRight = new TreeNode(Integer.parseInt(right));
                node.right = nodeRight;
                queue.offer(nodeRight);
            }
        }

        return root;
    }
}
