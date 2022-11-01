package com.example.yuye.biz.demo.queue;

/**
 * @author zhouliang
 * @date 2022/10/28 5:03 PM
 */
public class ArrayQueue {
    private String[] items;
    private int n =0;
    private int head =0;
    private int tail =0;

    public ArrayQueue(int capacity){
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item){
        if (tail == n ){
            return false;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public String dequeue(){
        if (head ==tail){
            return null;
        }
        String temp = items[tail];
        ++head;
        items[tail] = null;
        return temp;
    }
}
