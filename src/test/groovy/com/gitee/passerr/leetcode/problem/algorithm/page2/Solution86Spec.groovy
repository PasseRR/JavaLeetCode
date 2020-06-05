package com.gitee.passerr.leetcode.problem.algorithm.page2

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution86}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/22 16:35
 * @author xiehai
 */
class Solution86Spec extends Specification {
    Solution86 solution86 = new Solution86()

    @Unroll
    def "partition(#head, #x) = #result"() {
        expect:
        result == this.solution86.partition(head, x)

        where:
        head                          | x || result
        ListNode.of(1, 4, 3, 2, 5, 2) | 3 || ListNode.of(1, 2, 2, 4, 3, 5)
        ListNode.of(1, 4, 3, 2, 5, 2) | 0 || ListNode.of(1, 4, 3, 2, 5, 2)
        ListNode.of(1, 4, 3, 2, 5, 2) | 6 || ListNode.of(1, 4, 3, 2, 5, 2)
    }
}
