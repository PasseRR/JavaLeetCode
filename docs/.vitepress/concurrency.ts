function bars() {
    return [{
        text: '第一页',
        base: '/concurrency',
        collapsed: false,
        items: [
            {text: '1114. 按序打印', link: '/1114'},
            {text: '1115. 交替打印 FooBar', link: '/1115'},
            {text: '1116. 打印零与奇偶数', link: '/1116'},
            {text: '1117. H2O 生成', link: '/1117'},
            {text: '1195. 交替打印字符串', link: '/1195'},
            {text: '1226. 哲学家进餐', link: '/1226'}
        ]
    }];
}

function nav() {
    return {
        text: '多线程',
        link: '/concurrency/index',
        activeMatch: '/concurrency/'
    };
}

export default {bars, nav}
