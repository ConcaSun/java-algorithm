package com.usoft.suntg.algorithm.patterns.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU 最近最少使用算法 缓存容器
 * Created by ConcaSun on 2019/5/26.
 */
public class LRUCacheContainer implements CacheContainer {

    private Map<String, DLinkedNode> cache = new HashMap<>();
    /**
     * 容器容量数，默认为5
     */
    private int capacity = 5;
    /**
     * 容器内缓存数计数，每新加一个不存在的内容，就加1，如果数量大于capacity时就需要淘汰
     */
    private int count;
    /**
     * 头部节点，它的key\value\pre都是空的，post指向第一个节点
     */
    private DLinkedNode head;
    /**
     * 头部节点，它的key\value\post都是空的，pre指向第一个节点
     */
    private DLinkedNode tail;

    public LRUCacheContainer(int capacity) {
        this();
        this.capacity = capacity;
    }

    public LRUCacheContainer() {
        this.head = new DLinkedNode("head", null);
        this.tail = new DLinkedNode("tail", null);

        this.head.setPre(null);
        this.head.setPost(this.tail);

        this.tail.setPre(this.head);
        this.tail.setPost(null);
    }

    @Override
    public void put(String key, Object value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            node = new DLinkedNode(key, value);
            addNode(node);
            cache.put(key, node);

            count ++;

            if(count > capacity) {
                DLinkedNode pop = popTail();
                cache.remove(pop.getKey());
                count --;
            }
        } else {
            node.setValue(value);
            moveToHead(node);
        }
    }

    @Override
    public Object get(String key) {
        DLinkedNode node = cache.get(key);
        if (node != null) {
            moveToHead(node);
            return node.getValue();
        }
        return null;
    }

    /**
     * 列出当前链表的数据
     */
    public void list() {
        list(this.head);
    }

    private void list(DLinkedNode node) {
        System.out.println("[" + node.getKey() + ", " + node.getValue() + "]");
        if (node.getPost() != null) {
            list(node.getPost());
        }
    }

    /**
     * 往链表里加入一个新节点，放在第一个
     * @param node
     */
    private void addNode(DLinkedNode node) {
        node.setPost(this.head.getPost());
        node.setPre(this.head);

        this.head.getPost().setPre(node);
        this.head.setPost(node);
    }

    /**
     * 移除一个节点
     * @param node
     */
    private void removeNode(DLinkedNode node) {
        node.getPost().setPre(node.getPre());
        node.getPre().setPost(node.getPost());
    }

    /**
     * 将一个节点移到头部
     * @param node
     */
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * 弹出末尾的节点
     * @return
     */
    private DLinkedNode popTail() {
        if (count < 1) {
            return null;
        }
        DLinkedNode node = tail.getPre();
        tail.setPre(node.getPre());
        node.getPre().setPost(tail);
        return node;
    }
}
