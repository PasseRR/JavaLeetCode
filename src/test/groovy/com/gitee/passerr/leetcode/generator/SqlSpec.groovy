package com.gitee.passerr.leetcode.generator

import com.gitee.passerr.leetcode.LeetCodeProblemUtil
import com.gitee.passerr.leetcode.Sidebar
import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Paths

/**
 * vite页面生成
 * @date 2023/08/29 17:58
 * @author xiehai
 */
class SqlSpec extends Specification {
    def static base = Paths.get(GeneratorSpec.getResource("/").toURI()).getParent().getParent()

    def "sql generate"() {

    }

    static generate(String category, int page) {
        Sidebar navbar = new Sidebar(page, category)
        Files.list(base.resolve("src/main/java/com/gitee/passerr/leetcode/problem/${category}/page${page}"))
            .sorted { a, b ->
                def na = a.getFileName().toString(), nb = b.getFileName().toString()
                return Integer.compare(Integer.parseInt(na.substring(0, na.lastIndexOf("."))), Integer.parseInt(nb.substring(0, nb.lastIndexOf("."))))
            }
            .filter { it -> it.fileName.toString().endsWith(".md") }
            .forEach { it ->
                def lines = Files.readAllLines(it)
                def first = lines.get(0)
                def handled = false
                if (first.startsWith("# ")) {
                    first = lines.get(1)
                    handled = true
                }
                def end = first.lastIndexOf("/)"), start = first.indexOf("problems/") + 9
                def code
                if (end > 0) {
                    code = first.substring(start, end)
                } else {
                    code = first.substring(start, first.lastIndexOf(")"))
                }
                def detail = LeetCodeProblemUtil.detail(code)
                if (!handled) {
                    (lines[0] = first.substring(1))
                    lines.add(0, "# ${detail.questionFrontendId}. ${detail.translatedTitle}")
                    it.toFile().withWriter { writer ->
                        lines.each { line -> writer.write(line + "\n") }
                    }
                }

                def resolve = base.resolve("${category}/page${page}")
                if (!Files.exists(resolve)) {
                    Files.createDirectories(resolve)
                }

                resolve.resolve(it.getFileName()).toFile().withWriter { writer ->
                    lines.each { line -> writer.write(line + "\n") }
                    writer.write("\n")
                    writer.write("## [题解](https://github.com/PasseRR/JavaLeetCode/blob/master/src/main/java/com/gitee/passerr/leetcode/problem/${category}/page${page}/${detail.questionFrontendId}.sql)\n")
                    writer.write("\n")
                    writer.write("<<< @/../src/main/java/com/gitee/passerr/leetcode/problem/${category}/page${page}/${detail.questionFrontendId}.sql#snippet\n")
                    writer.write("")
                }

                navbar.addItem("${detail.questionFrontendId}. ${detail.translatedTitle}", detail.questionFrontendId)
            }

        println navbar.toString()
    }

    static void main(String[] args) {
        generate("database", 5)
    }
}
