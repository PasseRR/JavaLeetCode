import shell from "./shell";
import database from "./database";
import algorithm from "./algorithm";
import lcci from "./lcci";
import lcof1 from "./lcof1";
import lcof2 from "./lcof2";
import concurrency from "./concurrency";

const site = {
    logo: '/icon.svg',
    // 标题
    title: 'Java版LeetCode',
    // 描述
    description: 'Java解题LeetCode',
    // github仓库
    repository: 'JavaLeetCode',
    // 主分支
    branch: 'master',
    // 基础路径
    base: '/JavaLeetCode',
    // google 分析
    google: 'G-1L1DPX3PFD',
    // 百度统计
    baidu: '1746b6c08f1b61947aa3939bd3b2365c',
    // 排除文件
    excludes: ["src/**/*.md"]
}

function sidebars() {
    return {
        "/shell": {
            base: '/shell',
            items: shell.bars()
        },
        "/database": {
            base: "/database",
            items: database.bars()
        },
        "/lcci": {
            base: "/lcci",
            items: lcci.bars()
        },
        "lcof1": {
            base: "/lcof1",
            items: lcof1.bars()
        },
        "lcof2": {
            base: "/lcof2",
            items: lcof2.bars()
        },
        "/concurrency": {
            base: "/concurrency",
            items: concurrency.bars()
        },
        "/algorithm": {
            base: "/algorithm",
            items: algorithm.bars()
        }
    };
}

function navs() {
    return [database.nav(), lcof1.nav(), lcof2.nav(), lcci.nav(), concurrency.nav(), algorithm.nav()];
}

export {site, sidebars, navs};
