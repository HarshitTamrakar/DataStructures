/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Heap;

import java.util.ArrayList;
import Heap.Exceptions.EmptyHeapExceptions;
import Interface.MaxHeapInterface;

/**
 *
 * @author hp 630
 */
public class MaxHeapUsingBinaryTree{

    private ArrayList<Integer> heap;

    public MaxHeapUsingBinaryTree() {
        heap = new ArrayList<>();
    }

    public int getMax() throws EmptyHeapExceptions {
        if (isEmpty()) {
            throw new EmptyHeapExceptions();
        }
        return heap.get(0);
    }

    public void add(int data) {
        heap.add(data);
        upHeapify();
    }

    private int getParentIndex(int child) {
        return (child - 1) / 2;
    }

    private int getLeftChild(int parent) {
        return 2 * parent + 1;
    }

    private int getRightChild(int parent) {
        return 2 * parent + 2;
    }

    private void upHeapify() {
        int childIndex = heap.size() - 1;
        int parentIndex = getParentIndex(childIndex);

        while (parentIndex > 0 && heap.get(parentIndex) < heap.get(childIndex)) {
            int temp = heap.get(parentIndex);
            heap.set(parentIndex, heap.get(childIndex));
            heap.set(childIndex, temp);
            childIndex = parentIndex;
            parentIndex = getParentIndex(childIndex);
        }
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    private void downHeapify() {
        int parentIndex = 0;
        int leftChildIndex = getLeftChild(parentIndex);
        int rightChildIndex = getRightChild(parentIndex);

        while (true) {
            if (leftChildIndex < heap.size() && heap.get(parentIndex) < heap.get(leftChildIndex) && heap.get(leftChildIndex) > heap.get(rightChildIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(leftChildIndex));
                heap.set(leftChildIndex, temp);
                parentIndex = leftChildIndex;
            } else if (rightChildIndex < heap.size() && heap.get(parentIndex) < heap.get(rightChildIndex) && heap.get(rightChildIndex) > heap.get(leftChildIndex)) {
                int temp = heap.get(parentIndex);
                heap.set(parentIndex, heap.get(rightChildIndex));
                heap.set(rightChildIndex, temp);
                parentIndex = rightChildIndex;
            } else {
                break;
            }
            leftChildIndex = getLeftChild(parentIndex);
            rightChildIndex = getRightChild(parentIndex);
        }
    }

    public int remove() throws Exception {
        if (isEmpty()) {
            throw new EmptyHeapExceptions();
        }
        int temp = heap.get(0);
        int lastIndex = heap.size() - 1;
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);
        downHeapify();
        return temp;
    }

    public void print() throws Exception {

    }

    public int size() {
        return heap.size();
    }

}
