/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import Interface.ListInterface;
import LinkedList.Exceptions.EmptyListException;
import LinkedList.Exceptions.IndexNotFoundException;
import LinkedList.Nodes.DoublyLinkedListNode;

/**
 *
 * @author hp 630
 */
public class DoublyLinkedList<T> implements ListInterface<T> {

    private DoublyLinkedListNode<T> head;
    private DoublyLinkedListNode<T> tail;
    private int size;

    public DoublyLinkedList(T data) {
        head = new DoublyLinkedListNode<T>(data);
        tail = null;
        size = 1;
    }

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(int index, T data) throws Exception {
        if (index >= size + 1) {
            throw new IndexNotFoundException("Invalid Index");
        } else if (index == 0) {
            DoublyLinkedListNode<T> newHead = new DoublyLinkedListNode<>(data);
            newHead.setNext(head);
            head.setPrevious(newHead);
            newHead.setPrevious(null);
            head = newHead;
        } else if (index == size - 1) {
            DoublyLinkedListNode<T> newTail = new DoublyLinkedListNode<>(data);
            tail.setNext(newTail);
            newTail.setPrevious(tail);
            tail = newTail;
        } else {
            DoublyLinkedListNode<T> temp = head;
            int i = 0;
            while (i < index) {
                temp = temp.getNext();
                i++;
            }
            DoublyLinkedListNode<T> element = new DoublyLinkedListNode<>(data);
            element.setPrevious(temp);
            element.setNext(temp.getNext());
            temp.setNext(element);
            element.getNext().setPrevious(element);
        }
        size++;
    }

    @Override
    public T remove(int index) throws Exception {
        if (isEmpty()) {
            throw new EmptyListException("List is empty");
        } else if (index > size - 1) {
            throw new IndexNotFoundException("Invalid index");
        } else {
            DoublyLinkedListNode<T> element;
            if (index == 0) {
                element = head;
                head = head.getNext();
                head.setPrevious(null);
            } else if (index == size - 1) {
                element = tail;
                tail = tail.getPrevious();
                tail.setNext(null);
            } else {
                int i = 0;
                DoublyLinkedListNode<T> temp = head;
                while (i < index - 1) {
                    temp = temp.getNext();
                    i++;
                }
                element = temp.getNext();
                temp.setNext(element.getNext());
                temp.getNext().setPrevious(temp);
            }
            size--;
            return element.getData();
        }
    }

    @Override
    public void reverse() {
        DoublyLinkedListNode<T> temp = tail;
        while (tail != null) {
            System.out.print(tail.getData() + " <-> ");
            tail = tail.getPrevious();
        }
        System.out.println("null");
    }

    @Override
    public void add(T data) {
        if (head == null) {
            head = new DoublyLinkedListNode<T>(data);
            head.setNext(tail);
        } else {
            DoublyLinkedListNode<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<>(data);
            temp.setNext(newNode);
            newNode.setPrevious(temp);
            tail = newNode;
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T remove() throws Exception {
        if (isEmpty()) {
            throw new EmptyListException("List is empty");
        } else {
            DoublyLinkedListNode<T> element;
            if (size == 1) {
                element = head;
                head = null;
                tail = null;
            } else {
                element = tail;
                tail = tail.getPrevious();
                element.getPrevious().setNext(null);
                element.setPrevious(null);
                tail.setNext(null);
            }
            size--;
            return element.getData();
        }
    }

    @Override
    public void print() {
        if (isEmpty()) {
            System.out.println("null");
            return;
        }
        DoublyLinkedListNode<T> temp = head;
        while (temp != null) {
            System.out.print(temp.getData() + " <-> ");
            temp = temp.getNext();
        }
        System.out.println("null");
    }

    @Override
    public int size() {
        return size;
    }

    public T getLastElement(){
        return tail.getData();
    }
    
    public T getFirstElement(){
        return head.getData();
    }
}
