package com.gitee.passerr.leetcode.problem.lcci.page2

import spock.lang.Specification

/**
 * {@link Lcci1010}单元测试
 * @date 2020/08/10 14:53
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Lcci1010Spec extends Specification {
    Lcci1010 lcci1010 = new Lcci1010()

    def "StreamRank"() {
        given:
        StreamRank streamRank = new StreamRank()

        when:
        streamRank.track(4)
        streamRank.track(3)
        streamRank.track(5)
        then:
        streamRank.getRankOfNumber(8) == 3
    }
}