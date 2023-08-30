package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 * <p>
 * 示例1:
 * 输入："aabcccccaaa"
 * 输出："a2b1c5a3"
 * <p>
 * 示例2:
 * 输入："abbccd"
 * 输出："abbccd"
 * 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * <p>
 * 提示：
 * 字符串长度在[0, 50000]范围内。
 * @author xiehai
 * @date 2020/06/05 15:52
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0106 {
    // #region snippet
    public String compressString(String S) {
        int len = S.length();
        // 长度小于3 直接返回源字符串
        if (len <= 2) {
            return S;
        }

        // 拿到第一个字符
        char previous = S.charAt(0);
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < len; i++) {
            char current = S.charAt(i);
            // 与前一个字符不一样
            if (current != previous) {
                // 拼接字符及数量
                sb.append(previous).append(count);

                // 重置
                count = 1;
                previous = current;
            } else {
                // 计数
                count++;
            }
        }

        // 拼接尾部字符及数量
        sb.append(previous).append(count);

        return sb.length() > len ? S : sb.toString();
    }
    // #endregion snippet
}
