package com.usoft.suntg.algorithm.structure.node;

/**
 * Node
 * @author suntg
 * @date ${date}
 */
public interface Node<T> {

    /**
     * 获取当前节点的数据
     * @return
     */
    public T getData();

    /**
     * 获取下一个节点
     * @return
     */
    public Node<T> getNext();

    /**
     * 是否最后一个
     * @return
     */
    public boolean isLast();
}
