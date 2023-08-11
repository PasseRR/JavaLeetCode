{% assign segments = page.path | split: '/' %}
{% assign module = page.category %}
{% assign directory = segments[-2] %}
{% assign base = "src/main/java/com/gitee/passerr/leetcode/problem" | append: '/' | append: module | append: '/' | append: directory | append: "/" %}

{{ '../' | append: base | append: page.markdown | file_content }}

### [题解]({{site.github | append: site.data.package[page.category][directory] | append: page.file}}){:target="_blank"}

```sql
{{ '../' | append: base | append: page.file | file_content: page.start, page.end, page.skip -}}
```
