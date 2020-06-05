package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0206}单元测试
 * @date 2020/06/05 16:47
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0206Spec extends Specification {
    Lcci0206 lcci0206 = new Lcci0206()

    @Unroll
    def "isPalindrome(#head) = #result"() {
        expect:
        result == this.lcci0206.isPalindrome(head)

        where:
        head                    || result
        ListNode.of(1, 2, 1)    || true
        ListNode.of(1, 2, 3)    || false
        ListNode.of(1, 2, 2, 1) || true
    }
}