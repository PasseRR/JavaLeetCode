package com.gitee.passerr.leetcode.problem.lcof.page1;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * <p>
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *  
 * 提示:
 * 0 < nums.length <= 100
 * <p>
 * 说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * @author xiehai
 * @date 2020/07/14 13:06
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcof45 {
    public String minNumber(int[] nums) {
        return
            Arrays.stream(nums)
                .mapToObj(String::valueOf)
                // 字符串比较排序 若长度一致 则按照大小比较
                // 若长度不一致 比较两个数字拼接后的大小
                .sorted((s1, s2) -> s1.length() == s2.length() ? s1.compareTo(s2) : (s1 + s2).compareTo(s2 + s1))
                .collect(Collectors.joining());
    }
}
