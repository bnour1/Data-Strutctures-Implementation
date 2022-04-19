package ds1.lde.ldeforclass;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        LDE clientList1 = new LDE();
        LDE clientList2 = new LDE();
        LDE clientList3 = new LDE();
        Scanner in = new Scanner(System.in);
        char op;
        Cliente c;
        do {
            exibirMenu();
            op = in.next().charAt(0);

            switch (op) {
                case '1':
                    clientList1.exibirLista();
                    clientList2.exibirLista();
                    clientList3.exibirLista();
                    break;
                case '2':
                    c = preencher();
                    clientList1.inserirOrdenado(c);
                    break;
                case '3':
                    c = preencher();
                    clientList2.inserirOrdenado(c);
                    break;
                case '4':
                    clientList3 = clientList1.diferenca(clientList2);
                    break;
                case '5':

                    break;
                case '6':
                    c = preencher();
                    clientList1.remocaoOC(c);

                    break;
                case '7':
                    c = preencher();
                    clientList1.inserirOrdenado(c);
                    break;
                case '8':
                    c = preencher();
                    clientList1.inserirOrdenadoDecrescente(c);
                case '9':
                    c = preencher();
                    clientList1.remocaoOC(c);
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
        System.out.println("2 - Inserir na lista 1");
        System.out.println("3 - Inserir na lista 2");
        System.out.println("4 - Criar lista com interceções");
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
            cpf = input.next();
            System.out.println("NOME : ");
            nome = input.next();
            System.out.println("FONE :");
            fone = input.next();
            System.out.println("EMAIL :");
            email = input.nextLine();
            email = input.nextLine();
            return new Cliente(cpf, nome, fone, email);
        }

    }
}