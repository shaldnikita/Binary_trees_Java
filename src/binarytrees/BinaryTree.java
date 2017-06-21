/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytrees;

import java.util.List;

/**
 *
 * @author shaldnikita
 */
public interface BinaryTree {
    boolean delete(int value);
    void insert(int value);
    Node find(int value);
    List getInorderTreeAsList();
    List getPostorderTreeAsList();
    List getPreorderTreeAsList();
    void displayTree();
    Node getMinimum();
    Node getMaximum();
}
