package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Lcci1713}单元测试
 * @date 2021/05/19 16:02
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1713Spec extends Specification {
    Lcci1713 lcci1713 = new Lcci1713()

    @Unroll
    def "respace(#dictionary, #sentence) = #result"() {
        expect:
        result == this.lcci1713.respace(dictionary, sentence)

        where:
        dictionary                                               | sentence                          || result
//        ["looked", "just", "like", "her", "brother"] as String[] | "jesslookedjustliketimherbrother" || 7
        ["dodrjo","ez"] as String[] || "dodrjoejeojqzzdezeodjjrjzj" | 18
    }
}