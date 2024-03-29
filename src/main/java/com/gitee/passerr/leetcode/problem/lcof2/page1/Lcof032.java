package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断它们是不是一组变位词（字母异位词）。
 * <p>
 * 注意：若s 和 t中每个字符出现的次数都相同且字符顺序不完全相同，则称s 和 t互为变位词（字母异位词）。
 * <p>
 * 示例1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: s = "a", t = "a"
 * 输出: false
 * <p>
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * sandt仅包含小写字母
 * <p>
 * 进阶:如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 注意：本题与主站 242题相似（字母异位词定义不同）：https://leetcode.cn/problems/valid-anagram/
 * @author xiehai
 * @date 2022/01/10 10:06
 */
public class Lcof032 {
    // #region snippet
    public boolean isAnagram(String s, String t) {
        int len = s.length();
        // 长度不一样 肯定不是
        if (len != t.length()) {
            return false;
        }

        // 是否是异位字符串
        boolean flag = false;
        // 记录字符出现次数
        int[] cache = new int[26];
        for (int i = 0; i < len; i++) {
            if (!flag && s.charAt(i) != t.charAt(i)) {
                flag = true;
            }
            // s字符累加
            cache[s.charAt(i) - 'a']++;
            // t字符累减
            cache[t.charAt(i) - 'a']--;
        }

        // 字符出现顺序一样
        if (!flag) {
            return false;
        }

        // 判断每个字符出现次数是否一样
        for (int c : cache) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
    // #endregion snippet
}
