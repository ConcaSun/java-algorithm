package com.usoft.suntg.algorithm.patterns.cache;

/**
 * Created by ConcaSun on 2019/5/26.
 */
public class DLinkedNode {

    private String key;
    private Object value;
    private DLinkedNode pre;
    private DLinkedNode post;

    public DLinkedNode(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public DLinkedNode getPre() {
        return pre;
    }

    public void setPre(DLinkedNode pre) {
        this.pre = pre;
    }

    public DLinkedNode getPost() {
        return post;
    }

    public void setPost(DLinkedNode post) {
        this.post = post;
    }
}
