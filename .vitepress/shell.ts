function bars() {
    return [{
        text: 'Shell',
        base: 'shell',
        link: '/index'
    }];
}

function nav() {
    return {
        text: 'Shell',
        link: '/shell/index',
        activeMatch: '/shell/'
    };
}

export default {bars, nav}
