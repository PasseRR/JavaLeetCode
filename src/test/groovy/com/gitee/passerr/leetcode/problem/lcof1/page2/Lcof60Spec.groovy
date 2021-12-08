package com.gitee.passerr.leetcode.problem.lcof1.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof60}单元测试
 * @date 2020/07/22 09:09
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof60Spec extends Specification {
    Lcof60 lcof60 = new Lcof60()

    @Unroll
    def "twoSum(#n) = #result"() {
        expect:
        result == this.lcof60.twoSum(n)

        where:
        n || result
        1 || [
            0.16666666666666666, 0.16666666666666666, 0.16666666666666666,
            0.16666666666666666, 0.16666666666666666, 0.16666666666666666
        ] as double[]
    }
}