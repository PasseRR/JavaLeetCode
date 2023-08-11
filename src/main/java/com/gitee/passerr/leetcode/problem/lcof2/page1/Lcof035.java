package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。
 * <p>
 * 示例 1：
 * 输入：timePoints = ["23:59","00:00"]
 * 输出：1
 * <p>
 * 示例 2：
 * 输入：timePoints = ["00:00","23:59","00:00"]
 * 输出：0
 * <p>
 * 提示：
 * 2 <= timePoints <= 2 * 104
 * timePoints[i] 格式为 "HH:MM"
 * <p>
 * 注意：本题与主站 539题相同：https://leetcode.cn/problems/minimum-time-difference/
 * @author xiehai
 * @date 2022/01/10 18:22
 */
public class Lcof035 {
    public int findMinDifference(List<String> timePoints) {
        // 一天的分钟数
        final int minutesOfDay = 24 * 60;

        // 存在重复时间 提前结束
        if (timePoints.size() > minutesOfDay) {
            return 0;
        }

        // 从时刻列表中提取分钟并转为数字
        int len = timePoints.size(), index = 0;
        int[] minutes = new int[len + 1];
        for (String it : timePoints) {
            minutes[index++] = Integer.parseInt(it.substring(0, 2)) * 60 + Integer.parseInt(it.substring(3, 5));
        }
        // 末尾追加第一个时刻并加一天的分钟数 用于计算最大最小时刻跨天相差分钟数
        // 初始值为最大分钟数加1
        minutes[index] = minutesOfDay + 1;
        // 分钟数排序
        Arrays.sort(minutes);
        // 设置最大值为第一个分钟数加一天的分钟数
        minutes[index] = minutes[0] + minutesOfDay;

        int min = minutesOfDay;
        // 两个相邻的时间肯定是最小的
        for (int i = 1; i <= len; i++) {
            min = Integer.min(min, minutes[i] - minutes[i - 1]);
        }

        return min;
    }
}
