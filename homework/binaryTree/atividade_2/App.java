package homework.binaryTree.atividade_2;

import java.util.Scanner;

public class App {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        char op;
        String codigo;

        do{
            menu();
            op = in.next().charAt(0);

            switch(op){
                case '1':
                Cadastro.getInstance().cadastrar();
                break;
                case '2':
                Cadastro.getInstance().exibirProdutos();
                break;
                case '3':
                System.out.println("Informe o codigo do produto");
                codigo = in.next();
                Cadastro.getInstance().alterarPreco(codigo);
                break;
                case '4':
                System.out.println("Informe o codigo do produto");
                codigo = in.next();
                Cadastro.getInstance().alterarEstoque(codigo);
                break;
                case '5':
                System.out.println("Informe o codigo do produto");
                codigo = in.next();
                Cadastro.getInstance().exibirProduto(codigo);
                break;
                default:
                break;
            }
        }while(op != 0);

        System.out.println("Foi bom enquanto durou :)");
    }

    static void menu(){
        System.out.println("******BEM VINDO******");
        System.out.println("\n1- Cadastrar novo produto");
        System.out.println("2- Exibir todos os produtos");
        System.out.println("3- alterar o preço de um produto");
        System.out.println("4- Atualizar estoque de um produto");
        System.out.println("5- Exibir informações completas de um produto");
        System.out.println("Informe a opção deseja");
    }
}
