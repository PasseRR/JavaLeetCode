package com.gitee.passerr.leetcode.problem.algorithm.page5

import spock.lang.Specification

/**
 * {@link Solution211}单元测试
 * @date 2021/07/13 11:08
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Solution211Spec extends Specification {
    def "WordDictionary"() {
        given:
        WordDictionary dictionary = new WordDictionary()

        when:
        dictionary.addWord("bad")
        dictionary.addWord("mad")
        dictionary.addWord("dad")

        then:
        !dictionary.search("pad")
        dictionary.search("dad")
        dictionary.search(".ad")
        dictionary.search("b..")
    }
}