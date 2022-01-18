package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification

/**
 * {@link Lcof048}单元测试
 * @date 2022/01/17 15:11
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof048Spec extends Specification {
    Lcof048 lcof048 = new Lcof048()

    def "Codec"() {
        expect:
        root == new Codec().deserialize(new Codec().serialize(root))

        where:
        root || _
        null || _
    }
}
