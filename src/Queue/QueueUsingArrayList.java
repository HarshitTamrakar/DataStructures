/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import ArrayList.ArrayListUsingLinkedList;
import Interface.ListInterface;
import Interface.QueueInterface;

/**
 *
 * @author hp 630
 */
public class QueueUsingArrayList<T> implements QueueInterface<T> {

    private ArrayListUsingLinkedList<T> queue;

    public QueueUsingArrayList() {
        queue = new ArrayListUsingLinkedList<>();
    }

    @Override
    public T getRear() {
        return queue.getLastElement();
    }

    @Override
    public T getFront() {
        return queue.getFirstElement();
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
    
    public T remove(int index) throws Exception{
        return queue.remove(index);
    }

}
