package com.gitee.passerr.leetcode.problem.page1

import com.gitee.passerr.leetcode.problem.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution2}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/06/28 17:19
 * @author xiehai
 */
class Solution2Spec extends Specification {
    Solution2 solution2 = new Solution2()

    @Unroll
    def "addTwoNumbers(#node1, #node2) = #result"() {
        expect:
        result == this.solution2.addTwoNumbers(node1, node2)

        where:
        node1                   | node2                || result
        ListNode.of(2, 4, 3)    | ListNode.of(5, 6, 4) || ListNode.of(7, 0, 8)
        ListNode.of(5)          | ListNode.of(5)       || ListNode.of(0, 1)
        ListNode.of(3, 4, 5, 1) | ListNode.of(5, 4, 3) || ListNode.of(8, 8, 8, 1)
    }
}
