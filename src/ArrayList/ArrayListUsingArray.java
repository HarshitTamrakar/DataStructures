/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayList;

import Interface.ListInterface;

/**
 *
 * @author hp 630
 */

public class ArrayListUsingArray {

    private int[] array;
    private int size;

    public ArrayListUsingArray() {
        array = new int[2];
        size = 0;
    }

    public ArrayListUsingArray(int size) {
        array = new int[size];
        this.size = 0;
    }

    public void add(int data) {
        array[size] = data;
        size++;
        if (size > array.length - 1) {
            reSize();
        }
    }

    public void add(int index, int data) {
        if (index < size + 1) {
            if (size + 1 > this.array.length - 1) {
                reSize();
            }
            int temp = array[index];
            array[index] = data;
            ++index;
            ++size;
            for (int i = index; i < size; i++) {
                int element = array[i];
                this.array[i] = temp;
                temp = element;
            }
        } else {
            throw new ArrayIndexOutOfBoundsException(index);
        }

    }

    public void add(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (size + i > this.array.length - 1) {
                reSize();
            }
            this.array[size + i] = array[i];
        }
        size = size + array.length;
    }

    public void sort_Asc() {
        
    }

    public void sort_Desc() {
        
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        if (this.isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("ArrayList is empty");
        }
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int remove() {
        if (this.isEmpty()) {
            throw new NullPointerException("ArrayList is empty");
        }
        int element = this.array[size - 1];
        size--;
        return element;
    }

    public int remove(int index) {
        int element = array[index];
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    private void reSize() {
        int length = array.length;
        int[] temp = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = array[i];
        }
        array = new int[length * 2];
        for (int i = 0; i < length; i++) {
            array[i] = temp[i];
        }
    }

    public int size() {
        return size;
    }


}
