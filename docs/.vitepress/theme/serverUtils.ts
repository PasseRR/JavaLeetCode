// @ts-ignore
import matter from 'gray-matter'
// @ts-ignore
import fs from 'fs'

function getPosts() {
    const posts = [], rewrites = {}
    // 遍历博客目录
    const walk = path => {
        fs.readdirSync(path, 'utf-8').forEach((it) => {
            const item = path + it
            if (fs.statSync(item).isDirectory()) {
                walk(item + '/')
            } else if (item.endsWith(".md")) {
                const rewritePath = item.split("/").filter(p => p !== 'docs' && p.indexOf("page") < 0).join("/")
                if (item.indexOf('page') >= 0 && item.indexOf('docs') >= 0) {
                    rewrites[item.substring(5)] = rewritePath
                }
                const content = fs.readFileSync(item, 'utf-8')
                const {data} = matter(content)

                posts.push({
                    frontMatter: data,
                    // 访问路径
                    regularPath: `/${rewritePath.replace('.md', '')}`
                })
            }
        })
    }

    walk("docs/")

    posts.sort((a, b) => a.frontMatter.date < b.frontMatter.date ? 1 : -1)

    return {
        posts: posts,
        rewrites: rewrites,
    }
}

export {getPosts}
