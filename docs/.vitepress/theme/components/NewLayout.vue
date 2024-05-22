<template>
  <Layout>
    <template v-if="frontmatter.page !== true" #doc-before>
      <div class="vp-doc">
        <h1 :id="frontmatter.title">
          {{ frontmatter.title }}
          <a class="header-anchor" :href="'#'+frontmatter.title">​</a>
        </h1>
        <div class='post-info'>
          <a v-if="frontmatter.tags" v-for="item in frontmatter.tags" :href="withBase(`/tags.html?tag=${item}`)"
             target="_blank">
            <Badge type="tip"><span class="fa fa-tag"></span> {{ item }}</Badge>
          </a>
        </div>
      </div>
    </template>
  </Layout>
</template>
<script setup>
import DefaultTheme from 'vitepress/theme'
import {useData, withBase} from "vitepress"

const {Layout} = DefaultTheme
const {frontmatter} = useData()
</script>

<style>
.post-info {
  margin-top: 1em;
  float: right;
  font-size: .8em;
}
</style>
