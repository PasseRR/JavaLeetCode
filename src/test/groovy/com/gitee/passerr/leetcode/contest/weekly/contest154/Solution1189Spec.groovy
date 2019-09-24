package com.gitee.passerr.leetcode.contest.weekly.contest154

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution1189}单元测试
 * @author xiehai1* @date 2019/09/24 21:03
 * @Copyright (c)gome inc Gome Co.,LTD
 */
class Solution1189Spec extends Specification {
    Solution1189 solution1189 = new Solution1189()

    @Unroll
    def "maxNumberOfBalloons(#text) = #result"() {
        expect:
        result == this.solution1189.maxNumberOfBalloons(text)

        where:
        text               || result
        "nlaebolko"        || 1
        "loonbalxballpoon" || 2
        "leetcode"         || 0
    }
}
