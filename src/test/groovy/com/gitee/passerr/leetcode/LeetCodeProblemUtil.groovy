package com.gitee.passerr.leetcode

import groovyx.net.http.ContentType
import groovyx.net.http.HTTPBuilder
import groovyx.net.http.Method
import org.apache.groovy.json.internal.LazyMap

/**
 * leetcode md文档自动生成
 * @date 2023/08/15 13:32
 * @author xiehai
 */
class LeetCodeProblemUtil {
    def static http = new HTTPBuilder("https://leetcode.cn/graphql/")

    static page(int pageNumber = 1, String categorySlug = "algorithms", int limit = 50) {
        def query = """
            query problemsetQuestionList(\$categorySlug: String, \$limit: Int, \$skip: Int, \$filters: QuestionListFilterInput){
                problemsetQuestionList(categorySlug: \$categorySlug, limit: \$limit, skip: \$skip, filters: \$filters) {
                    questions {
                        titleCn
                        titleSlug
                    }
                }
            }
        """

        // frontendQuestionId titleSlug
        request([
            query        : query,
            variables    : [categorySlug: categorySlug, limit: limit, skip: (pageNumber - 1) * limit, filters: [:]],
            operationName: "problemsetQuestionList"
        ]).problemsetQuestionList?.questions ?: []
    }

    static detail(String slug) {
        def query = """
        query questionTranslations(\$titleSlug: String!) {
            question(titleSlug: \$titleSlug) {
                translatedTitle
                translatedContent
                questionId
            }
        }
        """


        request([query: query, variables: [titleSlug: slug], operationName: "questionTranslations"]).question ?: [:]
    }

    private static LazyMap request(def payload) {
        http.request(Method.POST, ContentType.JSON) {
            body = payload

            response.success = { resp, json ->
                return json.data
            }

            response.failure = { resp ->
                println "leetcode graphql出错"
                return [:]
            }
        } as LazyMap
    }
}
