package com.gitee.passerr.leetcode.problem.lcof1.page1;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * <p>
 * 示例 2：
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * <p>
 * 提示：
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed 是 popped 的排列。
 * @author xiehai
 * @date 2020/07/04 16:03
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof31 {
    // #region snippet
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 辅助栈
        Stack<Integer> stack = new Stack<>();
        // 队列索引
        int index = 0;

        for (int value : pushed) {
            // 顺序入栈
            stack.push(value);

            // 若栈顶元素等于出栈队列元素 则依次出队这里是索引递增
            while (index < popped.length && !stack.isEmpty() && popped[index] == stack.peek()) {
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }
    // #endregion snippet
}
