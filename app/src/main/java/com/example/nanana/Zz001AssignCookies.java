package com.example.nanana;

import java.util.Arrays;
/*
455. Assign Cookies (Easy)
题目描述
有一群孩子和一堆饼干，每个孩子有一个饥饿度，每个饼干都有一个大小。每个孩子只能吃 最多一个饼干，且只有饼干的大小大于孩子的饥饿度时，这个孩子才能吃饱。求解最多有多少孩 子可以吃饱。
输入输出样例
输入两个数组，分别代表孩子的饥饿度和饼干的大小。输出最多有多少孩子可以吃饱的数量。
 */

public class Zz001AssignCookies {
    private int[] kidsHunger;
    private int[] cookies;
    public Zz001AssignCookies(int[] kidsHunger, int[] cookies) {
        this.kidsHunger = kidsHunger;
        this.cookies = cookies;
    }
    public void aha() {
        System.out.println("this is fulei aha");
    }
    public int fullKids() {
        System.out.println("this is fulei");
        Arrays.sort(kidsHunger);
        Arrays.sort(cookies);
        int kid = 0, cookie = 0;

        while(kid < kidsHunger.length && cookie < cookies.length) {
            if (kidsHunger[kid] <= cookies[cookie]) {
                kid++;
            }
            cookie++;
        }
        return kid;
    }
}
