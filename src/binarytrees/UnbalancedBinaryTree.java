/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytrees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author shaldnikita
 */
public class UnbalancedBinaryTree implements BinaryTree {

    Node root;
    private List fullTree = new ArrayList();

    @Override
    public boolean delete(int value) {
        Node current = root, parent = root;
        boolean isLeftChild = true;
        while (current.value != value) {
            parent = current;

            if (value < current.value) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;

            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode, successor = delNode;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    @Override
    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (value < current.value) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public Node find(int value) {
        Node current = root;
        while (current.value != value) {
            if (value < current.value) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }

    @Override
    public List getInorderTreeAsList() {
        List tree;
        getInorderTreeRec(root.leftChild);
        fullTree.add(root.value);
        getInorderTreeRec(root.rightChild);
        tree = fullTree;
        fullTree = new ArrayList();
        return tree;
    }

    private void getInorderTreeRec(Node node) {
        if (node == null) {
            return;
        }
        getInorderTreeRec(node.leftChild);
        fullTree.add(node.value);
        getInorderTreeRec(node.rightChild);
    }

    @Override
    public List getPostorderTreeAsList() {
        List tree;
        getPostorderTreeRec(root.leftChild);
        getPostorderTreeRec(root.rightChild);
        fullTree.add(root.value);
        tree = fullTree;
        fullTree = new ArrayList();
        return tree;
    }

    private void getPostorderTreeRec(Node node) {
        if (node == null) {
            return;
        }
        getPostorderTreeRec(node.leftChild);
        getPostorderTreeRec(node.rightChild);
        fullTree.add(node.value);
    }

    @Override
    public List getPreorderTreeAsList() {
        List tree;
        fullTree.add(root.value);
        getPreorderTreeRec(root.leftChild);
        getPreorderTreeRec(root.rightChild);
        tree = fullTree;
        fullTree = new ArrayList();
        return tree;
    }

    private void getPreorderTreeRec(Node node) {
        if (node == null) {
            return;
        }
        fullTree.add(node.value);
        getPreorderTreeRec(node.leftChild);
        getPreorderTreeRec(node.rightChild);
    }

    @Override
    public Node getMinimum() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    @Override
    public Node getMaximum() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    @Override
    public void displayTree() {
        Stack<Node> globalStack = new Stack();
        globalStack.push(root);
        int nBlanks=32;
        boolean isRowEmpty=false;
        System.out.println("...............................................");
        while(!isRowEmpty){
            Stack<Node> localStack = new Stack();
            isRowEmpty=true;
            for(int i=0;i<nBlanks;i++){
                System.out.print(" ");
            }
            while(!globalStack.isEmpty()){
                Node temp = globalStack.pop();
                if(temp!=null){
                    System.out.print(temp.value);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    
                    if(temp.leftChild!= null || temp.rightChild!=null){
                        isRowEmpty=false;
                    }
                } else{
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int i=0;i<nBlanks*2-2;i++){
                    System.out.print(" ");
                }
            }
            System.out.println("");
            nBlanks/=2;
            while(!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }
        System.out.println("...............................................");
    }

}
