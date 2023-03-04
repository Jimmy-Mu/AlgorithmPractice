package com.example.nanana;
/*
珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。

珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。
如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。

珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。

返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。

---------------------------------------------------------------------
示例 1：

输入：piles = [3,6,7,11], h = 8
输出：4


示例 2：

输入：piles = [30,11,23,4,20], h = 5
输出：30

示例 3：

输入：piles = [30,11,23,4,20], h = 6
输出：23


提示：
1 <= piles.length <= 10^4
piles.length <= h <= 10^9
1 <= piles[i] <= 10^9

请完成： public int solution（int[] piles, int h)
 */

public class TestClass {

    public static void main(String[] args) {
        int ans = work(new int[]{3,6,7,11}, 8);
        System.out.println(ans);

    }

    private static int solution(int[] piles, int h) {
        int len = piles.length;
        int ans = 0;
        if (len > h) {
            return ans;
        }
        if (len == h) {
            for(int i : piles) {
                ans = Math.max(ans, i);
            }
            return ans;
        }


        return ans;
    }
    private static int work(int[] piles, int h){
        int len = piles.length;
        int ans = 0;
        if (len > h) {
            return ans;
        }
        if (len == h) {
            for(int i : piles) {
                ans = Math.max(ans, i);
            }
            return ans;
        }
        int maxSpeed = 0;
        for(int i : piles) {
            maxSpeed = Math.max(maxSpeed, i);
        }

        int left = h;
        for (int speed = 1; speed <= maxSpeed; speed++) {
            for (int j = 0; j < piles.length; j++) {
                System.out.println("left=" + left);
                System.out.println("speed=" + speed);
                left -= (piles[j] / speed) + (piles[j] % speed);
                if (left < 0) {
                    left = h;
                    break;
                }
                if (left <= 0 && j == piles.length-1) {
                    return speed;
                }
            }
            left = h;
        }
        return ans;
    }



}

