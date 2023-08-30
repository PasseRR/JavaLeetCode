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
class CategorySpec extends Specification {
    def static base = Paths.get(GeneratorSpec.getResource("/").toURI()).getParent().getParent()
    def static converter = FlexmarkHtmlConverter.builder().build()
    def static categories = [
        "lcci" : new Category(prefix: "Lcci", filter: [listId: "xb9lfcwi"], handler: { it -> it.replaceAll("面试题 ", "").replaceAll("\\.", "") }),
        "lcof1": new Category(prefix: "Lcof", filter: [listId: "xb9nqhhg"]),
        "lcof2": new Category(prefix: "Lcof", filter: ["orderBy": "FRONTEND_ID", "searchKeywords": "LCR ", "sortOrder": "ASCENDING"])
    ]

    static class Category {
        String prefix
        def filter
        Closure<String> handler

        def convert(String questionFrontendId) {
            this.handler(questionFrontendId)
        }
    }

    static generate(String category, int page) {
        def type = categories.get(category)
        Sidebar navbar = new Sidebar(page, category)
        LeetCodeProblemUtil.page(page, "", type.filter).each { it ->
            def detail = LeetCodeProblemUtil.detail(it.titleSlug)
            def filename = type.convert(detail.questionFrontendId)
            def path = base.resolve("src/main/java/com/gitee/passerr/leetcode/problem/${category}/page${page}/${type.prefix}${filename}.java")
            if (!Files.exists(path)) {
                return
            }
            def ls = Files.readAllLines(path)
            def exist = ls.findIndexOf { l -> l.endsWith("// #region snippet") }
            if (exist < 0) {
                def begin = ls.findIndexOf { l -> l.startsWith("public class ") }
                def begin2 = ls.findIndexOf { l -> l.startsWith("class ") }
                if (begin2 >= 0) {
                    ls.add(begin2, "// #region snippet")
                    ls.add(ls.size(), "// #endregion snippet")
                } else {
                    ls.add(begin + 1, "    // #region snippet")
                    ls.add(ls.size() - 1, "    // #endregion snippet")
                }
                path.toFile().withWriter { writer ->
                    ls.each { l -> writer.write(l + "\n") }
                }
            }

            def dir = base.resolve("${category}/page${page}")
            if (!Files.exists(dir)) {
                Files.createDirectories(dir)
            }
            dir.resolve("${filename}.md").toFile().withWriter { writer ->
                writer.write("# ${detail.questionFrontendId}. ${detail.translatedTitle}\n")
                writer.write("\n")
                writer.write("## [题目](https://leetcode.cn/problems/${it.titleSlug}/)\n")
                writer.write(converter.convert(detail.translatedContent as String) + "\n")
                writer.write("\n")
                writer.write("## [题解](https://github.com/PasseRR/JavaLeetCode/blob/master/src/main/java/com/gitee/passerr/leetcode/problem/${category}/page${page}/${type.prefix}${filename}.java)\n")
                writer.write("\n")
                writer.write("<<< @/src/main/java/com/gitee/passerr/leetcode/problem/${category}/page${page}/${type.prefix}${filename}.java#snippet\n")
                writer.write("")
            }

            navbar.addItem("${detail.questionFrontendId}. ${detail.translatedTitle}", filename)
        }

        println navbar.toString()
    }

    static void main(String[] args) {
        generate("lcci", 3)
    }
}
