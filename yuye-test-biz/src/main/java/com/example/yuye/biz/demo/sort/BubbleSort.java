package com.example.yuye.biz.demo.sort;

import cn.hutool.json.JSONUtil;

/**
 * @author zhouliang
 * @date 2022/10/31 4:01 PM
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr, int n) {
        if (n<1){
            return;
        }
        for (int i = 0; i < n; i++) {
            boolean flag =false;
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag =true;
                }
            }
            if (!flag){
                break;
            }
        }
    }


    public static void insertSort(int[] arr,int n){
        if (n<1){
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j =i-1;
            for (; j >=0 ; --j) {
                if (arr[j]>value){
                    arr[j+1] =arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,7,4,1};
        insertSort(arr,arr.length);
        System.out.println(JSONUtil.toJsonStr(arr));
    }
}
