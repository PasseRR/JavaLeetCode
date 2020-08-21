package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification

/**
 * {@link Lcci1609}单元测试
 * @date 2020/08/21 09:48
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1609Spec extends Specification {
    def "Operations"() {
        given:
        Operations operations = new Operations()

        expect:
        operations.minus(0, -2147483647) == 2147483647
        operations.minus(-1, 2147483647) == -2147483648
        operations.multiply(-1, -2147483647) == 2147483647
        operations.multiply(-100, 21474836) == -2147483600
        operations.divide(2147483647, -1) == -2147483647
        operations.divide(-2147483648, 1) == -2147483648
    }
}