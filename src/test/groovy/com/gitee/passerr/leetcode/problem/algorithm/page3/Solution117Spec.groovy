package com.gitee.passerr.leetcode.problem.algorithm.page3

import com.gitee.passerr.leetcode.problem.algorithm.Node
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution117}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/31 18:43
 * @author xiehai
 */
class Solution117Spec extends Specification {
    Solution117 solution117 = new Solution117()

    @Unroll
    def "connect(#root) = #result"() {
        when:
        this.solution117.connect(root)
        then:
        result == root

        where:
        root || result
        new Node(
            1,
            new Node(
                2,
                new Node(3, new Node(4), null, null),
                new Node(5),
                null
            ),
            new Node(
                3,
                new Node(6, null, new Node(8), null),
                null,
                null
            ),
            null
        )    || new Node(
            1,
            new Node(
                2,
                new Node(
                    3,
                    new Node(4, null, null, new Node(8)),
                    null,
                    new Node(5, null, null, new Node(6, null, new Node(8), null))
                ),
                new Node(5, null, null, new Node(6, null, new Node(8), null)),
                new Node(3, new Node(6, null, new Node(8), null), null, null)
            ),
            new Node(
                3,
                new Node(6, null, new Node(8), null),
                null,
                null
            ),
            null
        )
        new Node(
            1,
            new Node(2, new Node(4), new Node(5), null),
            new Node(3, null, new Node(7), null),
            null
        )    || new Node(
            1,
            new Node(2,
                     new Node(4, null, null, new Node(5, null, null, new Node(7))),
                     new Node(5, null, null, new Node(7)),
                     new Node(3, null, new Node(7), null)
            ),
            new Node(3, null, new Node(7), null),
            null
        )
    }
}
