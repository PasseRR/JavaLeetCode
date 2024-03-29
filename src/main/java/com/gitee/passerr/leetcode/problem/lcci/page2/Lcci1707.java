package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。
 * 有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。给定两个列表，一个是名字及对应的频率，
 * 另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。
 * 注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
 * 在结果列表中，选择 字典序最小 的名字作为真实名字。
 * <p>
 * 示例：
 * 输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"],
 * synonyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
 * 输出：["John(27)","Chris(36)"]
 * <p>
 * 提示：
 * names.length <= 100000
 * @author xiehai
 * @date 2021/04/30 16:36
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1707 {
    // #region snippet
    /**
     * 并查集
     */
    static class UnionFindSet {
        /**
         * key为名字 value为父节点
         */
        Map<String, String> node = new HashMap<>(8);
        /**
         * key为名字 value为名字出现次数
         */
        Map<String, Integer> cnt = new HashMap<>(8);

        void init(String name, int cnt) {
            this.node.put(name, name);
            this.cnt.put(name, cnt);
        }

        void init(String name) {
            this.init(name, 0);
        }

        String find(String name) {
            String parent = this.node.get(name);
            if (Objects.equals(name, parent)) {
                return name;
            } else {
                String ancestor = this.find(parent);
                // 路径压缩
                this.node.put(name, ancestor);

                return ancestor;
            }
        }

        void union(String x, String y) {
            // 初始化不在名字列表中的数据
            if (!node.containsKey(x)) {
                this.init(x);
            }
            if (!node.containsKey(y)) {
                this.init(y);
            }

            String parentX = this.find(x), parentY = this.find(y);
            if (!Objects.equals(parentX, parentY)) {
                // 字典排序
                if (parentX.compareTo(parentY) > 0) {
                    node.put(parentX, parentY);
                    // 名字出现次数累加
                    cnt.merge(parentY, cnt.get(parentX), Integer::sum);
                } else {
                    node.put(parentY, parentX);
                    cnt.merge(parentX, cnt.get(parentY), Integer::sum);
                }
            }
        }

        String[] result() {
            return
                node.entrySet()
                    .stream()
                    // 过滤根节点
                    .filter(it -> Objects.equals(it.getKey(), it.getValue()))
                    .map(it -> String.format("%s(%d)", it.getKey(), cnt.get(it.getKey())))
                    .toArray(String[]::new);
        }
    }

    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        UnionFindSet set = new UnionFindSet();
        for (String name : names) {
            String[] split = name.substring(0, name.length() - 1).split("\\(", 2);
            // 并查集初始化
            set.init(split[0], Integer.parseInt(split[1]));
        }

        for (String synonym : synonyms) {
            String[] split = synonym.substring(1, synonym.length() - 1).split(",", 2);
            // 合并
            set.union(split[0], split[1]);
        }

        // 过滤并查集中根节点 并格式化结果
        return set.result();
    }
    // #endregion snippet
}
