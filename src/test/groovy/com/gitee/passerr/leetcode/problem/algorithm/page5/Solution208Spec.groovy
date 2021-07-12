package com.gitee.passerr.leetcode.problem.algorithm.page5

import spock.lang.Specification

/**
 * {@link Solution208}单元测试
 * @date 2021/07/12 17:40
 * @Copyright (c) wisewe co.,ltd
 * @author xiehai
 */
class Solution208Spec extends Specification {
    def "Trie"() {
        given:
        Trie trie = new Trie()

        when:
        trie.insert("apple")
        then:
        trie.search("apple")
        !trie.search("app")
        trie.startsWith("app")

        when:
        trie.insert("app")
        then:
        trie.search("app")
    }
}