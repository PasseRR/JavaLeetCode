package com.gitee.passerr.leetcode.problem.concurrency.page1

import spock.lang.Specification
import spock.lang.Unroll

import java.util.concurrent.TimeUnit

/**
 * {@link Solution1116}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/30 11:35
 * @author xiehai
 */
class Solution1116Spec extends Specification {
    Solution1116 solution1116 = new Solution1116()

    @Unroll
    def "execute(#n)"() {
        when:
        this.solution1116.execute(n)
        TimeUnit.SECONDS.sleep(2)
        then:
        notThrown(Exception)

        where:
        n   || _
        200 || _
        1   || _
        2   || _
        3   || _
        4   || _
    }
}
