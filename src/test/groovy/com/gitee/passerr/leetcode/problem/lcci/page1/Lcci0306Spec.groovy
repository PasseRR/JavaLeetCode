package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification

/**
 * {@link Lcci0306}单元测试
 * @date 2020/06/06 12:52
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0306Spec extends Specification {
    def "animal shelf"() {
        given:
        def shelf = new AnimalShelf()

        when:
        shelf.enqueue([0, 0] as int[])
        shelf.enqueue([1, 0] as int[])
        then:
        shelf.dequeueCat() == [0, 0] as int[]
        shelf.dequeueDog() == [-1, -1] as int[]
        shelf.dequeueAny() == [1, 0] as int[]
    }
}