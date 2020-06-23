package com.gitee.passerr.leetcode.problem.lcci.page1

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci0502}单元测试
 * @date 2020/06/23 09:33
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci0502Spec extends Specification {
    Lcci0502 lcci0502 = new Lcci0502()

    @Unroll
    def "printBin(#num) == #result"() {
        expect:
        result == this.lcci0502.printBin(num)

        where:
        num   || result
        0.625 || "0.101"
        0.1   || "ERROR"
    }
}