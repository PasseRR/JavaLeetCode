package com.gitee.passerr.leetcode.problem.algorithm.page2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 * <p>
 * 示例 1:
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * <p>
 * 示例 2:
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 *      给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
 *      因此，当 n = 0 时，其格雷编码序列为 [0]。
 * @author xiehai
 * @date 2019/07/22 17:25
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution89 {
    // #region snippet
    public List<Integer> grayCode(int n) {
        if (n == 0) {
            return Collections.singletonList(0);
        } else if (n == 1) {
            return Arrays.asList(0, 1);
        } else {
            // 00 01 n = 1
            // 00 01 10 11 n = 2
            // 00 01 10 11 111 110 101 100 n = 3
            // 比小1的數字多一个倒叙高位为1的序列
            List<Integer> list = this.grayCode(n - 1);
            List<Integer> result = new ArrayList<>(list);

            // 倒敘 高位补1
            IntStream.rangeClosed(0, list.size() - 1)
                .map(index -> list.get(list.size() - 1 - index) | (int) Math.pow(2, n - 1))
                .forEach(result::add);

            return result;
        }
    }
    // #endregion snippet
}
