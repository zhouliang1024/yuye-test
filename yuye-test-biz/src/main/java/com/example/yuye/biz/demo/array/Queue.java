package com.example.yuye.biz.demo.array;

/**
 * * 1.单向队列（Queue）：只能在一端插入数据，另一端删除数据。
 * * 2.双向队列（Deque）：每一端都可以进行插入数据和删除数据操作。
 * *
 * *  与栈不同的是，队列中的数据不总是从数组的0下标开始的
 * *  选择的做法是移动队头和队尾的指针。
 * *  为了避免队列不满却不能插入新的数据，我们可以让队尾指针绕回到数组开始的位置，这也称为“循环队列”。
 *
 * @author zhouliang
 * @date 2022/10/21 2:39 PM
 */
public class Queue {
    //单向循环队列，顺序存储结构实现
    private Object[] objQueue;
    private int maxSize;
    private int top;
    private int bottom;
    private int item;

    public Queue(int size) {
        maxSize = size;
        this.objQueue = new Object[maxSize];
        this.top = 0;
        this.bottom = -1;
        this.item = 0;
    }

    public void add(Object obj) {
        if (item == maxSize) {
            throw new RuntimeException(obj + " add error, queue is full");
        }
        if (bottom == maxSize - 1) {
            bottom = -1;
        }
        objQueue[++bottom] = obj;
        item++;
    }

    public Object out() {
        if (item == 0) {
            throw new RuntimeException("queue is null");
        }
        Object obj = objQueue[top];
        objQueue[top] = null;
        top++;
        if (top == maxSize) {
            top = 0;
        }
        item--;
        return obj;
    }

    private class NodeQueue<Objects> {
        private Object data;
        private NodeQueue next;

        public NodeQueue(Object data, NodeQueue next) {
            this.data = data;
            this.next = next;
        }
    }

    private NodeQueue queueTop;
    private NodeQueue queueBottom;
    private int size;

    public Queue() {
        queueTop = null;
        queueBottom = null;
        size = 0;
    }

    public void addNodeQueue(Object obj) {
        if (size == 0) {
            queueTop = new NodeQueue(obj, null);
            queueBottom = queueTop;
        } else {
            NodeQueue<Object> nodeQueue = new NodeQueue(obj, null);
            queueBottom.next = nodeQueue;
            queueBottom = nodeQueue;
        }
        size++;
    }

    /**
     * 出队
     * @return
     */
    public Object removeNodeQueue(){
        if(size == 0){
            throw new RuntimeException("queue is null");
        }
        NodeQueue nodeQueue = queueTop;
        queueTop = queueTop.next;
        //声明原队列头next可以回收空间(GC)
        nodeQueue.next = null;
        size--;
        return nodeQueue.data;
    }


}
