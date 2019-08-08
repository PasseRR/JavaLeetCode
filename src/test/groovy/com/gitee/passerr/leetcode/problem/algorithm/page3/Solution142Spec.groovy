package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.problem.algorithm.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution142}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/08/08 17:37
 * @author xiehai
 */
class Solution142Spec extends Specification {
    Solution142 solution142 = new Solution142()

    @Unroll
    def "detectCycle(#head) = #result"() {
        expect:
        result == this.solution142.detectCycle(head)

        where:
        head                 || result
        ListNode.of(1, 2, 3) || null
    }
}
