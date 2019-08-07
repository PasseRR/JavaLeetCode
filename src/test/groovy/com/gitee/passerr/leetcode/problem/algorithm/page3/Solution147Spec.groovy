package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.problem.algorithm.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution147}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/07 09:23
 * @author xiehai
 */
class Solution147Spec extends Specification {
    Solution147 solution147 = new Solution147()

    @Unroll
    def "insertionSortList(#head) = #result"() {
        expect:
        result == this.solution147.insertionSortList(head)

        where:
        head                        || result
        ListNode.of(4, 2, 1, 3)     || ListNode.of(1, 2, 3, 4)
        ListNode.of(-1, 5, 3, 4, 0) || ListNode.of(-1, 0, 3, 4, 5)
    }
}
