/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree.Nodes;

import ArrayList.ArrayListUsingLinkedList;

/**
 *
 * @author hp 630
 */
public class TreeNode<T> {
    private T data;
    private ArrayListUsingLinkedList<T> child;
    
    public TreeNode(){
        data = null;
        child = new ArrayListUsingLinkedList<>();
    }

    public TreeNode(T data) {
        this.data = data;
        child = new ArrayListUsingLinkedList<>();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ArrayListUsingLinkedList<T> getChild() {
        return child;
    }

    public void setChild(ArrayListUsingLinkedList<T> child) {
        this.child = child;
    }
    
}
