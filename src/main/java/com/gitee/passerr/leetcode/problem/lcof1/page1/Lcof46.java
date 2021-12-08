package com.gitee.passerr.leetcode.problem.lcof1.page1;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * 提示：
 * 0 <= num < 231
 * @author xiehai
 * @date 2020/07/14 13:09
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof46 {
    public int translateNum(int num) {
        // 数字码表
        Map<Integer, Character> cache =
            IntStream.range(0, 26)
                .boxed()
                .collect(Collectors.toMap(it -> it, it -> (char) (it + 97)));

        AtomicInteger result = new AtomicInteger();
        // 数字倒叙递归计算
        Consumer<Integer> recursion = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                // 0次数加一
                if (integer == 0) {
                    result.incrementAndGet();
                    return;
                }

                // 数字大于等于10 且十位非0
                if (integer >= 10 && (integer % 100 != integer % 10) && cache.containsKey(integer % 100)) {
                    this.accept(integer / 100);
                }

                // 直接按照个位转换
                this.accept(integer / 10);
            }
        };

        recursion.accept(num);

        return result.get();
    }
}
