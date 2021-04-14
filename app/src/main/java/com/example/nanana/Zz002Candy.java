package com.example.nanana;
/*
题目描述
一群孩子站成一排，每一个孩子有自己的评分。现在需要给这些孩子发糖果，
规则是如果一个孩子的评分比自己身旁的一个孩子要高，那么这个孩子就必须得到比身旁孩子更多的糖果;
所有孩子至少要有一个糖果。求解最少需要多少个糖果。
输入输出样例
输入是一个数组，表示孩子的评分。输出是最少糖果的数量。
   Input: [1,0,2]
   Output: 5
 */

import java.util.Arrays;

public class Zz002Candy {
    private int[] ranks;
    public Zz002Candy(int[] ranks) {
        this.ranks = ranks;
    }

    public int candy() {
        int[] candies = new int[ranks.length];
        for (int x = 0;x<ranks.length;x++) {
            candies[x] = 1;
        }
        System.out.println("candies = " + Arrays.toString(candies));

        for (int i = 0; i + 1 < ranks.length; i++) {
            if (ranks[i] < ranks[i + 1]) {
                candies[i+1] = candies[i] + 1;
            }
        }

        for (int j = ranks.length - 1; j - 1 >= 0; j--) {
            if(ranks[j] < ranks[j - 1]) {
                candies[j-1] = Math.max(candies[j] + 1, candies[j-1]);
            }
        }

        int sum = 0;
        for (int candy: candies) {
            sum += candy;
        }
        return sum;
    }
}
