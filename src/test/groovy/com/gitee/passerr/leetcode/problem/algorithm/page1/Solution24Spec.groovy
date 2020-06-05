package com.gitee.passerr.leetcode.problem.algorithm.page1


import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution24}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/04 10:41
 * @author xiehai
 */
class Solution24Spec extends Specification {
    Solution24 solution24 = new Solution24()

    @Unroll
    def "swapPairs(#input) = #result"() {
        expect:
        result == this.solution24.swapPairs(input)

        where:
        input                   || result
        ListNode.of(1, 2, 3, 4) || ListNode.of(2, 1, 4, 3)
        ListNode.of(1, 2, 3)    || ListNode.of(2, 1, 3)
        ListNode.of(1)          || ListNode.of(1)
    }
}
