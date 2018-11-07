package com.usoft.suntg.algorithm.structure.stack;

import java.util.EmptyStackException;

/**
 * 顺序栈
 * @author suntg
 * @date ${date}
 */
public class SequenceStack<T> implements Stack<T> {

    /**
     * 栈顶指针， -1 代表空栈
     */
    private int top = -1;
    /**
     * 栈的容量，默认10，会自动扩容
     */
    private int capacity = 10;
    /**
     * 元素个数
     */
    private int size;
    /**
     * 用于存放数据的数组
     */
    private T[] array;



    /**
     * 判断栈是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.top == -1;
    }

    /**
     * 将数据压入栈中
     *
     * @param data
     */
    @Override
    public void push(T data) {
        if (array == null) {
            ensureCapacity(capacity);
        }
        if (size == array.length) {
            ensureCapacity(size * 2);
        }
        array[++top] = data;
        size++;
    }

    /**
     * 获取栈顶元素
     *
     * @return
     */
    @Override
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    /**
     * 将栈顶元素移除，并返回
     *
     * @return
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        return array[top--];
    }

    /**
     * 扩容
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        if (capacity < size) {
            return;
        }

        T[] old = array;
        array = (T[]) new Object[capacity];
        for (int i =0 ; i < size; i++) {
            array[i] = old[i];
        }
    }
}
