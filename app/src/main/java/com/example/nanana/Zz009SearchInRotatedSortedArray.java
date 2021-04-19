package com.example.nanana;

/**
 * 题目描述
 * 一个原本增序的数组被首尾相连后按某个位置断开(如 [1,2,2,3,4,5] → [2,3,4,5,1,2]，在第一 位和第二位断开)，我们称其为旋转数组。给定一个值，判断这个值是否存在于这个为旋转数组 中。
 * 输入输出样例
 * 输入是一个数组和一个值，输出是一个布尔值，表示数组中是否存在该值。
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 */
public class Zz009SearchInRotatedSortedArray {
    private int[] nums;
    private int target;

    public Zz009SearchInRotatedSortedArray(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }

    public boolean search() {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                System.out.println("true");
                return true;
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        System.out.println("false");
        return false;
    }
}
