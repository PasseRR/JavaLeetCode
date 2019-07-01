package com.gitee.passerr.leetcode.problem.page1;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * <p>
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * <p>
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * @author xiehai
 * @date 2019/07/01 13:30
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Solution6 {
    public String convert(String s, int numRows) {
        // 一行特殊处理
        if (numRows == 1) {
            return s;
        }

        int length = s.length();
        // z可以看做レレレ组成
        // 一个レ的长度
        int vLength = 2 * (numRows - 1);
        StringBuilder sb = new StringBuilder();
        // 每个由(2*numRows - 1)个字符组成
        for (int i = 0; i < numRows; i++) {
            int index = 0;
            int position;
            // 第一行和最后一行只会包含一个字符
            if (i == 0 || i == numRows - 1) {
                while ((position = index++ * vLength + i) < length) {
                    sb.append(s.charAt(position));
                }
            } else {
                // 中间位置找出排列规律 计算
                while (true) {
                    if ((position = index * vLength + i) >= length) {
                        break;
                    }
                    sb.append(s.charAt(position));

                    if ((position = index * vLength + vLength - i) >= length) {
                        break;
                    }
                    sb.append(s.charAt(position));
                    index++;
                }
            }
        }

        return sb.toString();
    }
}
