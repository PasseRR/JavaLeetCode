package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0810}单元测试
 * @date 2020/07/31 13:25
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0810Spec extends Specification {
    Lcci0810 lcci0810 = new Lcci0810()

    @Unroll
    def "floodFill(#image, #sr, #sc, #newColor) = #result"() {
        expect:
        result == this.lcci0810.floodFill(image, sr, sc, newColor)

        where:
        image                                        | sr | sc | newColor || result
        [[1, 1, 1], [1, 1, 0], [1, 0, 1]] as int[][] | 1  | 1  | 2        || [[2, 2, 2], [2, 2, 0], [2, 0, 1]] as int[][]
    }
}