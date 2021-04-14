package com.example.nanana;

/**
 * 题目描述
 * 给定一个非负整数，求它的开方，向下取整。
 * 输入输出样例
 * 输入一个整数number，输出一个整数。
 * Input: 8
 * Output: 2
 * 8 的开方结果是 2.82842...，向下取整即是 2。
 *
 * 使用牛顿迭代法：
 * Xn+1 = Xn - f(Xn)/f`(Xn)
 */
public class Zz007Sqrts {

    private double number;
    private int count;

    public Zz007Sqrts(double number) {
        this.number = number;
    }

    public int getNumberSqrts() {
        return (int)getSqrts(20);
    }

    private double getSqrts(double temp) {
        System.out.println("counts == " + count + "  temp == " + temp);
        double res = temp / 2 + number / (2 * temp);
        System.out.println("counts == " + count++ + "  res == " + res);

        if (res == temp) {
            return res;
        } else {
            return getSqrts(res);
        }
    }
}
