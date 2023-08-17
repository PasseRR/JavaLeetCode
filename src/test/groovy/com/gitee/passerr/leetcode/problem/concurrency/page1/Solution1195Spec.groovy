package com.gitee.passerr.leetcode.problem.concurrency.page1

import spock.lang.Specification
import spock.lang.Unroll

import java.util.concurrent.TimeUnit

/**
 * {@link Solution1195}单元测试
 * @date 2023/08/17 16:59
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Solution1195Spec extends Specification {
    Solution1195 solution1195 = new Solution1195()

    @Unroll
    def "FizzBuzz(#n)"() {
        when:
        this.solution1195.execute(n)
        TimeUnit.SECONDS.sleep(1)
        then:
        notThrown(Exception.class)

        where:
        n  || _
        15 || _
        20 || _
        30 || _
    }
}
