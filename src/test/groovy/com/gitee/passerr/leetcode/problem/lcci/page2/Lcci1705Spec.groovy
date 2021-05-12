package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1705}单元测试
 * @date 2021/04/29 15:23
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1705Spec extends Specification {
    Lcci1705 lcci1705 = new Lcci1705()

    @Unroll
    def "findLongestSubarray(#array) = #result"() {
        expect:
        result == this.lcci1705.findLongestSubarray(array)

        where:
        array                  || result
        [
            "A", "1", "B", "C", "D", "2", "3", "4", "E", "5",
            "F", "G", "6", "7", "H", "I", "J", "K", "L", "M"
        ] as String[]          || ["A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F", "G", "6", "7"] as String[]
        ["A", "A"] as String[] || [] as String[]
        ["A", "A", "1"] as String[] || ["A", "1"] as String[]

    }
}