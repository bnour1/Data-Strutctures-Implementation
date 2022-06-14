package homework.abstract_data.atividade_2;

import java.util.Scanner;

public class App1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<String> fila = new Queue<String>();
        String pedido; char op;


        do{
            System.out.println("Insiraa opção");
            System.out.println("1 - adicionar pedido");
            System.out.println("2 - registrar atendimento");
            op = in.next().charAt(0);

            switch (op) {
                case '1':
                System.out.println("Informe o pedido");
                pedido = in.nextLine(); pedido = in.nextLine();
                fila.enqueue(pedido);
                System.out.println("Pedido "+fila.head()+" Adicionado a fila");
                break;
                case '2':
                fila.dequeue();
                System.out.println("Proximo pedido é: "+fila.head());
                break;
            }
        }while(op != '0');
    }
    
}
