package com.gitee.passerr.leetcode.problem.lcci.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1725}单元测试
 * @date 2021/07/09 17:02
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1725Spec extends Specification {
    Lcci1725 lcci1725 = new Lcci1725()

    @Unroll
    def "maxRectangle(#words) = #result"() {
        expect:
        Arrays.toString(result) == Arrays.toString(this.lcci1725.maxRectangle(words))

        where:
        words                                                  || result
        ["eat", "tea", "tan", "ate", "nat", "bat"] as String[] || ["eat", "ate", "tea"] as String[]
    }
}