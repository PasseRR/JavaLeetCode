package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Arrays;

/**
 * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。
 * <p>
 * 示例：
 * 输入： arr = [1,3,5,7,2,4,6,8], k = 4
 * 输出： [1,2,3,4]
 * 提示：
 * 0 <= len(arr) <= 100000
 * 0 <= k <= min(100000, len(arr))
 * @author xiehai
 * @date 2021/05/26 17:15
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1714 {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);

        return Arrays.copyOfRange(arr, 0, k);
    }
}
