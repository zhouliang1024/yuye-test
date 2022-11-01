package com.example.yuye.biz.demo.array;

/**
 * @author zhouliang
 * @date 2022/10/21 1:39 PM
 */
public class Array {
    private int[] intArray;
    private int elems;
    private int length;

    private Array(int max){
        length =max;
        intArray = new int[max];
        elems=0;
    }

    /**
     * 添加
     *
     * @param value
     */
    public void add(int value){
        if (elems == length){
            return;
        }
        intArray[elems] = value;
        elems++;
    }

    /**
     * 查找
     *
     * @param searchValue
     * @return
     */
    public int find(int searchValue){
        int i;
        for ( i = 0; i < elems; i++) {
            if (intArray[i] == searchValue){
                break;
            }
        }
        if (i == elems){
            return -1;
        }
        return i;
    }

    /**
     * 删除元素
     *
     * @param value
     * @return
     */
    public boolean delete(int value){
        int i = find(value);
        if (i==-1) {
            return false;
        }
        for (int j = 0; j < elems-1; j++) {
            intArray[j] = intArray[j+1];
        }
        elems--;
        return false;
    }

    /**
     * 更新
     *
     * @param oldValue
     * @param newValue
     * @return
     */
    public boolean update(int oldValue ,int newValue){
        int i = find(oldValue);
        if (-1 == i){
            return false;
        }
        intArray[i] = newValue;
        return true;
    }


    /**
     * 显示所有
     */
    public void display(){
        for(int i = 0 ; i < elems ; i++){
            System.out.print(intArray[i]+" ");
        }
        System.out.print("\n");
    }


    public void bubbleSort() {
        for (int i = 0; i < elems - 1; i++) {
            System.out.println("第"+(i+1)+"趟：");
            for (int j = 0; j < elems - i - 1; j++) {
                if (intArray[j] > intArray[j + 1]) {
                    int temp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = temp;
                }
                display();
            }
        }
    }

    public void selectSort() {
        for (int i = 0; i < elems - 1; i++) {
            int min = i;
            for (int j = i + 1; j < elems; j++) {
                if (intArray[j] < intArray[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int temp = intArray[i];
                intArray[i] = intArray[min];
                intArray[min] = temp;
            }
            display();
        }
    }
    /**
     * 插入排序
     * 每趟选择一个待插入的数
     * 每次运行把待插入的数放在比它大/小后面
     */
    public void insertSort(){
        int j;
        for(int i = 1; i < elems; i++){
            int temp = intArray[i];
            j = i;
            while (j > 0 && temp < intArray[j-1]){
                intArray[j] = intArray[j-1];
                j--;
            }
            intArray[j] = temp;
        }
        display();
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        array.add(1);
        array.add(2);
        array.add(3);
        array.display();
        System.out.println(array.find(1)); ;
    }
}
