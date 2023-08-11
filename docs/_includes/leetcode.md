{% assign segments = page.path | split: '/' %}
{% assign module = page.category %}

{% if module == "database" %}
    {% assign language = "sql" %}
{% elsif module == "shell" %}
    {% assign language = "bash" %}
{% else %}
    {% assign language = "java" %}
{% endif %}

{% assign directory = segments[-2] %}
{% assign base = "src/main/java/com/gitee/passerr/leetcode/problem" | append: '/' | append: module | append: '/' | append: directory | append: "/" %}

{{ '../' | append: base | append: page.markdown | file_content }}

### [题解]({{site.github | append: base | append: page.file}}){:target="_blank"}

```{{language}}
{{ '../' | append: base | append: page.file | file_content: page.start, page.end, page.skip -}}
```
