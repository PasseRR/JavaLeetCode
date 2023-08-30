package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * 不占用额外内存空间能否做到？
 * <p>
 * 示例 1:
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * <p>
 * 示例 2:
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 * @author xiehai
 * @date 2020/06/05 15:55
 * @Copyright(c) tellyes tech. inc. co.,ltd
 * @see com.gitee.passerr.leetcode.problem.algorithm.page1.Solution48
 */
public class Lcci0107 {
    // #region snippet
    public void rotate(int[][] matrix) {
        int length = matrix.length, temp;
        // [                   [
        //     [1, 2, 3],         [7, 8, 9],
        //     [4, 5, 6],  ==>    [4, 5, 6],
        //     [7, 8, 9]          [1, 2, 3]
        // ]                   ]
        // 上下翻转
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - i][j];
                matrix[length - 1 - i][j] = temp;
            }
        }

        // [                   [
        //     [7, 8, 9],         [7, 4, 1],
        //     [4, 5, 6],  ==>    [8, 5, 2],
        //     [1, 2, 3]          [9, 6, 3]
        // ]                   ]
        // 右上左下(/)对角线翻转
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    // #endregion snippet
}
