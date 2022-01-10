package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.function.BiFunction;

/**
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，
 * 返回 true；否则，返回 false。
 * <p>
 * 示例 1：
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * <p>
 * 示例 2：
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * <p>
 * 示例 3：
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 * <p>
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在words[i]和order中的所有字符都是英文小写字母。
 * <p>
 * 注意：本题与主站 953题相同：https://leetcode-cn.com/problems/verifying-an-alien-dictionary/
 * @author xiehai
 * @date 2022/01/10 14:29
 */
public class Lcof034 {
    public boolean isAlienSorted(String[] words, String order) {
        int lenOrder = order.length();
        // 字典顺序
        int[] dict = new int[lenOrder];
        for (int i = 0; i < lenOrder; i++) {
            dict[order.charAt(i) - 'a'] = i;
        }

        // s1排序是否小于s2的字典排序
        BiFunction<String, String, Boolean> compare = (s1, s2) -> {
            int len1 = s1.length(), len2 = s2.length(), min = Integer.min(len1, len2);
            for (int i = 0; i < min; i++) {
                // 比较字符索引位置
                int c = dict[s1.charAt(i) - 'a'] - dict[s2.charAt(i) - 'a'];
                if (c > 0) {
                    return false;
                } else if (c < 0) {
                    return true;
                }
            }

            // 若所有最小长度的字符串字符一致 则比较字符串长度
            return len1 <= len2;
        };

        int lenWords = words.length;
        for (int i = 1; i < lenWords; i++) {
            // 只需要保证单调递增
            if (!compare.apply(words[i - 1], words[i])) {
                return false;
            }
        }

        return true;
    }
}
