package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1717}单元测试
 * @date 2021/05/28 11:10
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1717Spec extends Specification {
    Lcci1717 lcci1717 = new Lcci1717()

    @Unroll
    def "multiSearch(#big, #smalls) = #result"() {
        when:
        def r = this.lcci1717.multiSearch(big, smalls)
        then:
        r.length == result.length
        r.length.times {
            it
            Arrays.toString(r[it]) == Arrays.toString(result[it])
        }

        where:
        big           | smalls                                                || result
        ""            | [] as String[]                                        || [] as int[][]
        "mississippi" | ["is", "ppi", "hi", "sis", "i", "ssippi"] as String[] || [[1, 4], [8], [], [3], [1, 4, 7, 10], [5]] as int[][]
    }
}