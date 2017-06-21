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
public class Main {
    public static void main(String[] args) {
        UnbalancedBinaryTree bt = new UnbalancedBinaryTree();
        bt.insert(10);
        bt.insert(5);
        bt.insert(3);
        bt.insert(7);
        bt.displayTree();
        bt.delete(5);
        bt.displayTree();
    }
}
