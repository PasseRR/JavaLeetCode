package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification

/**
 * {@link Lcof030}单元测试
 * @date 2022/01/07 16:32
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof030Spec extends Specification {
    def "randomizedSet"() {
        given:
        RandomizedSet set
        when:
        set = new RandomizedSet()
        then:
        set.insert(0)
        set.insert(1)
        set.remove(0)
        set.insert(2)
        set.remove(1)
        set.getRandom() == 2

        when:
        set = new RandomizedSet()
        then:
        set.insert(1)
        !set.remove(2)
        set.insert(2)
        set.getRandom() > 0
        set.remove(1)
        !set.insert(2)
        set.getRandom() > 0
    }
}
