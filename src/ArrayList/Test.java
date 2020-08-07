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
public class Test {

    public static void main(String[] args) throws Exception{
//        ArrayListUsingArray list = new ArrayListUsingArray();
//        list.add(10);
//        list.add(20);
//        list.add(30);
//        list.add(40);
//        int[] array = {50, 60, 70, 80, 90, 100};
//        list.add(array);
//        list.add(5, 55);
//        list.add(5, 55);
//        list.add(5, 55);
//        list.add(5, 55);
//        list.add(5, 55);
//        list.print();
//        list.remove(5);
//        list.remove(5);
//        list.remove(5);
//        list.remove(5);
//        list.remove(5);
//        list.print();
//        while (!list.isEmpty()) {
//            list.print();
//            System.out.println(list.remove());
//        }
//        list.add(0, 9);
//        list.add(1, 10);
//        list.add(2, 11);
//        list.print();
//        list.remove();
//        list.remove();
//        list.print();
//        list.remove();
//        System.out.println(list.isEmpty());
//        list.remove();
        ListInterface<Integer> list = new ArrayListUsingLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(0, 0);
        list.remove(0);
        list.remove(list.size() - 1);
        list.print();

    }
}
