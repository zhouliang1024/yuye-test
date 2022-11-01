package com.example.yuye.biz.demo.array;

/**
 * @author zhouliang
 * @date 2022/10/21 4:05 PM
 */
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;


    public class Node{
        private Object data;
        private Node prev;//上一个
        private Node next;//下一个

        public Node(Object data) {
            this.data = data;
        }

    }

    public LinkedList(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    /**
     * 向链表添加数据
     *
     * @param object
     */
    public void addHead(Object object) {
        Node node = new Node(object);
        if (size == 0) {
            head = node;
            tail = node;
            size++;
        } else {
            head.prev = node;
            node.next = head;
            size++;
        }
    }

    /**
     * 删除头
     */
    public void deleteHead() {
        if (size != 0) {
            head.prev = null;
            head = head.next;
            size--;
        }
    }

    /**
     * 添加尾
     */
    public void  addTail(Object obj){
        Node node = new Node(obj);
        if (size == 0 ){
            head = node;
            tail= node;
            size++;
        } else {
            node.prev= tail;
            tail.next = node;
            tail = node;
            size++;
        }
    }

    /**
     * 删除尾
     */
    public void  deleteTail(){
       if (size!=0){
           tail.next =null;
           tail = tail.prev;
       }
    }

}
