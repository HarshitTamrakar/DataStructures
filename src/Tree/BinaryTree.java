/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tree;

import Interface.BinaryTreeInterface;
import Queue.QueueUsingArrayList;
import Tree.Exceptions.ElementNotFoundException;
import Tree.Exceptions.RootEmptyException;
import Tree.Nodes.BinaryTreeNode;

/**
 *
 * @author hp 630
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> {

    private BinaryTreeNode<T> root;
    private int size;

    public BinaryTree() {
        this.root = null;
        size = 0;
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
        size = 0;
    }

    @Override
    public BinaryTreeNode<T> getLeft(BinaryTreeNode<T> root) throws ElementNotFoundException {
        if (root.getLeft() != null) {
            return root.getLeft();
        } else {
            throw new ElementNotFoundException("Element not found");
        }
    }

    @Override
    public BinaryTreeNode<T> getRight(BinaryTreeNode<T> root) throws ElementNotFoundException {
        if (root.getRight() != null) {
            return root.getLeft();
        } else {
            throw new ElementNotFoundException("Element not found");
        }
    }

    @Override
    public boolean isPresent(BinaryTreeNode root) throws Exception {
        if(isEmpty()){
            throw new RootEmptyException("Root is empty");
        }
        QueueUsingArrayList<BinaryTreeNode> pending = new QueueUsingArrayList<BinaryTreeNode>();
        pending.add(root);
        while (!pending.isEmpty()) {
            BinaryTreeNode<T> current = pending.remove();
            if (current == root) {
                return true;
            } else {
                if (current.getLeft() != null) {
                    pending.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    pending.add(current.getRight());
                }
            }
        }
        return false;
    }

    @Override
    public int height() throws Exception {
        if(isEmpty()){
            throw new RootEmptyException("Root is empty");
        }
        QueueUsingArrayList<BinaryTreeNode<T>> pending = new QueueUsingArrayList<BinaryTreeNode<T>>();
        pending.add(this.root);
        int height = 0;
        pending.add(null);
        while (!pending.isEmpty()) {
            BinaryTreeNode<T> current = pending.remove();
            if (current == null) {
                height++;
                pending.add(null);
            } else {
                if (current.getLeft() != null) {
                    pending.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    pending.add(current.getRight());
                }
            }
        }
        return height;
    }

    @Override
    public void printLevelWise() throws Exception {
        if(isEmpty()){
            throw new RootEmptyException("Root is empty");
        }
        QueueUsingArrayList<BinaryTreeNode<T>> pending = new QueueUsingArrayList<>();
        pending.add(this.root);
        pending.add(null);
        int level = 0;
        System.out.print("At level " + level + " -> ");
        while (!pending.isEmpty()) {
            BinaryTreeNode<T> current = pending.remove();
            if (current == null) {
                System.out.println();
                level++;
                pending.add(null);
                System.out.print("At level " + level + " -> ");
            } else {
                System.out.print(current.getData() + " ");
                if (current.getLeft() != null) {
                    pending.add(current.getLeft());
                }
                if (current.getRight() != null) {
                    pending.add(current.getRight());
                }
            }
        }
    }

    /////NOT COMPLETED
    @Override
    public void printInOrder() {

    }

    /////NOT COMPLETED
    @Override
    public void printPreOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /////NOT COMPLETED
    @Override
    public void printPostOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void printLeafsHelper(BinaryTreeNode<T> root) {
        if (root.getLeft() == null && root.getRight() == null) {
            System.out.print(root.getData() + " ");
            return;
        }
        printLeafsHelper(root.getLeft());
        printLeafsHelper(root.getRight());
    }

    @Override
    public void printLeafs() {
        printLeafsHelper(this.root);
        System.out.println();
    }

    @Override
    public void add(T data) {
        QueueUsingArrayList<BinaryTreeNode<T>> pending = new QueueUsingArrayList<BinaryTreeNode<T>>();
        if (this.root == null) {
            this.root = new BinaryTreeNode<T>(data);
        } else {
            pending.add(root);
            while (!pending.isEmpty()) {
                BinaryTreeNode<T> current = null;
                try {
                    current = pending.remove();
                } catch (Exception ex) {
                    System.out.println("Element not found");
                }
                if (current.getLeft() == null) {
                    current.setLeft(new BinaryTreeNode<T>(data));
                    break;
                } else if (current.getRight() == null) {
                    current.setRight(new BinaryTreeNode<T>(data));
                    break;
                } else if (current.getLeft() != null) {
                    pending.add(current.getLeft());
                } else {
                    pending.add(current.getRight());
                }
            }
        }
        size++;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    
    /////NOT COMPLETED
    
    @Override
    public T remove() throws Exception {
        if(isEmpty()){
            throw new RootEmptyException("Root is empty");
        }
        BinaryTreeNode<T> temp = null;
        QueueUsingArrayList<BinaryTreeNode<T>> pending = new QueueUsingArrayList<BinaryTreeNode<T>>();
        pending.add(this.root);
        while(!pending.isEmpty()){
            if(root.getRight() != null){
                
            }
        }
        return temp.getData();
    }

    @Override
    public void print() throws Exception {
        printLevelWise();
    }

    @Override
    public int size() {
        return size;
    }

}
