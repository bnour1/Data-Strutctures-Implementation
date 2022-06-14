package homework.binaryTree.atividade_2;

import java.util.Scanner;

import homework.binaryTree.atividade_2.genericbinarytree.BinaryTree;

public class Cadastro {
    private BinaryTree<Produto> produtos;
    private static Cadastro instance;
    private static Scanner in;

    public static Cadastro getInstance() {
        if (instance == null) {
            instance = new Cadastro();
        }
        return instance;
    }

    public Cadastro() {
        this.produtos = new BinaryTree<Produto>();
        in = new Scanner(System.in);
    }

    public void cadastrar() {
        String codigo, descicao;
        double preco;
        int estoque;

        System.out.println("Informe o codigo do produto");
        codigo = in.next();
        System.out.println("Informe a descicao do produto");
        descicao = in.nextLine(); descicao = in.nextLine();
        System.out.println("Informe o preco do produto");
        preco = in.nextDouble();
        System.out.println("Informe o estoque inciial do produto");
        estoque = in.nextInt();

        Produto novoProduto = new Produto(codigo,descicao,preco,estoque);
        produtos.insert(novoProduto);
    }

    public void exibirProdutos(){
        produtos.emOrdem();
    }

    public Produto procurarProduto(String codigo){
        Produto p = new Produto(codigo);
        return produtos.find(p);
    }

    public void alterarPreco(String codigo){
        Produto p = this.procurarProduto(codigo);
        double preco;
        if(p != null){
            System.out.println("Informe o novo preco para o produto");
            preco = in.nextDouble();
            p.setPreco(preco);
        }else{
            System.out.println("Produto não encontrado");
        }
    }

    public void alterarEstoque(String codigo){
        Produto p = this.procurarProduto(codigo);
        int estoque;
        if(p != null){
            System.out.println("Informe o novo estoque do produto");
            estoque = in.nextInt();
            p.setInventory(estoque);
        }else{
            System.out.println("Produto não encontrado");
        }
    }

    public void exibirProduto(String codigo){
        Produto p = this.procurarProduto(codigo);
        if(p != null){
            System.out.println(p);
        }else{
            System.out.println("Produto não encontrado");
        }
    }

}
