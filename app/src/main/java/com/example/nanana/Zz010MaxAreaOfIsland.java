package com.example.nanana;

/** dfs
 * 深度优先搜索
 * 题目描述
 * 给定一个二维的 0-1 矩阵，其中 0 表示海洋，1 表示陆地。单独的或相邻的陆地可以形成岛 屿，每个格子只与其上下左右四个格子相邻。求最大的岛屿面积。
 *
 * 输入输出样例
 * 输入是一个二维数组，输出是一个整数，表示最大的岛屿面积。
 *
     Input:
     [[1,0,1,1,0,1,0,1],
     [1,0,1,1,0,1,1,1],
     [0,0,0,0,0,0,0,1]]
     Output: 6
 *
 *
 * 此题是十分标准的搜索题，我们可以拿来练手深度优先搜索。
 * 一般来说，深度优先搜索类型 的题可以分为主函数和辅函数，
 * 主函数用于遍历所有的搜索位置，判断是否可以开始搜索，
 * 如果可以即在辅函数进行搜索。辅函数则负责深度优先搜索的递归调用。
 */


public class Zz010MaxAreaOfIsland {
    private int[][] grid;

    public Zz010MaxAreaOfIsland(int[][] grid) {
        this.grid = grid;
    }

    public int work() {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0 ; j < grid[i].length ; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, dfs(i, j, grid));
                    System.out.println("中间值 res = " + res);
                }
            }
        }
        System.out.println("最大岛屿的面积是 " + res);
        return res;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int num = 1;
        num += dfs(i-1, j, grid);
        num += dfs(i+1, j, grid);
        num += dfs(i, j-1, grid);
        num += dfs(i, j+1, grid);
        System.out.println("中间值 num = " + num);
        return num;

    }
}
