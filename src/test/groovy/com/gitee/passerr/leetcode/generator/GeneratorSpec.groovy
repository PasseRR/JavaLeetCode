package com.gitee.passerr.leetcode.generator

import com.gitee.passerr.leetcode.LeetCodeProblemUtil
import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate
import java.time.format.DateTimeFormatter

/**
 * 用于markdown文档生成
 * @date 2023/08/15 17:15
 * @author xiehai
 */
class GeneratorSpec extends Specification {
    def static base = Paths.get(GeneratorSpec.getResource("/").toURI()).getParent().getParent()

    def "单个问题文档生成"() {
        given:
        def code = "two-sum"
        when:
        this.writeDocument(code)
        then:
        notThrown(Exception)
    }

    def "整页生成"() {
        given:
        def page = 3
        // 起始问题
        def start = ""
        when:
        LeetCodeProblemUtil.page(page).each { it ->
            this.writeDocument(it.titleSlug, page)
        }

        then:
        notThrown(Exception)
    }

    def writeDocument(String code, int page) {
        def detail = LeetCodeProblemUtil.detail(code)
        def sourceName = "Solution${detail.questionId}"
        def source = base.resolve("src/main/java/com/gitee/passerr/leetcode/problem/algorithm/page${page}")
        def doc = source.resolve("${sourceName}.md")
        if (!Files.exists(doc)) {
            Files.createFile(doc)
        }
        // 问题文档
        doc.toFile().withWriter { writer ->
            writer.write("### [题目](https://leetcode.cn/problems/${code}/){:target=\"_blank\"}")
            writer.write("\n")
            writer.write("\n")
            writer.write("${detail.translatedContent}")
        }

        def java = source.resolve("${sourceName}.java")
        // 如果不存在题解 不写blog
        if (!Files.exists(java)) {
            return
        }

        int row = 2
        String line
        java.toFile().withReader { reader ->
            while (!(line = reader.readLine()).contains("{") || line.trim().startsWith("*")) {
                row++
            }
        }

        // 问题文章
        def chapter = base.resolve("_chapters/6.algorithm/page${page}").resolve("${detail.questionId}.md")
        if (!Files.exists(chapter)) {
            Files.createFile(chapter)
        }
        chapter.toFile().withWriter { writer ->
            writer.write("""---
title: ${detail.questionId}. ${detail.translatedTitle}
layout: post
category: algorithm
pk: 6.${page}
order: ${detail.questionId}
file: ${sourceName}.java
markdown: ${sourceName}.md
start: ${row}
end: -1
skip: 4
last_modified_at: ${LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))}
---

{% include leetcode.md %}""")
        }
    }
}
