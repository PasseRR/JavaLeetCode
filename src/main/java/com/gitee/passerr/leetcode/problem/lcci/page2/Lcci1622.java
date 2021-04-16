package com.gitee.passerr.leetcode.problem.lcci.page2;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 一只蚂蚁坐在由白色和黑色方格构成的无限网格上。开始时，网格全白，蚂蚁面向右侧。每行走一步，蚂蚁执行以下操作。
 * (1) 如果在白色方格上，则翻转方格的颜色，向右(顺时针)转 90 度，并向前移动一个单位。
 * (2) 如果在黑色方格上，则翻转方格的颜色，向左(逆时针方向)转 90 度，并向前移动一个单位。
 * <p>
 * 编写程序来模拟蚂蚁执行的前 K 个动作，并返回最终的网格。
 * <p>
 * 网格由数组表示，每个元素是一个字符串，代表网格中的一行，黑色方格由'X'表示，白色方格由'_'表示，
 * 蚂蚁所在的位置由'L', 'U', 'R', 'D'表示，分别表示蚂蚁左、上、右、下 的朝向。只需要返回能够包含蚂蚁走过的所有方格的最小矩形。
 * 示例 1:
 * 输入: 0
 * 输出: ["R"]
 * <p>
 * 示例 2:
 * 输入: 2
 * 输出:
 * [
 * "_X",
 * "LX"
 * ]
 * <p>
 * 示例 3:
 * 输入: 5
 * 输出:
 * [
 * "_U",
 * "X_",
 * "XX"
 * ]
 * <p>
 * 说明：
 * K <= 100000
 * @author xiehai
 * @date 2021/03/23 13:50
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1622 {
    enum BlockColor {
        /**
         * 黑色块
         */
        BLACK("X") {
            @Override
            BlockColor overturn() {
                return WHITE;
            }
        },
        /**
         * 白色块
         */
        WHITE("_") {
            @Override
            BlockColor overturn() {
                return BLACK;
            }
        };

        String color;

        BlockColor(String color) {
            this.color = color;
        }

        /**
         * 方格翻转
         * @return {@link BlockColor}
         */
        abstract BlockColor overturn();
    }

    enum AntDirection {
        /**
         * 蚂蚁左朝向
         */
        LEFT('L') {
            @Override
            void moveClockwise(Meta meta) {
                meta.row--;
                meta.antDirection = UP;
            }

            @Override
            void moveAnticlockwise(Meta meta) {
                meta.row++;
                meta.antDirection = DOWN;
            }
        },
        /**
         * 上
         */
        UP('U') {
            @Override
            void moveClockwise(Meta meta) {
                meta.column++;
                meta.antDirection = RIGHT;
            }

            @Override
            void moveAnticlockwise(Meta meta) {
                meta.column--;
                meta.antDirection = LEFT;
            }
        },
        /**
         * 右
         */
        RIGHT('R') {
            @Override
            void moveClockwise(Meta meta) {
                meta.row++;
                meta.antDirection = DOWN;
            }

            @Override
            void moveAnticlockwise(Meta meta) {
                meta.row--;
                meta.antDirection = UP;
            }
        },
        /**
         * 下
         */
        DOWN('D') {
            @Override
            void moveClockwise(Meta meta) {
                meta.column--;
                meta.antDirection = LEFT;
            }

            @Override
            void moveAnticlockwise(Meta meta) {
                meta.column++;
                meta.antDirection = RIGHT;
            }
        };

        char direction;

        AntDirection(char direction) {
            this.direction = direction;
        }

        void move(Meta meta) {
            // 当前块白色顺时针移动
            if (meta.blockColor == BlockColor.WHITE) {
                this.moveClockwise(meta);
            } else {
                // 当前块为黑色逆时针移动
                this.moveAnticlockwise(meta);
            }
        }

        /**
         * 顺时针移动
         */
        abstract void moveClockwise(Meta meta);

        /**
         * 逆时针移动
         */
        abstract void moveAnticlockwise(Meta meta);
    }

    static class Meta {
        // 方块颜色哈希缓存
        Map<Integer, Map<Integer, BlockColor>> paths = new HashMap<>(8);
        // 初始方向
        AntDirection antDirection = AntDirection.RIGHT;
        BlockColor blockColor;
        // 当前所在行列位置
        int row = 0, column = 0;
        // 行列最大最小值
        int minRow = 0, maxRow = 0, minColumn = 0, maxColumn = 0;

        Meta() {
            // 初始化至少一行
            paths.put(0, new HashMap<>());
        }

        void move() {
            // 当前块颜色
            BlockColor color = paths.getOrDefault(this.row, new HashMap<>(4)).getOrDefault(column, BlockColor.WHITE);
            this.blockColor = color;
            paths.merge(this.row, new HashMap<>(4), (o, n) -> o);
            paths.get(this.row).put(this.column, color.overturn());
            // 前进
            this.antDirection.move(this);
            // 更新行列最大值
            this.minRow = Integer.min(this.row, this.minRow);
            this.maxRow = Integer.max(this.row, this.maxRow);
            this.minColumn = Integer.min(this.column, this.minColumn);
            this.maxColumn = Integer.max(this.column, this.maxColumn);
        }

        List<String> result() {
            // 行字符个数
            int width = this.maxColumn - this.minColumn + 1;

            List<StringBuilder> collect =
                IntStream.rangeClosed(this.minRow, this.maxRow)
                    .mapToObj(row ->
                        Optional.ofNullable(this.paths.get(row))
                            .filter(it -> !it.isEmpty())
                            .map(columns ->
                                IntStream.rangeClosed(this.minColumn, this.maxColumn)
                                    .mapToObj(column ->
                                        Optional.ofNullable(columns.get(column))
                                            .map(it -> it.color)
                                            .orElse(BlockColor.WHITE.color)
                                    )
                                    .collect(Collectors.joining(""))
                            )
                            .map(StringBuilder::new)
                            .orElseGet(() ->
                                new StringBuilder(String.join("", Collections.nCopies(width, BlockColor.WHITE.color)))
                            )
                    )
                    .collect(Collectors.toList());

            // 将当前行列位置替换为方向
            collect.get(this.row - this.minRow).setCharAt(this.column - this.minColumn, this.antDirection.direction);

            return collect.stream().map(StringBuilder::toString).collect(Collectors.toList());
        }
    }

    public List<String> printKMoves(int K) {
        Meta meta = new Meta();
        while (K > 0) {
            meta.move();
            K--;
        }

        return meta.result();
    }
}
