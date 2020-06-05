package com.gitee.passerr.leetcode.problem.algorithm.page2

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution61}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/16 09:31
 * @author xiehai
 */
class Solution61Spec extends Specification {
    Solution61 solution61 = new Solution61()

    @Unroll
    def "rotateRight(#head, #k) = #result"() {
        expect:
        result == this.solution61.rotateRight(head, k)
        where:
        head                       | k || result
        ListNode.of(1, 2, 3, 4, 5) | 2 || ListNode.of(4, 5, 1, 2, 3)
        ListNode.of(0, 1, 2)       | 4 || ListNode.of(2, 0, 1)
    }
}
