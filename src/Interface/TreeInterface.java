/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import ArrayList.ArrayListUsingLinkedList;
import Tree.Exceptions.ElementNotFoundException;
import Tree.Nodes.BinaryTreeNode;
import Tree.Nodes.TreeNode;

/**
 *
 * @author hp 630
 */
public interface TreeInterface<T> extends CollectionsInterface<T> {
    
    public ArrayListUsingLinkedList<T> getChild(TreeNode root) throws ElementNotFoundException;

    public boolean isPresent(TreeNode root);
    
    public void printLevelWise();
    
    public int getChildSize(TreeNode root) throws ElementNotFoundException;
    
}
