package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 * <p>
 * 示例1:
 * <p>
 * 输入："Mr John Smith    ", 13
 * 输出："Mr%20John%20Smith"
 * 示例2:
 * <p>
 * 输入："               ", 5
 * 输出："%20%20%20%20%20"
 * 提示：
 * <p>
 * 字符串长度在[0, 500000]范围内。
 * @author xiehai
 * @date 2020/06/05 15:06
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0103 {
    public String replaceSpaces(String S, int length) {
        String sub = S.substring(0, length);
        return sub.contains(" ") ? sub.replace(" ", "%20") : sub;
    }
}
