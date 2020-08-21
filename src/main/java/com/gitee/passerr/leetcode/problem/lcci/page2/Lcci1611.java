package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。
 * 你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例 1
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： [3,4,5,6]
 * 解释：
 * 可以使用 3 次 shorter，得到结果 3；使用 2 次 shorter 和 1 次 longer，得到结果 4 。以此类推，得到最终结果。
 * <p>
 * 提示：
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * @author xiehai
 * @date 2020/08/21 14:15
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1611 {
    public int[] divingBoard(int shorter, int longer, int k) {
        // 0块木板
        if (k == 0) {
            return new int[0];
        }
        // 两种木板长度一致 只有一种长度
        if (shorter == longer) {
            return new int[]{shorter * k};
        }

        // 初始最小值及每个长度间的步长
        int starter = shorter * k, step = longer - shorter;
        int[] result = new int[k + 1];
        // k块木板可能长度为k+1种
        for (int i = 0; i <= k; i++) {
            result[i] = starter + i * step;
        }

        return result;
    }
}
