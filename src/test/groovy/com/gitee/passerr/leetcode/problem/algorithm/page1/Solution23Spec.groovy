package com.gitee.passerr.leetcode.problem.algorithm.page1


import com.gitee.passerr.leetcode.problem.algorithm.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution23}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/03 17:23
 * @author xiehai
 */
class Solution23Spec extends Specification {
    Solution23 solution23 = new Solution23()

    @Unroll
    def "mergeKLists(#input) = #result"() {
        expect:
        result == this.solution23.mergeKLists(input)

        where:
        input                                                                         || result
        [] as ListNode[]                                                              || null
        [null, null] as ListNode[]                                                    || null
        [ListNode.of(1, 2, 2), ListNode.of(1, 1, 2)] as ListNode[]                    || ListNode.of(1, 1, 1, 2, 2, 2)
        [ListNode.of(1, 4, 5), ListNode.of(1, 3, 4), ListNode.of(2, 6)] as ListNode[] || ListNode.of(1, 1, 2, 3, 4,
                                                                                                     4, 5, 6)
    }
}
