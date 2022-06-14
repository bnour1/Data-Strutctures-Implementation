package homework.abstract_data.atividade_2;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<String> fila = new Queue<String>();

        String projeto; char op;


        do{
            System.out.println("Insiraa opção");
            System.out.println("1 - adicionar projeto à fila");
            System.out.println("2 - marcar projeto como avaliado");
            op = in.next().charAt(0);

            switch (op) {
                case '1':
                System.out.println("Informe o projeto");
                projeto = in.nextLine(); projeto = in.nextLine();
                fila.enqueue(projeto);
                System.out.println("Projeto "+fila.head()+" Adicionado a fila");
                break;
                case '2':
                System.out.println("Projeto "+fila.head()+" marcado como concluido");
                fila.dequeue();
                break;
            }
        }while(op != '0');
    }
}
