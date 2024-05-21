package com.gitee.passerr.leetcode.generator

import com.gitee.passerr.leetcode.LeetCodeProblemUtil

import java.nio.file.Paths

/**
 * 自动追加tag
 * @date 2024/05/21 15:10
 * @author xiehai
 */
class TagSpec {
    def static base = Paths.get(TagSpec.getResource("/").toURI()).getParent().getParent()
    def static prefix = "## [题目](https://leetcode.cn/problems/"

    static void appendTag(File file) {
        def lines = file.readLines()
        def line = lines.find { it -> it.startsWith(prefix) }
        if (line) {
            def title = lines[0].substring(2)
            def slug = line.substring(prefix.length(), line.length() - (line.endsWith("/)") ? 2 : 1))
            file.text = """---
title: ${title}
tags: ${LeetCodeProblemUtil.tag(slug)}
---

""" + lines.subList(1, lines.size()).join("\n") + "\n"
        }
    }

    static main(agrs) {
        base.resolve("docs/algorithm").toFile().listFiles().each { it ->
            if (it.isFile()) {
                appendTag(it)
            } else {
                it.listFiles().each { c -> appendTag(c) }
            }
        }
    }
}
