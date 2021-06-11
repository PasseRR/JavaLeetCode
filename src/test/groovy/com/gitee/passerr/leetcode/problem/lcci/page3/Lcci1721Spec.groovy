package com.gitee.passerr.leetcode.problem.lcci.page3

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1721}单元测试
 * @date 2021/06/11 14:09
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1721Spec extends Specification {
    Lcci1721 lcci1721 = new Lcci1721()

    @Unroll
    def "trap(#height) = #result"() {
        expect:
        result == this.lcci1721.trap(height)

        where:
        height                                        || result
        [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1] as int[] || 6
    }
}