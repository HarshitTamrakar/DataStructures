/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import Interface.StackInterface;
import Queue.QueueUsingArrayList;

/**
 *
 * @author hp 630
 */
public class StackUsingQueue<T> implements StackInterface<T> {

    QueueUsingArrayList<T> stack;

    public StackUsingQueue() {
        stack = new QueueUsingArrayList<>();
    }

    @Override
    public T peek() {
        return stack.getRear();
    }

    @Override
    public void add(T data) {
        stack.add(data);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public T remove() throws Exception {
        return stack.remove(stack.size() - 1);
    }

    @Override
    public void print() throws Exception {
        stack.print();
    }

    @Override
    public int size() {
        return stack.size();
    }
    
    public T remove(int index) throws Exception{
        return stack.remove(index);
    }
}
