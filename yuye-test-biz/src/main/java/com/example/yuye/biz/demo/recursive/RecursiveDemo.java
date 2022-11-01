package com.example.yuye.biz.demo.recursive;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * @author zhouliang
 * @date 2022/10/31 2:32 PM
 */
public class RecursiveDemo {

    private static HashMap<Integer, Integer> hashMap = Maps.newHashMap();

    public static int f(int n){
        if (n==1) {
            return 1;
        }
        return f(n-1)+1;
    }


    public static int f2(int n){
        if (n==1) {
            return 1;
        }
        if (n==2){
            return 2;
        }
        if (hashMap.containsKey(n)){
            return hashMap.get(n);
        }
        int res= f2(n-1)+f2(n-2);
        hashMap.put(n,res);
        return res;
    }


    public static void main(String[] args) {
        System.out.println(f2(10));
    }
}
