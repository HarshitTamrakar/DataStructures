/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayList;

import Interface.ListInterface;
import LinkedList.DoublyLinkedList;

/**
 *
 * @author hp 630
 */
public class ArrayListUsingLinkedList<T> implements ListInterface<T> {

    private DoublyLinkedList<T> list;
    
    public ArrayListUsingLinkedList(){
        list = new DoublyLinkedList<>();
    }
    @Override
    public void add(int index, T data) throws Exception {
        list.add(index, data);
    }

    @Override
    public T remove(int index) throws Exception {
        return list.remove(index);
    }

    @Override
    public void reverse() {
        list.reverse();
    }

    @Override
    public void add(T data) {
        list.add(data);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public T remove() throws Exception {
        return list.remove();
    }

    @Override
    public void print() throws Exception {
        list.print();
    }

    @Override
    public int size() {
        return list.size();
    }
    
    public T getLastElement(){
        return list.getLastElement();
    }
    
    public T getFirstElement(){
        return list.getFirstElement();
    }
}
