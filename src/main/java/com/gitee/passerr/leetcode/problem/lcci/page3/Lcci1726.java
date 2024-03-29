package com.gitee.passerr.leetcode.problem.lcci.page3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个(具有不同单词的)文档的交集(intersection)中元素的个数除以并集(union)中元素的个数，就是这两个文档的相似度。
 * 例如，{1, 5, 3} 和 {1, 7, 2, 3} 的相似度是 0.4，其中，交集的元素有 2 个，并集的元素有 5 个。
 * 给定一系列的长篇文档，每个文档元素各不相同，并与一个 ID 相关联。它们的相似度非常“稀疏”，也就是说任选 2 个文档，相似度都很接近 0。
 * 请设计一个算法返回每对文档的 ID 及其相似度。只需输出相似度大于 0 的组合。请忽略空文档。
 * 为简单起见，可以假定每个文档由一个含有不同整数的数组表示。
 * <p>
 * 输入为一个二维数组 docs，docs[i]表示id 为 i 的文档。返回一个数组，其中每个元素是一个字符串，代表每对相似度大于 0 的文档，
 * 其格式为 {id1},{id2}: {similarity}，其中 id1 为两个文档中较小的 id，similarity 为相似度，精确到小数点后 4 位。
 * 以任意顺序返回数组均可。
 * <p>
 * 示例:
 * 输入:
 * .[
 * . [14, 15, 100, 9, 3],
 * . [32, 1, 9, 3, 5],
 * . [15, 29, 2, 6, 8, 7],
 * . [7, 10]
 * .]
 * 输出:
 * .[
 * . "0,1: 0.2500",
 * . "0,2: 0.1000",
 * . "2,3: 0.1429"
 * .]
 * <p>
 * 提示：
 * docs.length <= 500
 * docs[i].length <= 500
 * @author xiehai
 * @date 2021/06/24 16:16
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1726 {
    // #region snippet
    public List<String> computeSimilarities(int[][] docs) {
        int len = docs.length;
        List<String> result = new ArrayList<>();
        // 两行之间交集个数
        int[][] dp = new int[len][len];
        // 数字出现的行
        Map<Integer, List<Integer>> cache = new HashMap<>(8);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < docs[i].length; j++) {
                List<Integer> value = cache.getOrDefault(docs[i][j], new ArrayList<>());
                // 数字第一次出现
                if (value.isEmpty()) {
                    cache.put(docs[i][j], value);
                } else {
                    // 记录交集数量
                    for (Integer index : value) {
                        dp[index][i]++;
                    }
                }
                value.add(i);
            }
        }

        // 第i行到前i行之后的稀疏度
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (dp[i][j] > 0) {
                    result.add(
                        String.format(
                            "%d,%d: %.4f",
                            i,
                            j,
                            dp[i][j] * 1.0D / (docs[i].length + docs[j].length - dp[i][j])
                        )
                    );
                }
            }
        }

        return result;
    }
    // #endregion snippet
}
