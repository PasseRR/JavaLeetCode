package com.gitee.passerr.leetcode.problem.concurrency.page1

import spock.lang.Specification
import spock.lang.Unroll 
/**
 * {@link Solution1226}单元测试
 * @date 2023/08/18 11:07
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Solution1226Spec extends Specification {
    Solution1226 solution1226 = new Solution1226()

    @Unroll
    def "DiningPhilosophers(#n)"() {
        when:
        this.solution1226.execute(n)
        then:
        notThrown(Exception)

        where:
        n || _
        1 || _
        2 || _
    }
}
