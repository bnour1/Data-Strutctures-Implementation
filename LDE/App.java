package LDE;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LDE Clientlist = new LDE();
        Scanner in = new Scanner(System.in);
        char op;
        Cliente c;
        do {
            exibirMenu();
            op = in.next().charAt(0);

            switch (op) {
                case '1':
                    Clientlist.exibirLista();
                    break;
                case '2':
                    c = preencher();
                    Clientlist.inserirInicio(c);
                    break;
                case '3':
                    c = preencher();
                    Clientlist.inserirFinal(c);
                    break;
                case '4':
                    Clientlist.removerInicio();
                    break;
                case '5':
                    Clientlist.removerFinal();
                    break;
                case '6':
                    Clientlist.exibirContrario();
                    break;
                case '0':
                    System.out.println("Bye bye!");
                    break;
                default:
                    System.out.println("Opção inválida, informe a opção novamente");
            }

        } while (op != '0');

    }

    public static void exibirMenu() {
        System.out.println("Opções");
        System.out.println("1 - Exibir todos os clientes cadastrados");
        System.out.println("2 - Inserir cliente no início");
        System.out.println("3 - Inserir cliente no final");
        System.out.println("4 - Remover cliente do inicio");
        System.out.println("5 - Remover Cleinte do final");
        System.out.println("6 - Exibir lista de trás pra frente");
        System.out.println("0 - Sair do programa");
        System.out.print("Informe a opção desejada: ");
    }

    public static Cliente preencher() {
        String cpf, nome, fone, email;
        int op;
        Scanner input = new Scanner(System.in);

        System.out.println("Para inserção rapida digite 1, para inserção normal digite 2");
        op = input.nextInt();

        if (op == 1) {
            System.out.println("----Insira os dados do novo Cliente----");
            System.out.println("CPF :");
            cpf = input.nextLine();
            cpf = input.nextLine();
            return new Cliente(cpf);
        } else {
            System.out.println("----Insira os dados do novo Cliente----");
            System.out.println("CPF : ");
            cpf = input.nextLine();
            cpf = input.nextLine();
            System.out.println("NOME : ");
            nome = input.nextLine();
            System.out.println("FONE :");
            fone = input.nextLine();
            System.out.println("EMAIL :");
            email = input.nextLine();
            return new Cliente(cpf, nome, fone, email);
        }

    }
}