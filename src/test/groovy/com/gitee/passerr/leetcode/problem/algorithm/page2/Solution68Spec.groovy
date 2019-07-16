package com.gitee.passerr.leetcode.problem.algorithm.page2

import spock.lang.Specification
import spock.lang.Unroll

/**
 * {@link Solution68}测试用例
 * @Copyright (c)tellyes tech. inc. co.,ltd
 * @date 2019/07/16 14:24
 * @author xiehai
 */
class Solution68Spec extends Specification {
    Solution68 solution68 = new Solution68()

    @Unroll
    def "fullJustify(#words, #maxWidth) = #result"() {
        expect:
        result == this.solution68.fullJustify(words, maxWidth)

        where:
        words         | maxWidth || result
        [
            "Listen", "to", "many,",
            "speak", "to", "a", "few."
        ] as String[] | 6        || [
            "Listen",
            "to    ",
            "many, ",
            "speak ",
            "to   a",
            "few.  "
        ]
        [
            "What", "must", "be",
            "acknowledgment",
            "shall", "be"
        ] as String[] | 16       || [
            "What   must   be",
            "acknowledgment  ",
            "shall be        "
        ]
        [
            "This", "is", "an",
            "example", "of", "text",
            "justification."
        ] as String[] | 16       || [
            "This    is    an",
            "example  of text",
            "justification.  "
        ]
        [
            "Science", "is", "what",
            "we", "understand",
            "well", "enough", "to",
            "explain", "to", "a",
            "computer.", "Art", "is",
            "everything", "else",
            "we", "do"
        ] as String[] | 20       || [
            "Science  is  what we",
            "understand      well",
            "enough to explain to",
            "a  computer.  Art is",
            "everything  else  we",
            "do                  "
        ]
    }
}
