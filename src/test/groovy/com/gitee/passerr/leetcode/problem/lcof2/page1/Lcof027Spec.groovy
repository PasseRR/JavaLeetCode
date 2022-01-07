package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof027}单元测试
 * @date 2022/01/07 13:36
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof027Spec extends Specification {
    Lcof027 lcof027 = new Lcof027()

    @Unroll
    def "isPalindrome(#head) = #result"() {
        expect:
        result == this.lcof027.isPalindrome(head)

        where:
        head                 || result
        ListNode.of(1, 2, 1) || true
        ListNode.of(1)       || true
        ListNode.of(1, 2)    || false
    }
}
