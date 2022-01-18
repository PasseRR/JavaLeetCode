package com.gitee.passerr.leetcode.problem.lcof2.page1;

import com.gitee.passerr.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 示例 1：
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 示例 2：
 * 输入：root = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 示例 4：
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * 提示：
 * 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，也可以采用其他的方法解决这个问题。
 * 树中结点数在范围 [0, 10<sup>4</sup>] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * 注意：本题与主站 297题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * @author xiehai
 * @date 2022/01/17 13:56
 */
public class Lcof048 {
}

class Codec {
    private static final String COMMA = ",";
    private static final String NULL = "null";

    /**
     * Encodes a tree to a single string
     * @param root {@link TreeNode}
     * @return serialize string
     */
    public String serialize(TreeNode root) {
        // 空树返回null
        if (root == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>(Collections.singletonList(root));

        TreeNode t;
        // 按照层序序列化
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = size; i > 0; i--) {
                t = queue.poll();
                if (t != null) {
                    sb.append(t.val);
                    queue.offer(t.left);
                    queue.offer(t.right);
                } else {
                    sb.append(NULL);
                }
                sb.append(COMMA);
            }
        }

        // 删除最后一个逗号
        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    /**
     * Decodes your encoded data to tree
     * @param data serialize string
     * @return {@link TreeNode}
     */
    public TreeNode deserialize(String data) {
        // null表示空树
        if (data == null) {
            return null;
        }

        int start = 0;
        List<String> nums = Arrays.stream(data.split(COMMA)).collect(Collectors.toList());

        // 初始化根节点
        TreeNode root = new TreeNode(Integer.parseInt(nums.get(start)));
        Queue<TreeNode> queue = new ArrayDeque<>(Collections.singletonList(root));

        TreeNode t;
        String l, r;
        // 依次解析左右树
        while (!queue.isEmpty()) {
            t = queue.poll();
            l = nums.get(++start);
            r = nums.get(++start);
            if (!NULL.equals(l)) {
                TreeNode nodeLeft = new TreeNode(Integer.parseInt(l));
                t.left = nodeLeft;
                queue.offer(nodeLeft);
            }

            if (!NULL.equals(r)) {
                TreeNode nodeRight = new TreeNode(Integer.parseInt(r));
                t.right = nodeRight;
                queue.offer(nodeRight);
            }
        }

        return root;
    }
}
