package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

/**
 * 给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
 * 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
 * <p>
 * 示例 1：
 * 输入：
 * line1 = {0, 0}, {1, 0}
 * line2 = {1, 1}, {0, -1}
 * 输出： {0.5, 0}
 * <p>
 * 示例 2：
 * 输入：
 * line1 = {0, 0}, {3, 3}
 * line2 = {1, 1}, {2, 2}
 * 输出： {1, 1}
 * <p>
 * 示例 3：
 * 输入：
 * line1 = {0, 0}, {1, 1}
 * line2 = {1, 0}, {2, 1}
 * 输出： {}，两条线段没有交点
 * <p>
 * 提示：
 * 坐标绝对值不会超过 2^7
 * 输入的坐标均是有效的二维坐标
 * @author xiehai
 * @date 2020/08/10 16:07
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1603 {
    // #region snippet
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        // 以方程式ax + by + c = 0表示一条直线
        BiFunction<int[], int[], int[]> lineProducer = (p1, p2) -> {
            int x1 = p1[0], y1 = p1[1], x2 = p2[0], y2 = p2[1];
            int x0 = x2 - x1, y0 = y2 - y1;
            if (x0 == 0) {
                // 与x轴平行
                // x + 0y - x1 = 0
                return new int[]{1, 0, -x1};
            } else if (y0 == 0) {
                // 与y轴平行
                // 0x + y0 - y1 = 0
                return new int[]{0, 1, -y1};
            } else {
                // 斜线
                // 两点直线方程式
                // (y-y1)/(x-x1) = (y2-y1)/(x2-x1) 令x0 = x2 - x1 y0 = y2 - y1
                // x0*(y-y1) = y0*(x-x1)
                // y0*x - x0*y + x0*y1 - y0*x1 = 0
                return new int[]{y0, -x0, x0 * y1 - y0 * x1};
            }
        };
        // 分别求的line1和line2的方程式
        int[] line1 = lineProducer.apply(start1, end1), line2 = lineProducer.apply(start2, end2);
        // 根据交点公式((b1*c2-b2*c1)/(a1*b2-a2*b1)，(a2*c1-a1*c2)/(a1*b2-a2*b1))
        // a1*b2-a2*b1 分母
        int denominator = line1[0] * line2[1] - line1[1] * line2[0];

        // 是否在区间内
        BiPredicate<double[], Double> inRange = (range, value) -> range[0] <= value && value <= range[1];
        double[] s1 = new double[]{start1[0], start1[1]}, e1 = new double[]{end1[0], end1[1]};
        double[] s2 = new double[]{start2[0], start2[1]}, e2 = new double[]{end2[0], end2[1]};
        // 线段1x坐标区间
        double[] rx1 = new double[]{Double.min(s1[0], e1[0]), Double.max(s1[0], e1[0])};
        double[] ry1 = new double[]{Double.min(s1[1], e1[1]), Double.max(s1[1], e1[1])};
        double[] rx2 = new double[]{Double.min(s2[0], e2[0]), Double.max(s2[0], e2[0])};
        double[] ry2 = new double[]{Double.min(s2[1], e2[1]), Double.max(s2[1], e2[1])};

        // 非平行线
        if (denominator != 0) {
            // 交点
            double[] cp = new double[]{
                (line1[1] * line2[2] - line2[1] * line1[2]) * 1.0D / denominator,
                (line2[0] * line1[2] - line1[0] * line2[2]) * 1.0D / denominator
            };

            // 若交点x坐标y坐标都在线段区间内 则存在交点 否则线段不相交
            return
                inRange.test(rx1, cp[0]) && inRange.test(rx2, cp[0])
                    && inRange.test(ry1, cp[1]) && inRange.test(ry2, cp[1]) ? cp : new double[0];
        }

        // 重合线 a1*c2 - a2*c1 = 0 判断线段是否重叠
        // 若不重叠返回空 否则返回重叠最小坐标
        if (line1[0] * line2[2] - line2[0] * line1[2] == 0) {
            BiFunction<double[], double[], double[]> mp = (p1, p2) ->
                // 优先为x坐标值较小的 若x坐标相同 按照y坐标
                p1[0] != p2[0] ? (p1[0] < p2[0] ? p1 : p2) : (p1[1] < p2[1] ? p1 : p2);
            double[] mp1 = mp.apply(s1, e1), mp2 = mp.apply(s2, e2);
            if (inRange.test(rx2, mp1[0]) && inRange.test(ry2, mp1[1])) {
                return mp1;
            }

            if (inRange.test(rx1, mp2[0]) && inRange.test(ry1, mp2[1])) {
                return mp2;
            }
            // 否则 两条线段在同一直线 但是不重叠
        }

        // 平行线
        return new double[0];
    }
    // #endregion snippet
}
