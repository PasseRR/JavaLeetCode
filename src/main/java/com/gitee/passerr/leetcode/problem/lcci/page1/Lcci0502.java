package com.gitee.passerr.leetcode.problem.lcci.page1;

/**
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字不在0和1之间，或者无法精确地用32位以内的二进制表示，则打印“ERROR”。
 * <p>
 * 示例1:
 * 输入：0.625
 * 输出："0.101"
 * <p>
 * 示例2:
 * 输入：0.1
 * 输出："ERROR"
 * 提示：0.1无法被二进制准确表示
 * <p>
 * 提示：
 * 32位包括输出中的"0."这两位。
 * @author xiehai
 * @date 2020/06/23 09:32
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci0502 {
    // #region snippet
    public String printBin(double num) {
        double top = 1;
        StringBuilder sb = new StringBuilder("0.");
        for (int i = 1; i < 33; i++) {
            if (num == 0) {
                return sb.toString();
            }

            top /= 2;
            if (num >= top) {
                num -= top;
                sb.append("1");
            } else {
                sb.append("0");
            }
        }

        return "ERROR";
    }
    // #endregion snippet
}
