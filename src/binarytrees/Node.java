/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytrees;

/**
 *
 * @author shaldnikita
 */
public class Node {

    Node leftChild, rightChild;
    int value;
    
    public Node(int value){
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node`s value: " + value;
    }

}
