package com.example.nanana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目描述  组合
 * 给定一个整数 n 和一个整数 k，求在 1 到 n 中选取 k 个数字的所有组合方法。
 *
 * 输入输出样例
 * 输入是两个正整数 n 和 k，输出是一个二维数组，表示所有组合方式。
 * Input: n = 4, k = 2
 * Output: [[2,4], [3,4], [2,3], [1,2], [1,3], [1,4]]
 * 这里二维数组的每个维度都可以以任意顺序输出。
 *
 * 使用回溯法，对比排列回溯的是交换的位置，而组合回溯的是 是否把当前的数字加入到结果中
 *
 * https://leetcode-cn.com/problems/combinations/solution/
 */

public class Zz014Combinations {
    private int n;
    private int k;

    public Zz014Combinations(int n, int k) {
        this.n = n;
        this.k = k;
    }

    public void work() {
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        boolean[] used = new boolean[n + 1];
        dfs(0, out, path, used);
        System.out.println(Arrays.toString(out.toArray()));
    }

    private void dfs(int depth, List<List<Integer>> out, List<Integer> path, boolean[]used) {

        if (depth == k) {
            out.add(new ArrayList<>(path));
            return;
        }

        for (int i = 1 ; i <= n ; i++) {
            if (!used[i]) {
                path.add(i);
                used[i] = true;
                dfs(depth+1, out, path, used);
                used[i] = false;
                path.remove(Integer.valueOf(i));
            }
        }
    }
}
