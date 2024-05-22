import DefaultTheme from 'vitepress/theme'
import NewLayout from "./components/NewLayout.vue"
import Tags from "./components/Tags.vue"
import './custom.css'
import 'font-awesome/css/font-awesome.min.css'

export default {
    extends: DefaultTheme,
    Layout: NewLayout,
    enhanceApp({app}) {
        app.component('Tags', Tags)
    },
}
