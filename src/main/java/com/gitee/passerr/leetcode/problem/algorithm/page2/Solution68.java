package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 说明:
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * <p>
 * 示例:
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * <p>
 * 示例 2:
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 * 第二行同样为左对齐，这是因为这行只包含一个单词。
 * <p>
 * 示例 3:
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 * @author xiehai
 * @date 2019/07/16 13:55
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        // 结果集
        List<String> result = new ArrayList<>();
        // 当前总长度
        int currentLength = 0;
        // 当前预置单词
        List<String> basket = new ArrayList<>();
        // 左对齐
        BiFunction<Integer, List<String>, String> leftJustify = (length, list) -> {
            int size = list.size();
            int left = maxWidth - length;
            return
                IntStream.range(0, size)
                    .mapToObj(index ->
                        index == size - 1
                            // 最后一个单词后补全所有空格
                            ? list.get(index) + (left > 0 ? String.join("", Collections.nCopies(left, " ")) : "")
                            // 非最后一个单词 只用一个空格分隔
                            : list.get(index) + " "
                    )
                    .collect(Collectors.joining());
        };
        // 单词转行
        BiFunction<Integer, List<String>, String> generateRow = (length, list) -> {
            // 单词个数
            int size = list.size();
            if (size == 1) {
                return leftJustify.apply(length, list);
            }
            // 剩余宽度
            int left = maxWidth - length;
            // 每个单词间补充空格数量
            int supplySpace = left / (size - 1);
            // 多余补充空格数量
            int leftSupplySpace = left % (size - 1);

            return
                IntStream.range(0, size)
                    .mapToObj(index -> {
                        // 补充空格数量 = 平均补充空格数量 + 多余补充空格
                        int spaces = supplySpace + (index < leftSupplySpace ? 1 : 0) + 1;
                        return index == size - 1
                            // 最后一个单词不加空格
                            ? list.get(index)
                            // 非最后一个单词需要加一个固定空格+补充空格
                            : list.get(index) + String.join("", Collections.nCopies(spaces, " "));
                    })
                    .collect(Collectors.joining());
        };

        for (String word : words) {
            if (currentLength + word.length() + (currentLength == 0 ? 0 : 1) > maxWidth) {
                // 生成一行数据
                result.add(generateRow.apply(currentLength, basket));
                // 重置预选篮子
                basket.clear();
                // 重置长度
                currentLength = word.length();
            } else {
                // 当前有单词则追加一个空格 否则不加空格
                currentLength += word.length() + (currentLength == 0 ? 0 : 1);
            }
            basket.add(word);
        }

        if (!basket.isEmpty()) {
            // 最后一行 左对齐
            result.add(leftJustify.apply(currentLength, basket));
        }

        return result;
    }
}
