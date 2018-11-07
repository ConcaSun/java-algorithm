package com.usoft.suntg.algorithm.structure.stack;

import com.usoft.suntg.algorithm.structure.node.LinkedNode;
import com.usoft.suntg.algorithm.structure.node.Node;

import java.util.EmptyStackException;

/**
 * 链式栈
 * @author suntg
 * @date ${date}
 */
public class LinkedStack<T> implements Stack<T> {

    private Node<T> node;

    private int size;

    /**
     * 判断栈是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 将数据压入栈中
     *
     * @param data
     */
    @Override
    public void push(T data) {
        Node top = new LinkedNode(data, node);
        this.node = top;
        size ++;
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

        return node.getData();
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
        T data = node.getData();
        node = node.getNext();
        size --;
        return data;
    }
}
