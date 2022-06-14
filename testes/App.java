package testes;

import testes.genericbinarytree.*;

public class App {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<Integer>();

        
        tree.insert(30);
        tree.insert(12);
        tree.insert(40);
        tree.insert(60);
        tree.insert(200);
        tree.insert(130);
        tree.insert(400);
        tree.insert(99);
        tree.insert(17);
        tree.insert(55);
        tree.insert(120);


        System.out.println(tree.maiorValor());
    }
    
}
