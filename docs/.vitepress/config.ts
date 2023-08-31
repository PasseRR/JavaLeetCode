import {defineConfig} from 'vitepress'
import {navs, sidebars, site} from './main';
import sup_plugin from "markdown-it-sup";
import sub_plugin from "markdown-it-sub";

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
        nav: navs(),
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
        sidebarMenuLabel: '菜单',
        returnToTopLabel: '回到顶部',
        externalLinkIcon: true,
        socialLinks: [{
            icon: {
                svg: `<svg viewBox="0 0 120 120" fill="none" xmlns="http://www.w3.org/2000/svg">
    <path d="M68.4876 75.8086C70.7358 73.5637 74.375 73.5696 76.616 75.8217C78.857 78.0738 78.8511 81.7194 76.6029 83.9642L66.6199 93.9326C57.4098 103.129 42.3911 103.263 33.0256 94.2424C32.9715 94.1905 28.8012 90.1015 15.044 76.6115C5.89166 67.6374 4.97987 53.2774 13.5925 44.0559L29.6506 26.8617C38.1985 17.7086 53.9552 16.7082 63.7285 24.6118L78.3131 36.4069C80.783 38.4043 81.1688 42.0294 79.1748 44.5036C77.1808 46.9778 73.5621 47.3642 71.0922 45.3667L56.5077 33.5717C51.3965 29.4383 42.4555 30.006 38.0451 34.7287L21.9867 51.9232C17.7939 56.4124 18.2531 63.6445 23.085 68.3823C33.1872 78.2883 40.9729 85.9224 40.9819 85.931C45.8509 90.6207 53.7239 90.5508 58.5045 85.777L68.4876 75.8086Z"
          fill="#B3B3B3"></path>
    <path fill-rule="evenodd" clip-rule="evenodd"
          d="M44.2359 65.8329C41.0616 65.8329 38.4883 63.2551 38.4883 60.0752C38.4883 56.8954 41.0616 54.3176 44.2359 54.3176H86.6247C89.799 54.3176 92.3723 56.8954 92.3723 60.0752C92.3723 63.2551 89.799 65.8329 86.6247 65.8329H44.2359Z"
          fill="#B3B3B3"></path>
    <path fill-rule="evenodd" clip-rule="evenodd"
          d="M52.1745 2.74414C54.3432 0.422038 57.9804 0.300713 60.2984 2.47315C62.6165 4.64558 62.7376 8.28912 60.5689 10.6112L21.9869 51.9233C17.7939 56.4122 18.2531 63.6443 23.0847 68.3823L40.9025 85.8543C43.1709 88.0787 43.2097 91.724 40.9892 93.9964C38.7687 96.2688 35.1297 96.3077 32.8613 94.0833L15.0435 76.6112C5.89165 67.6366 4.97986 53.2768 13.5929 44.0559L52.1745 2.74414Z"
          fill="#B3B3B3"></path>
</svg>`
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