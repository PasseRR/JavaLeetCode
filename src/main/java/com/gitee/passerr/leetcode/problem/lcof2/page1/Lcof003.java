package com.gitee.passerr.leetcode.problem.lcof2.page1;

/**
 * 给定一个非负整数 n，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 * <p>
 * 示例 1:
 * 输入: n = 2
 * 输出: [0,1,1]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * <p>
 * 示例2:
 * 输入: n = 5
 * 输出: [0,1,1,2,1,2]
 * 解释:
 * 0 --> 0
 * 1 --> 1
 * 2 --> 10
 * 3 --> 11
 * 4 --> 100
 * 5 --> 101
 * <p>
 * 说明 :
 * 0 <= n <= 105
 * <p>
 * 进阶:
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的__builtin_popcount）来执行此操作。
 * @author xiehai
 * @date 2021/12/10 15:21
 */
public class Lcof003 {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // i & (i - 1) 将i的最低位的1置为0 result[对应数字]为高位所有的1的个数
            result[i] = result[i & (i - 1)] + 1;
        }

        return result;
    }
}
