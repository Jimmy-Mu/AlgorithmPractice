package com.example.nanana;

/*
题目描述
给定两个有序数组，把两个数组合并为一个。
输入输出样例
 输入是两个数组和它们分别的长度 m 和 n。其中第一个数组的长度被延长至 m + n，
 多出的 n 位被 0 填补。题目要求把第二个数组归并到第一个数组上，不需要开辟额外空间。
   Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
   Output: nums1 = [1,2,2,3,5,6]
 */
public class Zz004MergeSortedArray {
    private int[] nums1;
    private int m;
    private int[] nums2;
    private int n;

    public Zz004MergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        this.nums1 = nums1;
        this.m = m;
        this.nums2 = nums2;
        this.n = n;
    }

    public int[] work() {
        int pos = m + n - 1;
        while (n>=1) {
            int num1 = nums1[m-1];
            int num2 = nums2[n-1];

            if(num1 <= num2) {
                nums1[pos--] = num2;
                --n;
            } else if (num1 > num2) {
                nums1[pos--] = num1;
                nums1[pos--] = num2;
                --m;
                --n;
            }
        }
        return nums1;

    }
}
