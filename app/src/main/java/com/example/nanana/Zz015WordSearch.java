package com.example.nanana;

/**
 * 回溯法
 * 题目描述
 * 给定一个字母矩阵，所有的字母都与上下左右四个方向上的字母相连。给定一个字符串，求字符串能不能在字母矩阵中寻找到。
 * <p>
 * 输入输出样例
 * 输入是一个二维字符数组和一个字符串，输出是一个布尔值，表示字符串是否可以被寻找到。
 * Input: word = "ABCCED", board =
 * [[’A’,’B’,’C’,’E’],
 * [’S’,’F’,’C’,’S’],
 * [’A’,’D’,’E’,’E’]]
 * <p>
 * Output: true
 * <p>
 * 从左上角的’A’ 开始，我们可以先向右、再向下、最后向左，找到连续的"ABCCED"。
 *
 * https://leetcode-cn.com/problems/word-search/solution/zai-er-wei-ping-mian-shang-shi-yong-hui-su-fa-pyth/
 */

public class Zz015WordSearch {
    private String word;
    private char[][] board;
    boolean[][] used;

    public Zz015WordSearch(String word, char[][] board) {
        this.word = word;
        this.board = board;
    }

    public void work() {

        used = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && !used[i][j]) {
                    dfs(i, j, 0);
                }
            }
        }
    }

    private void dfs(int i, int j, int index) {
        if (inArea(i, j) && !used[i][j] && board[i][j] == word.charAt(index)) {
            used[i][j] = true;

            dfs(i-1, j, index+1);
            dfs(i+1, j, index+1);
            dfs(i, j-1, index+1);
            dfs(i, j+1, index+1);

            used[i][j] = false;
        }
    }

    private boolean inArea(int i, int j) {
        return i >= 0 && j >= 0 && i < board.length && j < board[i].length;
    }
}
