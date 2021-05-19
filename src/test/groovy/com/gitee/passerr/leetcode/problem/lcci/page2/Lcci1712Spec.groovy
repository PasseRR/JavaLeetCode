package com.gitee.passerr.leetcode.problem.lcci.page2

import com.gitee.passerr.leetcode.TreeNode
import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1712}单元测试
 * @date 2021/05/18 13:37
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1712Spec extends Specification {
    Lcci1712 lcci1712 = new Lcci1712()

    @Unroll
    def "convertBiNode(#root) = #result"() {
        expect:
        result == this.lcci1712.convertBiNode(root)

        where:
        root || result
        new TreeNode(
            4,
            new TreeNode(2, new TreeNode(1, new TreeNode(0), null),
                new TreeNode(3)), new TreeNode(5, null, new TreeNode(6))
        )    || new TreeNode(
            0,
            null,
            new TreeNode(
                1,
                null,
                new TreeNode(
                    2,
                    null,
                    new TreeNode(
                        3,
                        null,
                        new TreeNode(
                            4,
                            null,
                            new TreeNode(
                                5,
                                null,
                                new TreeNode(6)
                            )
                        )
                    )
                )
            )
        )
    }
}