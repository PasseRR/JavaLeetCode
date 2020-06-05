package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * 示例 1:
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * <p>
 * 示例 2:
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 * @author xiehai
 * @date 2020/06/05 15:49
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0105 {
    public boolean oneEditAway(String first, String second) {
        int firstLen = first.length(), secondLen = second.length();
        // 长度都小于1
        if (firstLen <= 1 && secondLen <= 1) {
            return true;
        }

        // 长度相差超过1
        if (Math.abs(firstLen - secondLen) > 1) {
            return false;
        }

        // 保证第一个字符串为较短的字符串
        if (firstLen > secondLen) {
            firstLen ^= secondLen;
            secondLen ^= firstLen;
            firstLen ^= secondLen;
            String temp = first;
            first = second;
            second = temp;
        }

        int i = 0, j = 0, flag = 1;
        // 双指针遍历
        while (i < firstLen && j < secondLen) {
            // 字符相同
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                // 长度相同 则都进一位表示 替换字符操作
                if (firstLen == secondLen) {
                    i++;
                }
                // 长度不同 跳过长字符串一次 这里可看做插入或删除字符操作
                j++;
                // 编辑次数减少
                flag--;
            }

            // 编辑次数大于1次
            if (flag < 0) {
                return false;
            }
        }

        return true;
    }
}
