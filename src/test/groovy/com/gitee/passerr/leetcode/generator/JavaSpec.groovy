package com.gitee.passerr.leetcode.generator

import com.gitee.passerr.leetcode.LeetCodeProblemUtil
import com.gitee.passerr.leetcode.Sidebar
import com.vladsch.flexmark.html2md.converter.FlexmarkHtmlConverter
import spock.lang.Specification

import java.nio.file.Files
import java.nio.file.Paths

/**
 * vite页面生成
 * @date 2023/08/29 17:58
 * @author xiehai
 */
class JavaSpec extends Specification {
    def static base = Paths.get(GeneratorSpec.getResource("/").toURI()).getParent().getParent()
    def static converter = FlexmarkHtmlConverter.builder()
        .build()

    static generate(String category, int page, String prefix = "Solution") {
        Sidebar navbar = new Sidebar(page, category)
        Files.list(base.resolve("src/main/java/com/gitee/passerr/leetcode/problem/${category}/page${page}"))
            .sorted { a, b ->
                def na = a.getFileName().toString(), nb = b.getFileName().toString()
                def from = prefix.length()
                return Integer.compare(Integer.parseInt(na.substring(from, na.lastIndexOf("."))), Integer.parseInt(nb.substring(from, nb.lastIndexOf("."))))
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
                    lines.add("\n")
                    it.toFile().withWriter { writer ->
                        lines.each { line -> writer.write(line + "\n") }
                    }
                }
                // java文件添加snippet
                def java = it.fileName.toString().replace(".md", ".java")
                def javaPath = it.getParent().resolve(java)
                if (!Files.exists(javaPath)) {
                    return 
                }
                def ls = Files.readAllLines(javaPath)
                def exist = ls.findIndexOf { l -> l.endsWith("// #region snippet") }
                if (exist < 0) {
                    def begin = ls.findIndexOf { l -> l.startsWith("public class ") }
                    def begin2 = ls.findLastIndexOf { l -> l.startsWith("class ") }
                    if (begin2 >= 0) {
                        begin = begin2
                    }
                    ls.add(begin + 1, "    // #region snippet")
                    ls.add(ls.size() - 1, "    // #endregion snippet")
                    javaPath.toFile().withWriter { writer ->
                        ls.each { l -> writer.write(l + "\n") }
                    }
                }

                def resolve = base.resolve("${category}/page${page}")
                if (!Files.exists(resolve)) {
                    Files.createDirectories(resolve)
                }

                resolve.resolve("${detail.questionFrontendId}.md").toFile().withWriter { writer ->
                    writer.write("# ${detail.questionFrontendId}. ${detail.translatedTitle}\n")
                    writer.write("\n")
                    writer.write("## [题目](https://leetcode.cn/problems/${code}/)\n")
                    writer.write(converter.convert(detail.translatedContent as String) + "\n")
                    writer.write("\n")
                    writer.write("## [题解](https://github.com/PasseRR/JavaLeetCode/blob/master/src/main/java/com/gitee/passerr/leetcode/problem/${category}/page${page}/${prefix}${detail.questionFrontendId}.java)\n")
                    writer.write("\n")
                    writer.write("<<< @/src/main/java/com/gitee/passerr/leetcode/problem/${category}/page${page}/${prefix}${detail.questionFrontendId}.java#snippet\n")
                    writer.write("")
                }

                navbar.addItem("${detail.questionFrontendId}. ${detail.translatedTitle}", detail.questionFrontendId)
            }

        println navbar.toString()
    }

    static void main(String[] args) {
        generate("algorithm", 3)
    }
}
