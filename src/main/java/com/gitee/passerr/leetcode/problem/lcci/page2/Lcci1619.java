package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Collection;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。
 * 由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
 * <p>
 * 示例：
 * 输入：
 * |[
 * |  [0,2,1,0],
 * |  [0,1,0,1],
 * |  [1,1,0,1],
 * |  [0,1,0,1]
 * |]
 * 输出： [1,2,4]
 * <p>
 * 提示：
 * 0 < len(land) <= 1000
 * 0 < len(land[i]) <= 1000
 * @author xiehai
 * @date 2021/03/23 09:00
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1619 {
    // #region snippet
    public int[] pondSizes(int[][] land) {
        int rows = land.length, columns = land[0].length;

        // dfs
        BiFunction<Integer, Integer, Integer> dfs = new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer row, Integer column) {
                // 越界或者非水域
                if (row < 0 || row >= rows || column < 0 || column >= columns || land[row][column] != 0) {
                    return 0;
                }

                // 已经访问过的置为非0
                land[row][column] = 1;

                return
                    // 水平
                    this.apply(row + 1, column) + this.apply(row - 1, column) +
                        // 垂直
                        this.apply(row, column + 1) + this.apply(row, column - 1) +
                        // 左上到右下对角线
                        this.apply(row + 1, column + 1) + this.apply(row - 1, column - 1) +
                        // 右上到做下对角线及当前单元格
                        this.apply(row + 1, column - 1) + this.apply(row - 1, column + 1) + 1;
            }
        };

        return
            IntStream.range(0, rows)
                .boxed()
                .map(row ->
                    IntStream.range(0, columns)
                        .filter(column -> land[row][column] == 0)
                        .map(column -> dfs.apply(row, column))
                        .boxed()
                        .collect(Collectors.toList())
                )
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                .stream()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    // #endregion snippet
}
