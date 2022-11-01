package com.example.yuye.biz.demo.stack;

/**
 * @author zhouliang
 * @date 2022/10/28 2:36 PM
 */
public class ArrayStack {

        String [] items;//数组
        int count; //栈中元素个数
        int n;//栈的大小

        public ArrayStack(String[] items, int count, int n) {
            this.items = items;
            this.count = count;
            this.n = n;
        }


    public boolean push(String item){
        if (count == n){
            return false;
        }
        items[count]=item;
        ++count;
        return true;
    }
    public String pop(){
        if (count == 0){
            return null;
        }
        String temp = items[count-1];
        count--;
        return temp;
    }
}
