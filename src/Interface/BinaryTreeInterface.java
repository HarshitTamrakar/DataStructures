/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Tree.Exceptions.ElementNotFoundException;
import Tree.Nodes.BinaryTreeNode;

/**
 *
 * @author hp 630
 */
public interface BinaryTreeInterface<T> extends CollectionsInterface<T> {
   
    /**
     * returns left child of root or throws ElementNotFoundException if not present
     * @return BinaryTreeNode leftChild
     * @throws ElementNotFoundException
     * @param BinaryTreeNode root
    */
    public BinaryTreeNode<T> getLeft(BinaryTreeNode<T> root) throws ElementNotFoundException;
    
    /**
     * returns right child of root or throws ElementNodeFoundException if not present
     * @return BinaryTreeNode rightChild
     * @param BinaryTreeNode root
     * @throws ElementNotFoundException
     */
    public BinaryTreeNode<T> getRight(BinaryTreeNode<T> root) throws ElementNotFoundException;
    
    public boolean isPresent(BinaryTreeNode root) throws Exception;
    
    public int height() throws Exception;
    
    public void printLevelWise() throws Exception;
    
    public void printInOrder();
    
    public void printPreOrder();
    
    public void printPostOrder();
    
    public void printLeafs();
    
}
