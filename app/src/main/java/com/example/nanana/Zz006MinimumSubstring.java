package com.example.nanana;

/**
 * 题目描述
 * 给定两个字符串 S 和 T ，求 S 中包含 T 所有字符的最短连续子字符串的长度，同时要求时间复杂度不得超过 O(n)。
 * 输入输出样例
 * 输入是两个字符串 S 和 T，输出是一个 S 字符串的子串。
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 * 滑动窗口
 */

public class Zz006MinimumSubstring {
    private String source;
    private String target;

    public Zz006MinimumSubstring(String source, String target) {
        this.source = source;
        this.target = target;
    }

    public String getMinimumString() {
        int l = 0;
        int[] cha = new int[128];
        for(int i = 0; i < target.length(); i++) {
            cha[target.charAt(i)] = 1;
        }

        int count = target.length();
        for(int r = 0; r < source.length(); r++) {
            char ch = source.charAt(r);
            if(cha[ch] > 0) {
                count--;
            }
            cha[ch]--;
            if (count == 0) {
                // cha[source.charAt(l)]++;
                // l++;
                // count++
            }
        }
        return "";
    }

}
