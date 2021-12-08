package com.gitee.passerr.leetcode.problem.lcof1.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof41}单元测试
 * @date 2020/07/14 12:59
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof41Spec extends Specification {
    @Unroll
    def "MedianFinder"() {
        given:
        MedianFinder finder = new MedianFinder()

        when:
        finder.addNum(1)
        finder.addNum(2)
        then:
        finder.findMedian() == 1.5D

        when:
        finder.addNum(3)
        then:
        finder.findMedian() == 2D
    }
}