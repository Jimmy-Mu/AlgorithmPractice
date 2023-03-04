package com.example.nanana;

/**
 * 题目描述
 * 给定一个增序的整数数组和一个值，查找该值第一次和最后一次出现的位置。
 * 输入输出样例
 * 输入是一个数组和一个值，输出为该值第一次出现的位置和最后一次出现的位置(从 0 开 始);如果不存在该值，则两个返回值都设为-1。
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 数字 8 在第 3 位第一次出现，在第 4 位最后一次出现。
 */

public class Zz008FindFirstLastPosition {
    private int[] nums;
    private int target;

    public Zz008FindFirstLastPosition(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public int[] getPosition() {
        int first = -1;
        int last = -1;

        int pos = getMidPosition();
        if (pos == -1) {
            return new int[]{ first, last };
        }
        int start = 0, end = nums.length - 1, mid = pos;
        while (start <= mid) {
            if (nums[start] < nums[mid]) {
                start++;
            } else {
                first = start;
                break;
            }
        }

        while (mid <= end) {
            if (nums[mid] < nums[end]) {
                end--;
            } else {
                last = end;
                break;
            }
        }

        System.out.println("第一次出现的位置是 " + first + "   最后一次出现的位置是" + last);

        return new int[]{ first, last };
    }

    private int getMidPosition() {
        int start = 0, end = nums.length - 1, mid = -1;
        while (start <= end) {
            if (mid == (start + end) / 2) {
                break;
            }
            mid = (start + end) / 2;
            if (target > nums[mid]) {
                start = mid;
            } else if (target < nums[mid]) {
                end = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
