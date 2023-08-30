package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 * <p>
 * 示例：
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 * <p>
 * 提示：
 * numbers.length == 2
 * @author xiehai
 * @date 2020/08/10 15:57
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1601 {
    // #region snippet
    public int[] swapNumbers(int[] numbers) {
        // 三次异或交换数字
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];

        return numbers;
    }
    // #endregion snippet
}
