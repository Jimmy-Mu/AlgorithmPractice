package com.example.nanana;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯法
 * 题目描述
 * 给定一个无重复数字的整数数组，求其所有的排列方式。
 * 输入输出样例
 * 输入是一个一维整数数组，输出是一个二维数组，表示输入数组的所有排列方式。
 * Input: [1,2,3]
 * Output: [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
 * 可以以任意顺序输出，只要包含了所有排列方式即可。
 *
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 */

public class Zz013Permutations {
    private int[] nums;

    public Zz013Permutations(int[] nums) {
        this.nums = nums;
    }

    public void work() {
        int len = nums.length;
        boolean[] used = new boolean[len];
        List<List<Integer>> out = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, out);

        System.out.println("" + Arrays.toString(out.toArray()));

    }

    private void dfs(int[] nums, int len, int depth,
                     List<Integer> path, boolean[] used,
                     List<List<Integer>> res) {

        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0 ; i < len ; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1,
                        path, used,
                        res);

                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
