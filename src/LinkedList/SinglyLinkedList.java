/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import LinkedList.Exceptions.EmptyListException;
import LinkedList.Exceptions.IndexNotFoundException;
import LinkedList.Nodes.SinglyLinkedListNode;
import Interface.CollectionsInterface;
import Interface.ListInterface;

/**
 *
 * @author hp 630
 */
public class SinglyLinkedList<T> implements ListInterface<T> {

    private SinglyLinkedListNode<T> head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    public SinglyLinkedList(T data) {
        head.setData(data);
        head.setNext(null);
        size = 0;
    }

    @Override
    public void add(T data) {
        if (head == null) {
            head = new SinglyLinkedListNode(data);
            head.setNext(null);
        } else {
            SinglyLinkedListNode temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new SinglyLinkedListNode(data));
            temp = temp.getNext();
            temp.setNext(null);
        }
        size++;
    }

    public void add(int index, T data) throws IndexNotFoundException {
        if (index > size) {
            throw new IndexNotFoundException("" + index);
        } else {
            SinglyLinkedListNode<T> temp = head;
            if (index == 0) {
                SinglyLinkedListNode<T> newHead = new SinglyLinkedListNode(data);
                newHead.setNext(head);
                head = newHead;
            } else {
                int i = 0;
                while (i < index - 1) {
                    temp = temp.getNext();
                    i++;
                }
                SinglyLinkedListNode<T> element = temp.getNext();
                temp.setNext(new SinglyLinkedListNode(data));
                temp = temp.getNext();
                temp.setNext(element);
            }
        }
        size++;
    }

    @Override
    public T remove() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException("List is empty");
        }
        T element;
        if (size == 1) {
            element = head.getData();
            head = head.getNext();
        } else {
            SinglyLinkedListNode<T> temp = head;
            while (temp.getNext().getNext() != null) {
                temp = temp.getNext();
            }
            element = (T) temp.getNext().getData();
            temp.setNext(null);
        }
        size--;
        return element;
    }

    public T remove(int index) throws EmptyListException, IndexNotFoundException {
        if (this.isEmpty()) {
            throw new EmptyListException("List is empty");
        }
        if (index > size) {
            throw new IndexNotFoundException("Index not  found");
        }
        T element;
        if (index == 0) {
            element = head.getData();
            head = head.getNext();
        } else {
            SinglyLinkedListNode<T> temp = head;
            int i = 0;
            while (i < index - 1) {
                temp = temp.getNext();
                i++;
            }
            SinglyLinkedListNode<T> next = temp.getNext().getNext();
            SinglyLinkedListNode<T> cur = temp.getNext();
            element = cur.getData();
            cur = null;
            temp.setNext(next);
        }
        size--;
        return element;
    }

    private void printReverseHelper(SinglyLinkedListNode<T> head) {
        if (head.getNext() == null) {
            System.out.print(head.getData() + " -> ");
            return;
        }
        printReverseHelper(head.getNext());
        System.out.print(head.getData() + " -> ");
    }

    public void printReverse() {
        printReverseHelper(head);
        System.out.print("null");
        System.out.println();
    }

    private SinglyLinkedListNode<T> reverseHelper(SinglyLinkedListNode<T> head) {
        if (head.getNext() == null) {
            return head;
        }
        SinglyLinkedListNode<T> newHead = reverseHelper(head.getNext());
        SinglyLinkedListNode<T> temp = newHead;
        while (newHead.getNext() != null) {
            newHead = newHead.getNext();
        }
        newHead.setNext(head);
        newHead = newHead.getNext();
        newHead.setNext(null);
        return temp;
    }

    public void reverse() {
        head = reverseHelper(head);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void print() throws EmptyListException {
        if (isEmpty()) {
            System.out.println("null");
            return;
        }
        SinglyLinkedListNode<T> temp = head;
        while (temp != null) {
            if (temp.getNext() != null) {
                System.out.print(temp.getData() + " -> ");
            } else {
                System.out.print(temp.getData() + " -> null");
            }
            temp = temp.getNext();
        }
        System.out.println();
    }

}
