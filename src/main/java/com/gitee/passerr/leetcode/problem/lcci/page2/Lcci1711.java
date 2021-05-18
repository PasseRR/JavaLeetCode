package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。
 * 如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 * <p>
 * 示例：
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 * <p>
 * 提示：
 * words.length <= 100000
 * @author xiehai
 * @date 2021/05/18 09:15
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1711 {
    public int findClosest(String[] words, String word1, String word2) {
        List<Integer> q1 = new ArrayList<>(), q2 = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                q1.add(i);
            }

            if (words[i].equals(word2)) {
                q2.add(i);
            }
        }

        // 令q1为长度较长的一个索引列表 q2为较短的一个
        List<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        int result = Integer.MAX_VALUE, len2 = q2.size();
        for (Integer i1 : q1) {
            // 待插入的位置索引
            int i2 = -(Collections.binarySearch(q2, i1) + 1);
            int min;
            if (i2 == len2) {
                min = Math.abs(i1 - q2.get(len2 - 1));
            } else if (i2 == 0) {
                min = Math.abs(i1 - q2.get(0));
            } else {
                // 中间插入 比较左右两个值取较小一个
                min = Integer.min(Math.abs(i1 - q2.get(i2)), Math.abs(i1 - q2.get(i2 - 1)));
            }
            // 插入最后会越界
            result = Integer.min(min, result);
        }


        return result;
    }
}
