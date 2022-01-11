package com.gitee.passerr.leetcode.problem.lcof2.page1;

import java.util.Stack;
import java.util.function.Consumer;

/**
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 * <p>
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。
 * 每一颗小行星以相同的速度移动。
 * <p>
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。
 * 两颗移动方向相同的行星，永远不会发生碰撞。
 * <p>
 * 示例 1：
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * <p>
 * 示例 2：
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * <p>
 * 示例 3：
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 * <p>
 * 示例 4：
 * 输入：asteroids = [-2,-1,1,2]
 * 输出：[-2,-1,1,2]
 * 解释：-2 和 -1 向左移动，而 1 和 2 向右移动。 由于移动方向相同的行星不会发生碰撞，所以最终没有行星发生碰撞。
 * <p>
 * 提示：
 * 2 <= asteroids.length <= 10<sup>4</sup>
 * -1000 <= asteroids[i] <= 1000
 * asteroids[i] != 0
 * <p>
 * 注意：本题与主站 735题相同：https://leetcode-cn.com/problems/asteroid-collision/
 * @author xiehai
 * @date 2022/01/11 09:47
 */
public class Lcof037 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        Consumer<Integer> collision = new Consumer<Integer>() {
            @Override
            public void accept(Integer asteroid) {
                if (stack.isEmpty()) {
                    stack.push(asteroid);
                    return;
                }

                // 栈顶行星
                int top = stack.peek();

                if (top * asteroid > 0 || top < 0) {
                    // 方向一致或者方向不一致或栈顶行星向左移动
                    // 则两颗行星不会碰撞
                    stack.push(asteroid);
                } else if (top + asteroid < 0) {
                    // 说明栈顶行星向右移动
                    // asteroid向左且asteroid比栈顶大
                    stack.pop();
                    // 递归左侧行星
                    this.accept(asteroid);
                } else if (top + asteroid == 0) {
                    // 大小一致 两颗行星爆炸
                    stack.pop();
                }

                // 还有一种情况 栈顶元素比asteroid大 发生碰撞 结果为asteroid爆炸
                // 栈不变
            }
        };

        for (int asteroid : asteroids) {
            collision.accept(asteroid);
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
