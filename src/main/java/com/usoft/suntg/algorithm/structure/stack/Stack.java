package com.usoft.suntg.algorithm.structure.stack;

/**
 * 栈 接口
 * @author suntg
 * @date ${date}
 */
public interface Stack<T> {

    /**
     * 判断栈是否为空
     * @return
     */
    public boolean isEmpty();

    /**
     * 将数据压入栈中
     * @param data
     */
    public void push(T data);

    /**
     * 获取栈顶元素
     * @return
     */
    public T top();

    /**
     * 将栈顶元素移除，并返回
     * @return
     */
    public T pop();
}
