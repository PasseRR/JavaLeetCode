package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0809}单元测试
 * @date 2020/07/31 13:23
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0809Spec extends Specification {
    Lcci0809 lcci0809 = new Lcci0809()

    @Unroll
    def "generateParenthesis(#n) == #result"() {
        expect:
        result == this.lcci0809.generateParenthesis(n)

        where:
        n || result
        2 || ["(())", "()()"]
        3 || ["((()))", "(()())", "(())()", "()(())", "()()()"]
    }
}