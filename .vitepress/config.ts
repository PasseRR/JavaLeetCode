import {defineConfig} from 'vitepress'
import {sidebars, site} from './main';

export default defineConfig({
    title: site.title,
    description: site.description,
    lastUpdated: true,
    base: site.base,
    srcExclude: ['**/README.md', ...site.excludes],
    head: [
        // google分析脚本
        [
            'script',
            {async: '', src: `https://www.googletagmanager.com/gtag/js?id=${site.google}`}
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
             }`
        ]
    ],
    sitemap: {
        hostname: "https://www.xiehai.zone",
        lastmodDateOnly: false,
        // @ts-ignore
        transformItems(items) {
            // @ts-ignore
            return items.map(it => it.url = `${site.base}/${it.url}`);
        }
    },
    themeConfig: {
        nav: null,
        sidebar: sidebars(),
        search: {
            provider: 'local'
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
        langMenuLabel: '菜单',
        returnToTopLabel: '回到顶部',
        externalLinkIcon: true
    },
    markdown: {
        lineNumbers: true,
        theme: {
            light: 'github-light',
            dark: 'github-dark'
        }
    }
});