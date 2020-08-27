package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;

/**
 * 给定一个二维平面及平面上的 N 个点列表Points，其中第i个点的坐标为Points[i]=[Xi,Yi]。请找出一条直线，其通过的点的数目最多。
 * 设穿过最多点的直线所穿过的全部点编号从小到大排序的列表为S，你仅需返回[S[0],S[1]]作为答案，若有多条直线穿过了相同数量的点，
 * 则选择S[0]值较小的直线返回，S[0]相同则选择S[1]值较小的直线返回。
 * <p>
 * 示例：
 * 输入： [[0,0],[1,1],[1,0],[2,0]]
 * 输出： [0,2]
 * 解释： 所求直线穿过的3个点的编号为[0,2,3]
 * <p>
 * 提示：
 * 2 <= len(Points) <= 300
 * len(Points[i]) = 2
 * @author xiehai
 * @date 2020/08/26 11:50
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1614 {
    public int[] bestLine(int[][] points) {
        // 第1、2位为索引 第3位为经过点的数量
        Map<String, int[]> lines = new HashMap<>(8);
        // 最大公约数
        BiFunction<Integer, Integer, Integer> gcd = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return b == 0 ? a : this.apply(b, a % b);
            }
        };
        // 直线公式 A*x + B*y + C = 0 返回 A、B、C list
        BiFunction<int[], int[], String> line = (p1, p2) -> {
            int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1];
            int x0 = x2 - x1, y0 = y2 - y1;
            int a = y0, b = -x0, c = x0 * y1 - y0 * x1;
            // 若A、B、C存在公约数
            int g = gcd.apply(gcd.apply(a, b), c);
            a /= g;
            b /= g;
            c /= g;
            // 生成方程式的key
            return String.format("%d_%d_%d", a, b, c);
        };
        // 缓存最大
        AtomicReference<int[]> max = new AtomicReference<>(new int[]{0, 1, 2});
        for (int i = 1; i < points.length; i++) {
            // 从小到大 保证第一次出现的为小索引到大索引
            for (int j = 0; j < i; j++) {
                lines.merge(line.apply(points[i], points[j]), new int[]{j, i, 2}, (o, n) -> {
                    // 若已存在一条直线 则累加点数量
                    o[2]++;
                    // 存数量最多 索引位置较小的
                    if (o[2] > max.get()[2] || (o[2] == max.get()[2] && o[0] < max.get()[0])) {
                        max.set(o);
                    }
                    return o;
                });
            }
        }

        return Arrays.copyOfRange(max.get(), 0, 2);
    }
}
