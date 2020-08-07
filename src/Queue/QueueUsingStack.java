/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import Interface.QueueInterface;
import Stack.StackUsingArrayList;

/**
 *
 * @author hp 630
 */
public class QueueUsingStack<T> implements QueueInterface<T> {

    private StackUsingArrayList<T> queue;

    public QueueUsingStack() {
        queue = new StackUsingArrayList<>();
    }

    @Override
    public T getRear() {
        return queue.peek();
    }

    @Override
    public T getFront() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(T data) {
        queue.add(data);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public T remove() throws Exception {
        return queue.remove(0);
    }

    @Override
    public void print() throws Exception {
        queue.print();
    }

    @Override
    public int size() {
        return queue.size();
    }

}
