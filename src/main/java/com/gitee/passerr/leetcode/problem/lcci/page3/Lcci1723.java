package com.gitee.passerr.leetcode.problem.lcci.page3;

/**
 * 给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵(可以是空心的 只需边为0即可)。
 * 返回一个数组 [r, c, size] ，其中r,c分别代表子方阵左上角的行号和列号，size 是子方阵的边长。
 * 若有多个满足条件的子方阵，返回 r 最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。
 * <p>
 * 示例 1:
 * 输入:
 * .[
 * .  [1,0,1],
 * .  [0,0,1],
 * .  [0,0,1]
 * .]
 * 输出: [1,0,2]
 * 解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
 * <p>
 * 示例 2:
 * 输入:
 * .[
 * .  [0,1,1],
 * .  [1,0,1],
 * .  [1,1,0]
 * .]
 * 输出: [0,0,1]
 * <p>
 * 提示：
 * matrix.length == matrix[0].length <= 200
 * @author xiehai
 * @date 2021/06/17 15:17
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1723 {
    // #region snippet
    public int[] findSquare(int[][] matrix) {
        int len = matrix.length;
        // 0 从下到上连续黑色像素个数 1从右至左连续黑色元素个数
        int[][][] dp = new int[len + 1][len + 1][2];
        int[] result = new int[3];

        // 考虑需要返回行最小及列做小 考虑倒序遍历
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= 0; j--) {
                if (matrix[i][j] == 0) {
                    // 垂直方向连续黑色元素个数
                    dp[i][j][0] = dp[i + 1][j][0] + 1;
                    // 水平方向连续黑色元素个数
                    dp[i][j][1] = dp[i][j + 1][1] + 1;

                    // 找到与当前点相邻的两条边最短边长
                    int width = Integer.min(dp[i][j][0], dp[i][j][1]);

                    // 找到最大边长解
                    // 需要满足以顶点出发的两个端点分别在水平及垂直方向的黑色元素大于等于k个
                    for (int k = width; k >= result[2]; k--) {
                        if (dp[i + k - 1][j][1] >= k && dp[i][j + k - 1][0] >= k) {
                            result[0] = i;
                            result[1] = j;
                            result[2] = k;
                            break;
                        }
                    }
                }
            }
        }

        // 兼容无解的情况
        return result[2] > 0 ? result : new int[0];
    }
    // #endregion snippet
}
