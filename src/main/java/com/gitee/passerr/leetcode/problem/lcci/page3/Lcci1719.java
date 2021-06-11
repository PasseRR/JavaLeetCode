package com.gitee.passerr.leetcode.problem.lcci.page3;

/**
 * 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？
 * 以任意顺序返回这两个数字均可。
 * <p>
 * 示例 1:
 * 输入: [1]
 * 输出: [2,3]
 * <p>
 * 示例 2:
 * 输入: [2,3]
 * 输出: [1,4]
 * <p>
 * 提示：
 * nums.length <= 30000
 * @author xiehai
 * @date 2021/06/10 13:42
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1719 {
    public int[] missingTwo(int[] nums) {
        // 计算所有数字和及平方和
        int sum = 0, squaredSum = 0;
        for (int i = 1; i <= nums.length + 2; i++) {
            sum += i;
            squaredSum += i * i;
        }

        for (int num : nums) {
            sum -= num;
            squaredSum -= num * num;
        }

        // a + b = sum .....1
        // a^2 + b^2 = squaredSum
        // (a + b)^2 = a^2 + 2*a*b + b^2 = sum^2
        // 2*a*b = sum^2 - squaredSum
        // (a - b)^2 = (a + b)^2 - 4*a*b = sum^2 - 2*(sum^2 - squaredSum) = 2*squaredSum - sum^2
        // a - b = sqrt(2*squaredSum - sum^2) .....2
        // 结合等式1、2得 2*a = sum + sqrt(2*squaredSum - sum^2)
        int a = (int) ((Math.sqrt(2 * squaredSum - sum * sum) + sum) / 2);

        return new int[]{a, sum - a};
    }
}
