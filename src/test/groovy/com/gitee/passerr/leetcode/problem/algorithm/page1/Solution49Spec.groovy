package com.gitee.passerr.leetcode.problem.algorithm.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution49}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/10 20:12
 * @author xiehai
 */
class Solution49Spec extends Specification {
    Solution49 solution49 = new Solution49()

    @Unroll
    def "groupAnagrams(#strs) = #result"() {
        expect:
        result == this.solution49.groupAnagrams(strs)

        where:
        strs                                                   || result
        ["eat", "tea", "tan", "ate", "nat", "bat"] as String[] || [["eat", "tea", "ate"], ["bat"], ["tan", "nat"]]
    }
}
