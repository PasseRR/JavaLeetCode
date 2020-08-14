package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1603}单元测试
 * @date 2020/08/10 16:09
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1603Spec extends Specification {
    Lcci1603 lcci1603 = new Lcci1603()

    @Unroll
    def "intersection(#start1, #end1, #start2, #end2) = #result"() {
        expect:
        result == this.lcci1603.intersection(start1, end1, start2, end2)

        where:
        start1          | end1            | start2          | end2             | result
        //        [0, 0] as int[] | [1, 0] as int[]  | [1, 1] as int[]  | [0, -1] as int[] || [0.5, 0] as double[]
        //        [0, 0] as int[] | [2, 2] as int[]  | [2, 2] as int[]  | [3, 3] as int[]  || [2, 2] as double[]
        //        [0, 1] as int[] | [0, -1] as int[] | [-1, 1] as int[] | [1, 3] as int[]  || [] as double[]
        //        [0, 0] as int[] | [1, -1] as int[] | [0, 0] as int[]  | [-1, 1] as int[] || [0, 0] as double[]
        [0, 3] as int[] | [0, 6] as int[] | [0, 1] as int[] | [0, 5] as int[] || [0, 3] as double[]
    }
}