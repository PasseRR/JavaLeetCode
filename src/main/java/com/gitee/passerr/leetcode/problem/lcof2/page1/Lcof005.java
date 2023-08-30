package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * 给定一个字符串数组words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。
 * 假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 * <p>
 * 示例1:
 * 输入: words = ["abcw","baz","foo","bar","fxyz","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "fxyz"。它们不包含相同字符，且长度的乘积最大。
 * <p>
 * 示例 2:
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * <p>
 * 示例 3:
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 * <p>
 * 提示：
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i]仅包含小写字母
 * <p>
 * 注意：本题与主站 318题相同：https://leetcode.cn/problems/maximum-product-of-word-lengths/
 * @author xiehai
 * @date 2021/12/13 09:49
 */
public class Lcof005 {
    // #region snippet
    public int maxProduct(String[] words) {
        int len = words.length, result = 0;
        int[] bits = new int[len];

        // 26个字母 使用int的位标记
        for (int i = 0; i < len; i++) {
            for (char c : words[i].toCharArray()) {
                bits[i] |= 1 << (c - 'a');
            }
        }

        // 不包含相同字符的一对字符串 意思两个字符串中没有相同字符 同一个字符串允许相同字符
        for (int i = 0; i < len; i++) {
            int l = words[i].length();
            for (int j = i + 1; j < len; j++) {
                // 判断两个字符串没有相同字符 若或结果与异或结果相同表示没有相同的位
                if ((bits[i] | bits[j]) == (bits[i] ^ bits[j])) {
                    // 结果为长度乘积
                    result = Integer.max(l * words[j].length(), result);
                }
            }
        }

        return result;
    }
    // #endregion snippet
}
