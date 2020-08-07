/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author hp 630
 */
public interface ListInterface<T> extends CollectionsInterface<T>{
    
    public void add(int index, T data) throws Exception;
    
    public T remove(int index) throws Exception;
    
    public void reverse();
    
}
