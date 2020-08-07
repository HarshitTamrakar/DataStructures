/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList.Nodes;

import LinkedList.Nodes.SinglyLinkedListNode;

/**
 *
 * @author hp 630
 */
public class DoublyLinkedListNode<T> {

    private DoublyLinkedListNode<T> previous;
    private DoublyLinkedListNode<T> next;
    private T data;
    
    public DoublyLinkedListNode(){
        previous = null;
        next = null;
        data = null;
    }

    public DoublyLinkedListNode(T data) {
        this.data = data;
        previous = null;
        next = null;
    }

    public DoublyLinkedListNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoublyLinkedListNode<T> previous) {
        this.previous = previous;
    }

    public DoublyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(DoublyLinkedListNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
}
