package com.gitee.passerr.leetcode.problem.lcci.page1;

import com.gitee.passerr.leetcode.ListNode;

/**
 * 编写一个函数，检查输入的链表是否是回文的。
 * <p>
 * 示例 1：
 * 输入： 1->2
 * 输出： false
 * <p>
 * 示例 2：
 * 输入： 1->2->2->1
 * 输出： true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @author xiehai
 * @date 2020/06/05 16:46
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0206 {
    // #region snippet
    public boolean isPalindrome(ListNode head) {
        int count = 0;
        ListNode node = head;
        // 计算节点数量
        while (node != null) {
            count++;
            node = node.next;
        }

        node = head;
        int mid = count / 2, cursor = 0;
        int[] left = new int[mid];
        // 缓存左边半段链表数值 指针移动到中间节点
        while (cursor < mid) {
            left[cursor++] = node.val;
            node = node.next;
        }
        // 若是奇数节点数 跳过中间节点判断
        if (count % 2 == 1) {
            node = node.next;
        }

        // 判断后半段链表和缓存数据的倒叙比较
        cursor = 0;
        while (cursor++ < mid) {
            if (left[mid - cursor] != node.val) {
                return false;
            }
            node = node.next;
        }

        return true;
    }
    // #endregion snippet
}
