
<template>
  <highcharts :options="chartOptions" :key="themeToggle(isDark, Highcharts)"/>
  <div class="tag-header">{{ selectTag }}</div>
  <a :href="withBase(article.regularPath)+'.html'" v-for="(article, index) in articles" :key="index"
     class="posts no-icon" target="_blank" rel="noreferrer">
    <div class="post-container">
      <div class="post-dot"></div>
      {{ article.frontMatter.title }}
    </div>
  </a>

  <div class="pager" v-if="total > pageSize" :key="selectTag">
    <PaginationRoot :total="total" :items-per-page="pageSize" :sibling-count="2" :show-edges="true"
                    :default-page="pageNumber" @update:page="pageUpdate">
      <PaginationList v-slot="{ items }" class="PaginationList">
        <template v-for="(page, index) in items">
          <PaginationListItem v-if="page.type === 'page'" :key="index" class="Button" :value="page.value">
            {{ page.value }}
          </PaginationListItem>
          <PaginationEllipsis v-else :key="page.type" :index="index" class="PaginationEllipsis">
            &#8230;
          </PaginationEllipsis>
        </template>
      </PaginationList>
    </PaginationRoot>
  </div>
</template>
<script lang="ts" setup>
import {computed, onMounted, ref} from "vue"
import {defineClientComponent, useData, withBase} from 'vitepress'
import Highcharts from 'highcharts'
import wordcloud from 'highcharts/modules/wordcloud'
import {PaginationEllipsis, PaginationList, PaginationListItem, PaginationRoot} from 'radix-vue'

const dark = {
  colors: [
    '#2b908f', '#90ee7e', '#f45b5b', '#7798BF', '#aaeeee', '#ff0066',
    '#eeaaee', '#55BF3B', '#DF5353', '#7798BF', '#aaeeee'
  ],
  chart: {
    backgroundColor: 'var(--vp-c-bg)'
  },
  tooltip: {
    backgroundColor: 'rgba(0, 0, 0, 0.7)',
    style: {
      color: 'var(--vp-c-text-1)'
    }
  }
}, light = {
  colors: [
    '#67B9EE', '#CEEDA5', '#9F6AE1', '#FEA26E', '#6BA48F', '#EA3535',
    '#8D96B7', '#ECCA15', '#20AA09', '#E0C3E4'
  ],
  chart: {
    backgroundColor: 'var(--vp-c-bg)'
  },
  tooltip: {
    backgroundColor: 'rgba(255, 255, 255, 0.8)',
    style: {
      color: 'var(--vp-c-text-1)'
    }
  }
};

const {theme, isDark} = useData()
const data = computed(() => {
  const data: any = {}
  for (let index = 0; index < theme.value.posts.length; index++) {
    const element = theme.value.posts[index]
    const tags = element.frontMatter.tags
    if (tags) {
      tags.forEach((item) => {
        if (data[item]) {
          data[item].push(element)
        } else {
          data[item] = []
          data[item].push(element)
        }
      })
    }
  }
  return data
})
const keys = Object.keys(data.value);

const selectTag = ref(''), pageNumber = ref(1), total = ref(0), articles = ref(), pageSize = 10

// 标签切换
const toggleTag = (tag: string, page: Number) => {
      selectTag.value = tag
      pageNumber.value = page
      total.value = data.value[selectTag.value].length
      articles.value = data.value[selectTag.value].slice((page - 1) * pageSize, page * pageSize)
    },
    // 客户端组件引用
    highcharts = defineClientComponent(() => {
      // 词云引入
      wordcloud(Highcharts)
      return import('highcharts-vue').then(it => it.Chart)
    }),
    // 主题切换
    themeToggle = (isDark, charts) => {
      if (typeof charts === 'object') {
        charts.setOptions(isDark ? dark : light)
      }

      return isDark ? 'dark' : 'light';
    }

// 页面更新
const pageUpdate = (num) => toggleTag(selectTag.value, num)

const chartOptions = computed(() => {
  return {
    series: [{
      type: 'wordcloud',
      rotation: {
        from: 0,
        to: 60,
        orientations: 25
      },
      data: keys.map(it => {
        let len = data.value[it].length
        return {
          name: it,
          weight: len + 5,
          total: len
        }
      }),
      events: {
        click: (e) => toggleTag(e.point.options.name, 1)
      },
      tooltip: {
        headerFormat: '',
        pointFormat: '<span style="color:{point.color}">●</span> {point.name}: <b>{point.total}</b><br/>'
      },
      minFontSize: 3,
      maxFontSize: 30
    }],
    // 隐藏highcharts.com链接
    credits: {
      enabled: false
    },
    title: {
      text: ''
    },
    accessibility: {
      enabled: false,
    }
  }
})

onMounted(() => {
  let url = location.href.split('?')[1]
  let params = new URLSearchParams(url)
  let tag = params.get('tag'), page = params.get('page')

  tag && toggleTag(tag, parseInt(page) || 1)
})

</script>

<style scoped>
@media screen and (max-width: 768px) {
  .date {
    font-size: 0.75rem;
  }
}

.posts {
  font-weight: 500;
  color: var(--vp-c-text-1);
  text-decoration: none;
}

.posts:hover, .posts:active {
  color: var(--vp-c-brand-1);
  text-decoration: underline;
}

/*mobile*/
@media screen and (max-width: 768px) {
  .VPDoc {
    padding-top: 10px !important;
    padding-bottom: 20px !important;
  }

  .vp-doc h1 {
    font-size: 1.25rem !important;
  }

  .posts {
    padding: 4px;
  }

  .post-dot {
    margin-right: 4px;
  }

  .post-container {
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
    width: 16.5em;
  }
}

/* for aside end */
/* theme reset end */

/*tags and archives page style*/
.posts {
  padding: 4px 0 4px 25px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.post-dot {
  display: inline-block;
  margin-right: 10px;
  margin-bottom: 3px;
  width: 4px;
  height: 4px;
  border-radius: 50%;
  background-color: var(--li-dot-color);
}

.post-container {
  color: var(--vp-c-text-1);
  font-size: 0.9375rem;
  font-weight: 400;
}

.post-container:hover {
  color: var(--vp-c-brand);
}

/* 分页器相关 */
.pager button {
  all: unset;
}

.pager .Button {
  text-align: center;
  font-size: 15px;
  line-height: 1;
  align-items: center;
  justify-content: center;
  height: 2.25rem;
  width: 2.25rem;
  border-radius: 0.25rem;
  transition: all 150ms cubic-bezier(0.4, 0, 0.2, 1);
  cursor: pointer;
  color: var(--vp-c-text-1);
}

.pager .Button:disabled {
  opacity: .5
}

.pager .Button:not([disabled]):hover {
  background-color: var(--vp-c-brand-soft);
}

.pager .Button[data-selected] {
  background-color: var(--vp-custom-block-tip-bg);
  color: var(--vp-c-text-1);
}

.PaginationEllipsis {
  display: flex;
  height: 2.25rem;
  width: 2.25rem;
  align-items: center;
  justify-content: center;
  color: var(--vp-c-text-1);;
}

.PaginationList {
  display: flex;
  align-items: center;
  gap: 0.25rem;
  color: var(--vp-c-text-1);
}
</style>
