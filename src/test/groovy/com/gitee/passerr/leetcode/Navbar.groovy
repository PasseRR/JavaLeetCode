package com.gitee.passerr.leetcode

/**
 * @date 2023/08/29 19:07
 * @author xiehai
 */
class Navbar {
    String text
    Boolean collapsed
    String base
    String link
    List<Navbar> items = []
    String[] number = ['一', '二', '三', '四', '五', '六', '七', '八', '九', '十']

    private Navbar() {

    }

    Navbar(int page, String category) {
        this.text = "第${this.number[page - 1]}页"
        this.collapsed = false
        this.base = "/${category}/page${page}"
        this.link = "/index"
    }

    void addItem(String text, String id) {
        this.items.add(new Navbar(text: text, link: "/${id}"))
    }

    @Override
    String toString() {
        StringBuilder sb = new StringBuilder()
        sb.append("{\n")
            .append("text: '${this.text}',\n")
            .append("base: '${this.base}',\n")
            .append("link: '${this.link}',\n")
        if (this.collapsed) {
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
