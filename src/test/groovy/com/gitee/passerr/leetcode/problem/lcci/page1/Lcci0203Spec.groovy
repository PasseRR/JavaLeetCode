package com.gitee.passerr.leetcode.problem.lcci.page1

import com.gitee.passerr.leetcode.ListNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0203}单元测试
 * @date 2020/06/05 16:38
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0203Spec extends Specification {
    Lcci0203 lcci0203 = new Lcci0203()

    @Unroll
    def "deleteNode(#node)"() {
        when:
        this.lcci0203.deleteNode(node)
        then:
        node == result

        where:
        node                 || result
        ListNode.of(1, 2, 3) || ListNode.of(2, 3)
    }
}