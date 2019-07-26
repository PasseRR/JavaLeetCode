package com.gitee.passerr.leetcode.problem.algorithm.page3

import spock.lang.Specification
/**
 * {@link Solution146}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/26 14:33
 * @author xiehai
 */
class Solution146Spec extends Specification {
    Solution146 solution146 = new Solution146()

    def "lru cache"() {
        given:
        LRUCache cache = new LRUCache(2)
        when:
        cache.put(1, 1)
        cache.put(2, 2)
        then:
        cache.get(1) == 1

        when:
        cache.put(3, 3)
        println cache
        then:
        cache.get(2) == -1
    }
}
