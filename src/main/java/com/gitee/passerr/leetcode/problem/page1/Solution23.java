package com.gitee.passerr.leetcode.problem.page1;

import com.gitee.passerr.leetcode.problem.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * @author xiehai
 * @date 2019/07/03 16:42
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution23 {
    public ListNode mergeKListsTle(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode cursor = head;

        // 通过合并链表来处理
        return null;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode cursor = head;
        // 使用缓存 数字及出现次数
        Map<Integer, Integer> cache = new HashMap<>(16);
        for (ListNode list : lists) {
            ListNode node = list;
            while (null != node) {
                // 累加数字出现次数
                cache.merge(node.val, 1, (o, n) -> o + n);
                node = node.next;
            }
        }

        // 遍历缓存有小到大构造链表
        for (Integer key : cache.keySet().stream().sorted().collect(Collectors.toList())) {
            for (int i = 0; i < cache.get(key); i++) {
                cursor.next = new ListNode(key);
                cursor = cursor.next;
            }
        }

        return head.next;
    }
}
