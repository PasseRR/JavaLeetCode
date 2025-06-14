import {defineConfig} from 'vitepress'
import {navs, sidebars, site} from './main';
import sup_plugin from "markdown-it-sup";
import sub_plugin from "markdown-it-sub";
import MiniSearch from 'minisearch'
import Segment from 'segment'
import {getPosts} from './theme/serverUtils'

// @ts-ignore
const segment = new Segment().useDefault()

const {posts, rewrites} = getPosts()

export default defineConfig({
    title: site.title,
    description: site.description,
    lastUpdated: true,
    base: site.base,
    srcExclude: ['**/README.md', ...site.excludes],
    rewrites: rewrites,
    vite: {
        publicDir: '.vitepress/public'
    },
    head: [
        // google分析脚本
        [
            'script',
            {async: '', src: `https://www.googletagmanager.com/gtag/js?id=${site.google}`}
        ],
        // vercel分析脚本
        [
            'script',
            {defer: '', src: 'https://vercel.com/_vercel/insights/script.js'}
        ],
        // google、百度统计分析
        [
            'script',
            {},
            `var isProductEnv = window && window.location && window.location.host
                && window.location.host.indexOf('127.0.0.1') === -1
                && window.location.host.indexOf('localhost') === -1
                && window.location.host.indexOf('192.168.') === -1;
             if(isProductEnv) {
                window.dataLayer = window.dataLayer || [];
                function gtag(){dataLayer.push(arguments);}
                gtag('js', new Date());
                gtag('config', '${site.google}');
                
                var _hmt = _hmt || [];
                (function () {
                    var hm = document.createElement("script");
                    hm.src = "https://hm.baidu.com/hm.js?${site.baidu}";
                    var s = document.getElementsByTagName("script")[0];
                    s.parentNode.insertBefore(hm, s);
                })();
                _hmt.push(['_setAccount', '${site.baidu}']);
                _hmt.push(['_trackPageview', window.location]);
                _hmt.push(['_setAutoPageview', true]);
                
                window.va = window.va || function () { (window.vaq = window.vaq || []).push(arguments); };
             }`
        ]
    ],
    sitemap: {
        hostname: site.main,
        lastmodDateOnly: false,
        // @ts-ignore
        transformItems(items) {
            return items.map(it => {
                it.lastmodrealtime = true;
                it.url = site.base + `/${it.url}`;

                return it;
            });
        }
    },
    themeConfig: {
        // @ts-ignore
        posts: posts,
        nav: navs(),
        sidebar: sidebars(),
        search: {
            provider: 'local',
            options: {
                miniSearch: {
                    options: {
                        tokenize: (text, fieldName) => {
                            // 默认的简单分词
                            let origin = MiniSearch.getDefault('tokenize')(text, fieldName);

                            // 仅对标题中文分词
                            if (fieldName.indexOf('title') >= 0) {
                                return segment.doSegment(text, {simple: true, stripPunctuation: true}).concat(origin);
                            }

                            return origin
                        }
                    },
                    searchOptions: {
                        // 仅以空白字符
                        tokenize: (string) => string.split(/\s+/),
                        fuzzy: 0.4
                    }
                },
                _render(src, env, md) {
                    const html = md.render(src, env)

                    if (env.frontmatter?.title)
                        return md.render(`# ${env.frontmatter.title}`) + html
                    return html
                },
            }
        },
        lastUpdated: {
            text: '最后更新'
        },
        editLink: {
            pattern: `https://github.com/PasseRR/${site.repository}/edit/${site.branch || 'main'}/docs/:path`,
            text: 'Edit this page on GitHub'
        },
        logo: site.logo,
        outline: {
            level: "deep",
            label: '目录'
        },
        sidebarMenuLabel: '菜单',
        returnToTopLabel: '回到顶部',
        externalLinkIcon: true,
        socialLinks: [{
            icon: {
                svg: `<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="48px" height="48px" viewBox="0 0 48 48" enable-background="new 0 0 48 48" xml:space="preserve">  <image id="image0" width="48" height="48" x="0" y="0"
    xlink:href="data:image/png;base64,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
OjAwz6MktwAAAABJRU5ErkJggg==" />
</svg>`
            },
            link: site.main
        }, {
            icon: {
                svg: '<svg role="img" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><title>LeetCode</title><path d="M13.483 0a1.374 1.374 0 0 0-.961.438L7.116 6.226l-3.854 4.126a5.266 5.266 0 0 0-1.209 2.104 5.35 5.35 0 0 0-.125.513 5.527 5.527 0 0 0 .062 2.362 5.83 5.83 0 0 0 .349 1.017 5.938 5.938 0 0 0 1.271 1.818l4.277 4.193.039.038c2.248 2.165 5.852 2.133 8.063-.074l2.396-2.392c.54-.54.54-1.414.003-1.955a1.378 1.378 0 0 0-1.951-.003l-2.396 2.392a3.021 3.021 0 0 1-4.205.038l-.02-.019-4.276-4.193c-.652-.64-.972-1.469-.948-2.263a2.68 2.68 0 0 1 .066-.523 2.545 2.545 0 0 1 .619-1.164L9.13 8.114c1.058-1.134 3.204-1.27 4.43-.278l3.501 2.831c.593.48 1.461.387 1.94-.207a1.384 1.384 0 0 0-.207-1.943l-3.5-2.831c-.8-.647-1.766-1.045-2.774-1.202l2.015-2.158A1.384 1.384 0 0 0 13.483 0zm-2.866 12.815a1.38 1.38 0 0 0-1.38 1.382 1.38 1.38 0 0 0 1.38 1.382H20.79a1.38 1.38 0 0 0 1.38-1.382 1.38 1.38 0 0 0-1.38-1.382z"/></svg>'
            },
            link: "https://leetcode.cn/u/passerr/",
            ariaLabel: "LeetCode"
        }]
    },
    markdown: {
        lineNumbers: true,
        theme: {
            light: 'github-light',
            dark: 'github-dark'
        },
        config: md => {
            md.use(sup_plugin);
            md.use(sub_plugin);
        }
    }
});
