package com.gitee.passerr.leetcode

/**
 * @date 2023/08/29 19:07
 * @author xiehai
 */
class Sidebar {
    String text
    Boolean collapsed
    String base
    String link
    List<Sidebar> items = []
    String[] number = ['一', '二', '三', '四', '五', '六', '七', '八', '九', '十']

    private Sidebar() {

    }

    Sidebar(int page, String category, String link = null) {
        this.text = "第${this.number[page - 1]}页"
        this.collapsed = true
        this.base = "/${category}/page${page}"
        this.link = link
    }

    void addItem(String text, String id) {
        this.items.add(new Sidebar(text: text, link: "/${id}"))
    }

    @Override
    String toString() {
        StringBuilder sb = new StringBuilder()
        sb.append("{\n")
            .append("text: '${this.text}',\n")
            .append("base: '${this.base}',\n")
        if (Objects.nonNull(this.link)) {
            sb.append("link: '${this.link}',\n")
        }
        if (Objects.nonNull(this.collapsed)) {
            sb.append("collapsed: ${this.collapsed},\n")
        }
        sb.append("items: [\n")
        int len = items.size() - 1
        items.eachWithIndex { it, idx ->
            sb.append("{text: '${it.text}', link: '${it.link}'}")
            if (idx < len) {
                sb.append(",\n")
            }
        }
        sb.append("\n]\n").append("}")

        return sb.toString()
    }
}
