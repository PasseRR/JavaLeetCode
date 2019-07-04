package com.gitee.passerr.leetcode.problem.page1;

import com.gitee.passerr.leetcode.problem.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
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
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> list = Arrays.asList(lists);
        // 合并两个有序链表
        BiFunction<ListNode, ListNode, ListNode> merge = (l1, l2) -> {
            ListNode node = new ListNode(0);
            ListNode cursor = node;
            while (null != l1 && null != l2) {
                if (l1.val > l2.val) {
                    cursor.next = new ListNode(l2.val);
                    l2 = l2.next;
                } else {
                    cursor.next = new ListNode(l1.val);
                    l1 = l1.next;
                }
                cursor = cursor.next;
            }

            // l1多余l2的部分
            while (null != l1) {
                cursor.next = new ListNode(l1.val);
                l1 = l1.next;
                cursor = cursor.next;
            }
            // l2多余l1的部分
            while (null != l2) {
                cursor.next = new ListNode(l2.val);
                l2 = l2.next;
                cursor = cursor.next;
            }

            return node.next;
        };

        // 合并链表集合 直到只剩一个链表
        while (list.size() > 1) {
            List<ListNode> switcher = new ArrayList<>();
            for (int i = 0, length = list.size(); i < length; i++) {
                ListNode l1 = list.get(i);
                ListNode l2 = (i + 1) >= length ? null : list.get(i + 1);
                switcher.add(merge.apply(l1, l2));
            }
            list = switcher;
        }


        return list.isEmpty() ? null : list.get(0);
    }

    public ListNode mergeKLists2(ListNode[] lists) {
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

        // 遍历缓存由小到大构造链表
        for (Integer key : cache.keySet().stream().sorted().collect(Collectors.toList())) {
            for (int i = 0; i < cache.get(key); i++) {
                cursor.next = new ListNode(key);
                cursor = cursor.next;
            }
        }

        return head.next;
    }
}
