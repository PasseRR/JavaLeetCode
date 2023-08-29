import shell from "./shell";
import database from "./database";

const site = {
    logo: '',
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
    excludes: []
}

function sidebars() {
    return [...shell(), ...database()];
}

export {site, sidebars};
