package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.Stack;

/**
 * 请根据每日 气温 列表 temperatures，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。
 * <p>
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出:[1,1,4,2,1,1,0,0]
 * <p>
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出:[1,1,1,0]
 * <p>
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * 提示：
 * 1 <=temperatures.length <= 10<sup>5</sup>
 * 30 <=temperatures[i]<= 100
 * <p>
 * 注意：本题与主站 739题相同：https://leetcode.cn/problems/daily-temperatures/
 * @author xiehai
 * @date 2022/01/11 16:39
 */
public class Lcof038 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 栈维护温度索引单调栈
        Stack<Integer> stack = new Stack<>();
        // 第一个温度索引
        stack.push(0);
        int len = temperatures.length, t;
        int[] result = new int[len];

        // 从第二个温度开始
        for (int i = 1; i < len; i++) {
            // 若当前温度大于栈顶温度 弹出栈顶温度 直到栈是一个单调递减栈
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                t = stack.pop();
                // 等待天数
                result[t] = i - t;
            }

            stack.push(i);
        }

        return result;
    }
}
