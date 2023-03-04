package com.example.nanana;

import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class TestCode {

    public void test() {
        int[] arr = new int[]{1,2,3,4,5};
        TreeNode root = new TreeNode(1);
    }

    private void backtrack(int[] arr, TreeNode root, int index) {
        if (index == 5) {
            return;
        }
        root = new TreeNode(arr[index]);

        //左子空，右子不空
        root.left = null;
        backtrack(arr, root.right, index+1);

        //左子不空，右子空
        root.right = null;
        backtrack(arr, root.left, index+1);

        //左子不空，右子不空
        backtrack(arr, root.left, index+1);
        backtrack(arr, root.right, index+2);
    }

}
