package com.gitee.passerr.leetcode.problem.lcci.page3

import spock.lang.Specification

/**
 * {@link Lcci1720}单元测试
 * @date 2021/06/11 11:48
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1720Spec extends Specification {
    MedianFinder finder

    void setup() {
        finder = new MedianFinder()
    }

    def "MedianFinder"() {
        when:
        finder.addNum(2)
        then:
        finder.findMedian() == 2

        when:
        finder.addNum(3)
        then:
        finder.findMedian() == 2.5D

        when:
        finder.addNum(1)
        then:
        finder.findMedian() == 2
    }
}