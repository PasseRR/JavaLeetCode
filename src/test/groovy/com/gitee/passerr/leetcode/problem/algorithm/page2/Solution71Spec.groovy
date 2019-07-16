package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution71}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/16 17:39
 * @author xiehai
 */
class Solution71Spec extends Specification {
    Solution71 solution71 = new Solution71()

    @Unroll
    def "simplifyPath(#path) = #result"() {
        expect:
        result == this.solution71.simplifyPath(path)

        where:
        path                    || result
        "/home/"                || "/home"
        "/../"                  || "/"
        "/home//foo/"           || "/home/foo"
        "/a/./b/../../c/"       || "/c"
        "/a/../../b/../c//.//"  || "/c"
        "/a//b////c/d//././/.." || "/a/b/c"
    }
}
