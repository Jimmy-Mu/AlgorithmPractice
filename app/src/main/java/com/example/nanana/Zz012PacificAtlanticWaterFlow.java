package com.example.nanana;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题目描述
 * 给定一个二维的非负整数矩阵，每个位置的值表示海拔高度。
 * 假设左边和上边是太平洋，右边和下边是大西洋，求从哪些位置向下流水，可以流到太平洋和大西洋。水只能从海拔高的位置 流到海拔低或相同的位置。
 * 输入输出样例
 * 输入是一个二维的非负整数数组，表示海拔高度。输出是一个二维的数组，其中第二个维度 大小固定为 2，表示满足条件的位置坐标。
 *   Input:
 *
 * 太平洋  ~  ~  ~  ~  ~
 *     ~  1  2  2  3 (5)*
 *     ~  3  2  3 (4)(4)*
 *     ~  2  4 (5) 3  1 *
 *     ~ (6)(7) 1  4  5 *
 *     ~ (5) 1  1  2  4 *
 *        *  *  *  *  * 大西洋
 *
 * 在这个样例中，有括号的区域为满足条件的位置。
 *
 * Output: [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
 *
 * 虽然题目要求的是满足向下流能到达两个大洋的位置，如果我们对所有的位置进行搜索，那么在不剪枝的情况下复杂度会很高。
 * 因此我们可以反过来想，从两个大洋开始向海拔高出流，这样我们只需要对矩形四条边进行搜索。
 */

public class Zz012PacificAtlanticWaterFlow {

    private int[][] flow;
    private boolean[][] pacific;
    private boolean[][] atlantic;

    public Zz012PacificAtlanticWaterFlow(int[][] flow) {
        this.flow = flow;
        pacific = new boolean[flow.length][flow[0].length];
        atlantic = new boolean[flow.length][flow[0].length];
    }

    public int[][] work() {

        //pacific ocean 从左上角开始搜索
        for (int i = 0 ; i < flow.length ; i++) {
            if (!pacific[i][0]) {
                //如果左边的该项没有被搜索过，则进行搜索
                dfsPacific(i, 0);
            }
        }

        for (int j = 0 ; j < flow[0].length ; j++) {
            if (!pacific[0][j]) {
                //如果上边的该项没有被搜索过，则进行搜索
                dfsPacific(0, j);
            }
        }

        //atlantic ocean 从右下角开始
        for (int i = flow.length - 1 ; i >= 0 ; i--) {
            if (!atlantic[i][flow[0].length - 1]) {
                //如果右边的该项没有被搜索过，则进行搜索
                dfsAtlantic(i, flow[0].length - 1);
            }
        }
        for (int j = flow[0].length - 1 ; j>=0 ; j--) {
            if (!atlantic[flow.length - 1][j]) {
                //如果下边的该项没有被搜索过，则进行搜索
                dfsAtlantic(flow.length - 1, j);
            }
        }

        //输出处理后的pacific数组
        System.out.println("pacific array");
        for (int i = 0;i<pacific.length;i++) {
            for (int j = 0;j<pacific[i].length; j++) {
                System.out.print(pacific[i][j] + "  ");
            }
            System.out.println("");
        }

        //输出处理后的atlantic数组
        System.out.println("atlantic array");
        for (int i = 0;i<atlantic.length;i++) {
            for (int j = 0;j<atlantic[i].length; j++) {
                System.out.print(atlantic[i][j] + "  ");
            }
            System.out.println("");
        }

        //以上两个数组的每一项同时为true的 即为本题所求

        return checkAllTrue();
    }

    private void dfsPacific(int i, int j) {
        //因为pacific是左上两边，且搜索是从左上角开始（下标由小变大），在搜索时从（i，0）、（0，j）开始【i的取值是0至length-1】【j的取值是0至length-1】，因此下标是一定变大的
        //搜索到该项便意味着该项满足条件（该项的海拔高于前一项），因此将该项对应的bool数组置为true，并继续尝试搜索满足条件（下一项的海拔比该项高）的下一项，
        // 因为有两条边，因此有两次搜索。
        pacific[i][j] = true;
        if (isIn(i+1, j) && flow[i+1][j] >= flow[i][j]) {
            dfsPacific(i+1, j);
        }

        if (isIn(i, j+1) && flow[i][j+1] >= flow[i][j]) {
            dfsPacific(i, j+1);
        }
    }

    private void dfsAtlantic(int i, int j) {
        //因为atlantic是右下两边，且搜索是从右下角开始（下标由大变小），在搜索时从（i，length-1）、（length-1，j）开始【i的取值是length-1至0】【j的取值是length-1至0】，因此下标是一定变小的
        //搜索到该项便意味着该项满足条件（该项的海拔高于前一项），因此将该项对应的bool数组置为true，并继续尝试搜索满足条件（下一项的海拔比该项高）的下一项，
        // 因为有两条边，因此有两次搜索。
        atlantic[i][j] = true;
        if (isIn(i-1, j) && flow[i-1][j] >= flow[i][j]) {
            dfsAtlantic(i-1, j);
        }
        if (isIn(i, j-1) && flow[i][j-1] >= flow[i][j]) {
            dfsAtlantic(i, j-1);
        }
    }

    private boolean isIn(int x, int y) {
        return x >= 0 && x < flow.length && y >=0 && y < flow[0].length;
    }

    private int[][] checkAllTrue() {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0 ; i < atlantic.length ; i++) {
            for (int j = 0 ; j < atlantic[i].length ; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    int[] target = new int[]{i, j};
                    list.add(target);
                    System.out.println("两个大洋都能流至的坐标有" + Arrays.toString(target));
                }
            }
        }

        return list.toArray(new int[0][]);
    }
}
