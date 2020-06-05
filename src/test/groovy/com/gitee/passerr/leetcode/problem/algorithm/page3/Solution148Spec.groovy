package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution148}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/07 17:52
 * @author xiehai
 */
class Solution148Spec extends Specification {
    Solution148 solution148 = new Solution148()

    @Unroll
    def "sortList(#head) = #result"() {
        expect:
        result == this.solution148.sortList(head)

        where:
        head                        || result
        ListNode.of(4, 2, 1, 3)     || ListNode.of(1, 2, 3, 4)
        ListNode.of(-1, 5, 3, 4, 0) || ListNode.of(-1, 0, 3, 4, 5)
    }
}
