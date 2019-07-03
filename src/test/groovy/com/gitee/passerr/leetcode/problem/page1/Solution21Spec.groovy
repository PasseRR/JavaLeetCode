package com.gitee.passerr.leetcode.problem.page1

import com.gitee.passerr.leetcode.problem.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution21}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/03 15:14
 * @author xiehai
 */
class Solution21Spec extends Specification {
    Solution21 solution21 = new Solution21()

    @Unroll
    def "mergeTwoLists(#l1, #l2) = #result"() {
        expect:
        result == this.solution21.mergeTwoLists(l1, l2)

        where:
        l1                   | l2                   || result
        ListNode.of(1, 2, 4) | ListNode.of(1, 3, 4) || ListNode.of(1, 1, 2, 3, 4, 4)
    }
}
