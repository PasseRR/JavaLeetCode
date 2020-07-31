package com.gitee.passerr.leetcode.problem.lcci.page1;

import java.util.function.BiConsumer;

/**
 * 编写函数，实现许多图片编辑软件都支持的「颜色填充」功能。
 * 待填充的图像用二维数组 image 表示，元素为初始颜色值。初始坐标点的横坐标为 sr 纵坐标为 sc。需要填充的新颜色为 newColor 。
 * 「周围区域」是指颜色相同且在上、下、左、右四个方向上存在相连情况的若干元素。
 * 请用新颜色填充初始坐标点的周围区域，并返回填充后的图像。
 * <p>
 * 示例：
 * 输入：
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * 输出：[[2,2,2],[2,2,0],[2,0,1]]
 * 解释:
 * 初始坐标点位于图像的正中间，坐标 (sr,sc)=(1,1) 。
 * 初始坐标点周围区域上所有符合条件的像素点的颜色都被更改成 2 。
 * 注意，右下角的像素没有更改为 2 ，因为它不属于初始坐标点的周围区域。
 * <p>
 * 提示：
 * image 和 image[0] 的长度均在范围 [1, 50] 内。
 * 初始坐标点 (sr,sc) 满足 0 <= sr < image.length 和 0 <= sc < image[0].length 。
 * image[i][j] 和 newColor 表示的颜色值在范围 [0, 65535] 内。
 * @author xiehai
 * @date 2020/07/31 13:25
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0810 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 初始颜色
        int oldColor = image[sr][sc];
        // 初始颜色和新颜色一致
        if (oldColor == newColor) {
            return image;
        }

        int rows = image.length, columns = image[0].length;
        BiConsumer<Integer, Integer> dfs = new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer row, Integer column) {
                // 数组越界或者给定位置不是初始值颜色
                if (row >= rows || row < 0 || column >= columns || column < 0 || image[row][column] != oldColor) {
                    return;
                }
                image[row][column] = newColor;
                // 继续遍历上下左右
                this.accept(row - 1, column);
                this.accept(row + 1, column);
                this.accept(row, column - 1);
                this.accept(row, column + 1);
            }
        };
        dfs.accept(sr, sc);

        return image;
    }
}
