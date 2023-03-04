package com.example.nanana;

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
