package com.gitee.passerr.leetcode.problem.lcof2.page1

import spock.lang.Specification 
/**
 * {@link Lcof031}单元测试
 * @date 2022/01/10 09:51
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof031Spec extends Specification {
    Lcof031 lcof031 = new Lcof031()
    def "lru"() {
        given:
        LRUCache cache = new LRUCache(2)
        when:
        cache.put(1, 1)
        cache.put(2, 2)
        then:
        cache.get(1) == 1

        when:
        cache.put(3, 3)
        then:
        cache.get(2) == -1
        cache.size() == 2
    }
}
