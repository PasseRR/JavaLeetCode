---
title: 剑指 Offer 32 - III. 从上到下打印二叉树 III
tags: [树, 广度优先搜索, 二叉树]
---


## [题目](https://leetcode.cn/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/)
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。

例如:  

给定二叉树: `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

返回其层次遍历结果：

```
[
  [3],
  [20,9],
  [15,7]
]
```

**提示：**

1. `节点总数 <= 1000`


## [题解](https://github.com/PasseRR/JavaLeetCode/blob/master/src/main/java/com/gitee/passerr/leetcode/problem/lcof1/page1/Lcof32III.java)

<<< @/../src/main/java/com/gitee/passerr/leetcode/problem/lcof1/page1/Lcof32III.java#snippet
