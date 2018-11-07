package com.usoft.suntg.algorithm.structure.node;

/**
 * LinkedNode
 * @author suntg
 * @date ${date}
 */
public class LinkedNode<T> implements Node<T> {

    private T data;

    private Node<T> next;

    public LinkedNode(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * 获取当前节点的数据
     *
     * @return
     */
    @Override
    public T getData() {
        return data;
    }

    /**
     * 获取下一个节点
     *
     * @return
     */
    @Override
    public Node<T> getNext() {
        return next;
    }

    /**
     * 是否最后一个
     *
     * @return
     */
    @Override
    public boolean isLast() {
        return this.next == null;
    }
}
