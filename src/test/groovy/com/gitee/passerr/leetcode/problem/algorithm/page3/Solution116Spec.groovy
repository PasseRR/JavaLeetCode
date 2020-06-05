package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.Node
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution116}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/31 17:57
 * @author xiehai
 */
class Solution116Spec extends Specification {
    Solution116 solution116 = new Solution116()

    @Unroll
    def "connect(#root) = #result"() {
        expect:
        result == this.solution116.connect(root)

        where:
        root                                        || result
        new Node(1, new Node(2), new Node(3), null) || new Node(
            1,
            new Node(2, null, null, new Node(3)),
            new Node(3),
            null
        )
    }
}
