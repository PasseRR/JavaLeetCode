package com.gitee.passerr.leetcode.problem.algorithm.page3;

/**
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1:
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * <p>
 * 示例 2:
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * @author xiehai
 * @date 2019/08/07 14:55
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution149 {
    public int maxPoints(int[][] points) {
        int length = points.length;
        // 小于3个点 肯定在一条直线
        if (length < 3) {
            return length;
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            // 相同点数量
            int same = 1;
            for (int j = i + 1; j < length; j++) {
                int count = 0;
                if (points[j][0] == points[i][0] && points[j][1] == points[i][1]) {
                    // i点和j点相同 相同点数量增加
                    same++;
                } else {
                    // i点和j点不同 数量增加
                    count++;
                    // 有点A(x1, y1) B(x2, y2) C(x3, y3)
                    // 三点一线公式 (x2-x1)*(y3-y1) = (x3-x1)*(y2-y1)
                    // 转为long型 会溢出
                    long dx1 = points[j][0] - points[i][0];
                    long dy1 = points[j][1] - points[i][1];
                    // 选取第三个点
                    for (int k = j + 1; k < length; k++) {
                        long dx2 = points[k][0] - points[i][0];
                        long dy2 = points[k][1] - points[i][1];
                        if (dx1 * dy2 == dy1 * dx2) {
                            count++;
                        }
                    }
                }
                result = Math.max(result, same + count);
            }

        }

        return result;
    }
}
