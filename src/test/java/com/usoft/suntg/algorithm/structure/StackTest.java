package com.usoft.suntg.algorithm.structure;

import com.usoft.suntg.algorithm.structure.stack.LinkedStack;
import com.usoft.suntg.algorithm.structure.stack.SequenceStack;
import com.usoft.suntg.algorithm.structure.stack.Stack;
import org.junit.Test;

/**
 * StackTest
 * @author suntg
 * @date ${date}
 */
public class StackTest {

    @Test
    public void testSequenceStack() {
        Stack<String> stack = new SequenceStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("1");
        stack.push("3");
        stack.push("2");
        stack.push("5");
        stack.push("3");
        stack.push("4");
        stack.push("8");
        stack.push("6");
        stack.push("7");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    @Test
    public void testLinkedStack() {
        Stack<String> stack = new LinkedStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("1");
        stack.push("3");
        stack.push("2");
        stack.push("5");
        stack.push("3");
        stack.push("4");
        stack.push("8");
        stack.push("6");
        stack.push("7");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
