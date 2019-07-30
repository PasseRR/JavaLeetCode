package com.gitee.passerr.leetcode.problem.concurrency.page1

import spock.lang.Specification
import spock.lang.Unroll

import java.util.concurrent.TimeUnit

/**
 * {@link Solution1115}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/30 11:12
 * @author xiehai
 */
class Solution1115Spec extends Specification {
    Solution1115 solution1115 = new Solution1115()

    @Unroll
    def "execute(#n)"() {
        when:
        this.solution1115.execute(n)
        TimeUnit.SECONDS.sleep(2)
        then:
        notThrown(Exception)

        where:
        n || _
        1 || _
        2 || _
        3 || _
        4 || _
    }
}
