package com.gitee.passerr.leetcode.problem.lcci.page3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 * <p>
 * 示例 1:
 * 输入:
 * big = [7,5,9,0,2,1,3,5,7,9,1,1,5,8,8,9,7]
 * small = [1,5,9]
 * 输出: [7,10]
 * <p>
 * 示例 2:
 * 输入:
 * big = [1,2,3]
 * small = [4]
 * 输出: []
 * <p>
 * 提示：
 * big.length<= 100000
 * 1 <= small.length<= 100000
 * @author xiehai
 * @date 2021/05/28 18:04
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1718 {
    // #region snippet
    public int[] shortestSeq(int[] big, int[] small) {
        // 长度不足
        if (small.length > big.length) {
            return new int[0];
        }

        // 大数组数字全集
        Set<Integer> collect = Arrays.stream(big).boxed().collect(Collectors.toSet());
        // 小数组数字出现频率
        Set<Integer> required = Arrays.stream(small).boxed().collect(Collectors.toSet());
        // 小数组包含大数组没有的元素
        if (!collect.containsAll(required)) {
            return new int[0];
        }


        int[] result = new int[]{0, big.length - 1};
        // 左边界、右边界、命中数字次数
        int left = 0, right = 0, hits = 0;
        Map<Integer, Integer> container = new HashMap<>(16);
        while (right < big.length) {
            if (required.contains(big[right])) {
                container.merge(big[right], 1, Integer::sum);

                // 数字命中
                if (container.get(big[right]) == 1) {
                    hits++;
                }
            }

            // 找到满足条件的解 欢动窗口收缩边界
            while (hits == required.size()) {
                // 找到更短或者更靠左边的解
                if (right - left < result[1] - result[0]
                    || (right - left == result[1] - result[0] && left < result[0])) {
                    result[0] = left;
                    result[1] = right;
                }

                if (required.contains(big[left])) {
                    container.computeIfPresent(big[left], (k, v) -> v - 1);
                    // 收缩左边边界导致当前窗口不满足数字出现次数
                    if (container.get(big[left]) == 0) {
                        hits--;
                    }
                }
                // 收缩左边界
                left++;
            }
            // 扩展右边界
            right++;
        }

        return result;
    }
    // #endregion snippet
}
