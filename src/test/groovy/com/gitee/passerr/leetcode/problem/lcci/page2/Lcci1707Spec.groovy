package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1707}单元测试
 * @date 2021/05/06 13:40
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1707Spec extends Specification {
    Lcci1707 lcci1707 = new Lcci1707()

    @Unroll
    def "trulyMostPopular(#names, #synonyms) = #result"() {
        expect:
        result == this.lcci1707.trulyMostPopular(names, synonyms)

        where:
        names         | synonyms || result
        [
            "John(15)", "Jon(12)", "Chris(13)",
            "Kris(4)", "Christopher(19)"
        ] as String[] | [
            "(Jon,John)", "(John,Johnny)", "(Chris,Kris)",
            "(Chris,Christopher)"
        ] as String[]            || ["John(27)", "Chris(36)"] as String[]
    }
}