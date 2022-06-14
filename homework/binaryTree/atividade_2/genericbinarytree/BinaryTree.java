package homework.binaryTree.atividade_2.genericbinarytree;

import java.util.*;

public class BinaryTree<T extends Comparable<T>> {

    private TreeNode<T> raiz;

    public boolean isEmpty() {
        if (this.raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public T find(T value) {
        if (this.isEmpty() == true) {
            return null;
        } else {
            return raiz.findNode(value);
        }
    }

    public void insert(T value) {
        if (this.isEmpty() == true) { // inserção na árvore vazia
            this.raiz = new TreeNode<T>(value);
        } else {
            raiz.insertNode(value);
        }
    }

    public void passeioPorNivel() {
        Queue<TreeNode<T>> fila = new LinkedList<TreeNode<T>>();
        TreeNode<T> aux;
        if (this.isEmpty() == false) {
            fila = new LinkedList<TreeNode<T>>();
            fila.add(raiz);
            
            while (fila.isEmpty() == false) {
                aux = fila.poll();
                if (aux.getEsq() != null) {
                    fila.add(aux.getEsq());
                }
                if (aux.getDir() != null) {
                    fila.add(aux.getDir());
                }
                System.out.print(aux.getInfo() + " ");
            }
            System.out.println();
        } else {
            System.out.println("Árvore vazia");
        }
    }

    public void emOrdem() {
        if (this.isEmpty() == true) {
            System.out.println("Árvore vazia");
        } else {
            percorrerEmOrdem(raiz);
        }
    }

    private void percorrerEmOrdem(TreeNode<T> r) {
        if (r != null) {
            percorrerEmOrdem(r.getEsq());
            System.out.println(r.getInfo() + " ");
            percorrerEmOrdem(r.getDir());
        }
    }

}
