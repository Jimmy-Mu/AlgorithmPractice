package com.example.nanana;

import java.util.Arrays;

/**
 * 如果没有特殊说明，采用如下的数据结构表示链表的一个节点。
 * @see ListNode
 */
public class TestClass {

    public static void main(String[] args) {
        System.out.println("testtest");
        test12();
    }

    private static void test1() {
        int[] kids = new int[]{ 1, 2 };
        int[] cookies = new int[]{ 1, 2, 3 };

        Zz001AssignCookies zz001AssignCookies = new Zz001AssignCookies(kids, cookies);
        System.out.println("可以吃饱的孩子数量 = " + zz001AssignCookies.fullKids());
    }

    private static void test2() {
        int[] ranks = new int[]{ 1, 0, 2 };

        Zz002Candy zz2Candy = new Zz002Candy(ranks);
        System.out.println("最少糖果数量 = " + zz2Candy.candy());
    }

    private static void test3() {
        int[] numbers = new int[]{ 1, 2, 7, 15 };
        int target = 9;

        Zz003TwoSumII zz3TwoSumII = new Zz003TwoSumII(numbers, target);
        System.out.println("这一对解 = " + Arrays.toString(zz3TwoSumII.work()));
    }

    private static void test4() {
        int[] nums1 = new int[]{ 1, 2, 3, 0, 0, 0, 0, 0 };
        int[] nums2 = new int[]{ 0, 1, 2, 5, 6 };
        Zz004MergeSortedArray zz4MergeSortedArray = new Zz004MergeSortedArray(nums1, nums1.length - nums2.length, nums2, nums2.length);
        System.out.println("合并后的数组 = " + Arrays.toString(zz4MergeSortedArray.work()));
    }

    private static void test5() {
        ListNode listNode0 = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode2;

        Zz005LinkedListCycleII zz5LinkedListCycleII = new Zz005LinkedListCycleII(listNode0);
        System.out.println("环节点的val = " + zz5LinkedListCycleII.circleStartNode().val);
    }

    private static void test7() {
        Zz007Sqrts zz7Sqrts = new Zz007Sqrts(100);
        zz7Sqrts.getNumberSqrts();
    }

    private static void test8() {
        Zz008FindFirstLastPosition zz8FindFirstLastPosition = new Zz008FindFirstLastPosition(new int[]{ 8, 8, 8, 8, 8, 8 }, 8);
        zz8FindFirstLastPosition.getPosition();
    }

    private static void test9() {
        Zz009SearchInRotatedSortedArray zz9SearchInRotatedSortedArray = new Zz009SearchInRotatedSortedArray(new int[]{ 3, 1, 2, 3, 3, 3, 3 }, 2);
        zz9SearchInRotatedSortedArray.search();
    }

    private static void test10() {
        Zz010MaxAreaOfIsland zz010MaxAreaOfIsland = new Zz010MaxAreaOfIsland(new int[][]{
                {1,0,1,1,0,1,0,1},
                {1,0,1,1,0,1,1,1},
                {0,0,0,0,0,0,0,1}
        });
        zz010MaxAreaOfIsland.work();
    }

    private static void test11() {
        Zz011FriendsCircles zz011FriendsCircles = new Zz011FriendsCircles(new int[][]{
                {1,1,0},
                {1,1,0},
                {0,0,1}
        });
        zz011FriendsCircles.work();
    }

    private static void test12() {
        Zz012PacificAtlanticWaterFlow zz012PacificAtlanticWaterFlow = new Zz012PacificAtlanticWaterFlow(new int[][]{
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4},
        });

        zz012PacificAtlanticWaterFlow.work();
    }

}
