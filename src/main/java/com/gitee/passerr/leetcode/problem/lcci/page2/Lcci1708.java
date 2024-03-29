package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。
 * 已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 * <p>
 * 示例：
 * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * 输出：6
 * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 * <p>
 * 提示：
 * height.length == weight.length <= 10000
 * @author xiehai
 * @date 2021/05/14 10:58
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1708 {
    // #region snippet
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] merge =
            IntStream.range(0, len)
                .mapToObj(it -> new int[]{height[it], weight[it]})
                // 按照身高升序、体重降序排序
                .sorted((a, b) -> a[0] == b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]))
                .toArray(int[][]::new);

        int[] dp = new int[len];
        int result = 0;
        // 查询区间单调递增元素个数方法
        // 体重降序 插入缓存中的数字都是低位索引
        for (int[] pair : merge) {
            // 在缓存数组中查找体重位置
            int i = Arrays.binarySearch(dp, 0, result, pair[1]);
            // 不在缓存中的数字 -1则为最小数字 -N表示可插入点-(len + 1)
            if (i < 0) {
                i = -(i + 1);
            }
            // 插入既定位置 若是体重相同覆盖
            dp[i] = pair[1];
            // 已有区间递增元素个数
            if (i == result) {
                ++result;
            }
        }

        return result;
    }
    // #endregion snippet
}
