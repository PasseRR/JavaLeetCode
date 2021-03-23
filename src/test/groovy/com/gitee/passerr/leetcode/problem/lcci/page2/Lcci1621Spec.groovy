package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1621}单元测试
 * @date 2021/03/23 11:37
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1621Spec extends Specification {
    Lcci1621 lcci1621 = new Lcci1621()

    @Unroll
    def "findSwapValues(#array1, #array2) = #result"() {
        expect:
        result == this.lcci1621.findSwapValues(array1, array2)

        where:
        array1                                                       | array2                                    || result
        [4, 1, 2, 1, 1, 2] as int[]                                  | [3, 6, 3, 3] as int[]                     || [4, 6] as int[]
        [1, 2, 3] as int[]                                           | [4, 5, 6] as int[]                        || [] as int[]
        [519, 886, 282, 382, 662, 4718, 258, 719, 494, 795] as int[] | [52, 20, 78, 50, 38, 96, 81, 20] as int[] || [4718, 78] as int[]
    }
}