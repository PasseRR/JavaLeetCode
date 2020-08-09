package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1002}单元测试
 * @date 2020/08/07 18:01
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1002Spec extends Specification {
    Lcci1002 lcci1002 = new Lcci1002()

    @Unroll
    def "groupAnagrams(#strs) = #result"() {
        expect:
        result == this.lcci1002.groupAnagrams(strs)

        where:
        strs                                                   || result
        ["eat", "tea", "tan", "ate", "nat", "bat"] as String[] || [["eat", "tea", "ate"], ["bat"], ["tan", "nat"]]
    }
}