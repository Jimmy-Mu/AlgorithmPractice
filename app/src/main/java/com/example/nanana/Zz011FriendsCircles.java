package com.example.nanana;

/**
 * 题目描述
 * 给定一个二维的 0-1 矩阵，如果第 (i, j) 位置是 1，则表示第 i 个人和第 j 个人是朋友。已知 朋友关系是可以传递的，即如果 a 是 b 的朋友，b 是 c 的朋友，那么 a 和 c 也是朋友，换言之这 三个人处于同一个朋友圈之内。求一共有多少个朋友圈。
 *
 * 输入输出样例
 * 输入是一个二维数组，输出是一个整数，表示朋友圈数量。因为朋友关系具有对称性，该二 维数组为对称矩阵。同时，因为自己是自己的朋友，对角线上的值全部为 1。
 * Input:
 * [[1,1,0],
 * [1,1,0],
 *  [0,0,1]]
 * Output: 2
 * 在这个样例中，[1,2] 处于一个朋友圈，[3] 处于一个朋友圈。
 */

public class Zz011FriendsCircles {
    private int[][] friends;
    private boolean[] visited;

    public Zz011FriendsCircles(int[][] friends) {
        this.friends = friends;
        this.visited = new boolean[friends.length];
    }

    public int work() {
        int res = 0;
        for (int i = 0 ; i < friends.length ; i++) {
            for (int j = 0 ; j < friends[i].length ; j++) {
                if (friends[i][j] == 1 && !visited[i]) {
                    dfs(i, j, friends);
                    res++;
                }
            }
        }
        System.out.println("朋友圈的个数为 " + res);
        return res;
    }

    private int dfs(int i, int j, int[][] friends) {
        if (i<0 || j<0 || i>=friends.length || j>=friends[i].length || friends[i][j] == 0) {
            return 0;
        }

        visited[i] = true;

        friends[i][j] = 0;
        dfs(i-1, j, friends);
        dfs(i+1, j, friends);
        dfs(i, j-1, friends);
        dfs(i, j+1, friends);

        return 1;

    }
}
