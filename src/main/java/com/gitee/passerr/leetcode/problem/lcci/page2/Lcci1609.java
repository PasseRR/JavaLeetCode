package com.gitee.passerr.leetcode.problem.lcci.page2;

/**
 * 请实现整数数字的乘法、减法和除法运算，运算结果均为整数数字，程序中只允许使用加法运算符和逻辑运算符，
 * 允许程序中出现正负常数，不允许使用位运算。
 * <p>
 * 你的实现应该支持如下操作：
 * Operations() 构造函数
 * minus(a, b) 减法，返回a - b
 * multiply(a, b) 乘法，返回a * b
 * divide(a, b) 除法，返回a / b
 * <p>
 * 示例：
 * Operations operations = new Operations();
 * operations.minus(1, 2); //返回-1
 * operations.multiply(3, 4); //返回12
 * operations.divide(5, -2); //返回-2
 * <p>
 * 提示：
 * 你可以假设函数输入一定是有效的，例如不会出现除法分母为0的情况
 * 单个用例的函数调用次数不会超过1000次
 * @author xiehai
 * @date 2020/08/20 15:04
 * @Copyright(c) tellyes tech. inc. co.,ltd
 */
public class Lcci1609 {
    // 此题修改为不使用+ - * / 做加减乘除
}

class Operations {
    public Operations() {

    }

    public int plus(int a, int b) {
        int sum = a, carry;
        while (b != 0) {
            // 异或结果为不需要进位的数字 如 (100 ^ 111) => 011
            sum = a ^ b;
            // 逻辑与结果为需要进位的数字 如 (100 & 111) >> 1 => 1000
            carry = (a & b) << 1;
            // 最终结果为 (011 + 1000) => 1011
            a = sum;
            b = carry;
        }

        return sum;
    }

    public int minus(int a, int b) {
        // a - b = a + (-b)
        // -b = ~b + 1
        // a - b = a + (~b+1)
        return this.plus(a, this.plus(~b, 1));
    }

    public int multiply(int a, int b) {
        // 递归出点
        if (a == 0 || b == 0) {
            return 0;
        }

        // 以3*4为例 拆分成 2*4 + 1*4 + 0
        // 若是25*4 拆分成 16*4 + 8*4 + 1*4 + 0
        int i = 31;
        // 找到最高位的1
        while ((a & 1 << i) == 0) {
            i = this.minus(i, 1);
        }

        // 递归拆分
        return this.plus(b << i, this.multiply(this.minus(a, 1 << i), b));
    }

    public int divide(int a, int b) {
        // 结果是否是正数
        boolean isPositive = a >= 0 == b >= 0;
        // 将数字转为负数 保证不溢出
        if (a > 0) {
            a = this.plus(~a, 1);
        }
        if (b > 0) {
            b = this.plus(~b, 1);
        }
        int result = 0;

        while (a <= b) {
            // t为b左移的位数 c为移动结果
            int t = 0, c = b;
            while (a <= c) {
                result = this.plus(result, 1 << t);
                a = this.minus(a, c);
                t = this.plus(t, 1);
                c <<= 1;
                // 左移溢出
                if (c >= 0) {
                    break;
                }
            }
        }

        return isPositive ? result : this.plus(~result, 1);
    }
}
