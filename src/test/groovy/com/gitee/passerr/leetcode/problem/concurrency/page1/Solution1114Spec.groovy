package com.gitee.passerr.leetcode.problem.concurrency.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution1114}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/15 11:07
 * @author xiehai
 */
class Solution1114Spec extends Specification {
    Solution1114 solution1114 = new Solution1114()

    @Unroll
    def "execute(#nums)"() {
        when:
        this.solution1114.execute(nums)
        then:
        notThrown(Exception)

        where:
        nums                  || _
        [1, 3, 2] as int[]    || _
        [1, 2, 3] as int[]    || _
        [1, 1, 2, 3] as int[] || _
    }
}
