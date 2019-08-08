package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.problem.algorithm.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution143}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/08 16:08
 * @author xiehai
 */
class Solution143Spec extends Specification {
    Solution143 solution143 = new Solution143()

    @Unroll
    def "reorderList(#head) = #result"() {
        when:
        this.solution143.reorderList(head)
        then:
        result == head

        where:
        head                          || result
        ListNode.of(1, 2, 3, 4)       || ListNode.of(1, 4, 2, 3)
        ListNode.of(1, 2, 3, 4, 5)    || ListNode.of(1, 5, 2, 4, 3)
        ListNode.of(1, 2, 3, 4, 5, 6) || ListNode.of(1, 6, 2, 5, 3, 4)
    }
}
