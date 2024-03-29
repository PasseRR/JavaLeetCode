package com.gitee.passerr.leetcode.problem.lcci.page1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

/**
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。
 * 设计一种算法，寻找机器人从左上角移动到右下角的路径。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。如果没有可行的路径，返回空数组。
 * <p>
 * 示例 1:
 * 输入:
 * |[
 * |  [0,0,0],
 * |  [0,1,0],
 * |  [0,0,0]
 * |]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 * @author xiehai
 * @date 2020/07/31 13:03
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0802 {
    // #region snippet
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length, columns = obstacleGrid[0].length;

        // dp记录可从起点可到达的点
        boolean[][] dp = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // 记录每个格子是否连通
                dp[i][j] = obstacleGrid[i][j] != 1 && (i - 1 < 0 || dp[i - 1][j] || j - 1 < 0 || dp[i][j - 1]);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        // 如果终点不可达 直接返回结果
        if (!dp[rows - 1][columns - 1]) {
            return result;
        }


        // 记录访问过的点 不重复走
        boolean[][] visited = new boolean[rows][columns];
        BiFunction<Integer, Integer, Boolean> backtrack = new BiFunction<Integer, Integer, Boolean>() {
            @Override
            public Boolean apply(Integer row, Integer column) {
                // 越界或者路障
                if (row >= rows || column >= columns || !dp[row][column] || visited[row][column]) {
                    return false;
                }

                result.add(Arrays.asList(row, column));
                visited[row][column] = true;
                // 终点
                if (row == rows - 1 && column == columns - 1) {
                    return true;
                }

                // 向下
                if (this.apply(row + 1, column)) {
                    return true;
                }

                // 向右
                if (this.apply(row, column + 1)) {
                    return true;
                }

                // 回溯
                result.remove(result.size() - 1);

                return false;
            }
        };

        backtrack.apply(0, 0);

        return result;
    }
    // #endregion snippet
}
