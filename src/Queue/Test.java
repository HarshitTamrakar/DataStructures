/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

/**
 *
 * @author hp 630
 */
public class Test {

    public static void main(String[] args) throws Exception{
        QueueUsingArrayList<Integer> queue = new QueueUsingArrayList<>();
        
        queue.remove();
        System.out.println(queue.getFront());
        queue.print();
    }
    
}
