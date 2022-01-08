package com.gitee.passerr.leetcode.problem.lcof2.page1

import com.gitee.passerr.leetcode.Node
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcof029}单元测试
 * @date 2022/01/07 15:33
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcof029Spec extends Specification {
    Lcof029 lcof029 = new Lcof029()

    @Unroll
    def "insert(#head, #insertVal) = #result"() {
        expect:
        result == this.lcof029.insert(head, insertVal)

        where:
        head | insertVal || result
        null | 1         || new Node(1)
    }
}
