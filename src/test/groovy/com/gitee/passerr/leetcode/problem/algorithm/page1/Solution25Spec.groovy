package com.gitee.passerr.leetcode.problem.algorithm.page1


import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution25}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/04 12:31
 * @author xiehai
 */
class Solution25Spec extends Specification {
    Solution25 solution25 = new Solution25()

    @Unroll
    def "reverseKGroup(#list, #k) = #result"() {
        expect:
        result == this.solution25.reverseKGroup(list, k)

        where:
        list                       | k || result
        ListNode.of(1, 2, 3, 4, 5) | 1 || ListNode.of(1, 2, 3, 4, 5)
        ListNode.of(1, 2, 3, 4, 5) | 2 || ListNode.of(2, 1, 4, 3, 5)
        ListNode.of(1, 2, 3, 4, 5) | 3 || ListNode.of(3, 2, 1, 4, 5)
    }
}
