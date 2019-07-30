package com.gitee.passerr.leetcode.problem.concurrency.page1


import spock.lang.Specification
import spock.lang.Unroll

import java.util.concurrent.TimeUnit

/**
 * {@link Solution1117}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/30 13:39
 * @author xiehai
 */
class Solution1117Spec extends Specification {
    Solution1117 solution1117 = new Solution1117()

    @Unroll
    def "execute(#s)"() {
        when:
        this.solution1117.execute(s)
        TimeUnit.SECONDS.sleep(2)
        then:
        notThrown(Exception)

        where:
        s              || _
        "HOH"          || _
        "OOHHHH"       || _
        "OOHHHHOOHHHH" || _
    }
}
