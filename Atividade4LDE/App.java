package Atividade4LDE;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LDE userList1 = new LDE();
        LDE userList2 = new LDE();
        LDE userList3 = new LDE();
        Scanner in = new Scanner(System.in);
        char op;
        do {
            exibirMenu();
            op = in.next().charAt(0);

            switch (op) {
                case '1':
                    userList1.exibirLista();
                    userList2.exibirLista();
                    userList3.exibirLista();
                    break;
                case '2':
                    newUserUI(userList1);
                    break;
                case '3':
                    newUserUI(userList2);
                    break;
                case '4':
                    userList3 = userList1.intersection(userList2);
                    break;
                case '5':
                    userList3 = userList1.uniao(userList2);
                    break;
                case '6':
                    userList3 = userList1.diferenca(userList2);
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
        System.out.println("1 - Exibir todos os useres cadastrados");
        System.out.println("2 - Inserir na lista 1");
        System.out.println("3 - Inserir na lista 2");
        System.out.println("4 - Criar lista com interceções");
        System.out.println("5 - Criar lista com uniao");
        System.out.println("6 - Criar lista com Diferenca");
        System.out.println("0 - Sair do programa");
        System.out.print("Informe a opção desejada: ");
    }

    public static void newUserUI(LDE lista) {
        String idInput;
        Scanner input = new Scanner(System.in);

        System.out.println("----Insira os dados do novo usere----");
        System.out.println("CPF :");
        idInput = input.nextLine();
        User newUser = new User(idInput);
        lista.inserirOrdenadoSR(newUser);

    }
}