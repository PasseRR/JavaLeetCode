{% assign segments = page.path | split: '/' %}
{% assign directory = segments[-2] %}

{{ '../' | append: site.data.package[page.category][directory]  | append: page.markdown | file_content }}

### [题解]({{site.github | append: site.data.package[page.category][directory] | append: page.file}}){:target="_blank"}

```sql
{{ '../' | append: site.data.package[page.category][directory]  | append: page.file | file_content -}}
```
