package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification

/**
 * {@link Lcci1625}单元测试
 * @date 2021/04/19 11:15
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1625Spec extends Specification {
    def "LRU Cache"() {
        given:
        def cache = new LRUCache(2)

        when:
        cache.put(1, 1)
        cache.put(2, 2)
        then:
        cache.get(1) == 1

        when:
        cache.put(3, 3)
        then:
        cache.get(2) == -1

        when:
        cache.put(4, 4)
        then:
        cache.get(1) == -1
        cache.get(3) == 3
        cache.get(4) == 4
    }
}