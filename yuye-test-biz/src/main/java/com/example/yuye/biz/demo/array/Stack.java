package com.example.yuye.biz.demo.array;

import java.util.Arrays;

/**
 * @author zhouliang
 * @date 2022/10/21 2:11 PM
 */
public class Stack {

    private Object[]objArray;
    private int maxSize;
    private int top;

    public Stack() {
    }

    /**
     * 初始化一个堆
     *
     * @param maxSize
     */
    public Stack(int maxSize) {
        if (maxSize > 0) {
            Object[] objects = new Object[maxSize];
            this.maxSize = maxSize;
            top = -1;
        } else {
            throw new RuntimeException("初始化大小错误：maxSize=" + maxSize);
        }
    }

    /**
     * 动态扩容
     */
    public void grow() {
        if (top == maxSize - 1) {
            maxSize = maxSize << 1;
            objArray = Arrays.copyOf(objArray, maxSize);
        }
    }
    /**
     * 入栈
     *
     * @param obj
     */
    public void objPush(Object obj) {
        grow();
        objArray[++top] = obj;
    }

    /**
     * 查看栈顶
     * @return
     */
    public Object peekTop(){
        if(top != -1){
            return objArray[top];
        }else{
            throw new RuntimeException("stack is null");
        }
    }
    /**
     * 出栈
     */
    public Object objPop(){
        Object o = peekTop();
        objArray[top--] = null;
        return o;
    }

    private class Node<Object>{
        private Object data;
        private Node next;

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
        private Node nodeTop;
        private int size;

        public void nodePush(Object obj){
            //栈顶指向新元素，新元素的next指向原栈顶元素
            nodeTop = new Node(obj,nodeTop);
            size++;
        }

        public Object nodePop(){
            Node<Object> old = nodeTop;
            old.next =null;
            nodeTop = nodeTop.next;
            size--;
            return old.data;
        }


    }

}
