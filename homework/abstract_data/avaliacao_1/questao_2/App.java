package homework.abstract_data.avaliacao_1.questao_2;
import java.util.Scanner;

import homework.abstract_data.avaliacao_1.questao_2.deque_generico.Deque;
public class App {
    
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Deque<Integer> dequeInteiros = new Deque<Integer>();
        int num;
        char op;


        do{
            Menu();
            op = in.next().charAt(0);
            switch(op){
                case '1':
                System.out.println("Qual numero deseja interir?");
                num = in.nextInt();
                dequeInteiros.push(num);
                break;
                case '2':
                if(dequeInteiros.isEmpty()){
                    System.out.println("Deque vazio.");
                }else{
                    System.out.println("Elemento "+dequeInteiros.pop()+" foi removido :)");
                }
                break;
                case '3':
                System.out.println("Qual numero deseja inserir");
                num = in.nextInt();
                dequeInteiros.inject(num);
                break;
                case '4':
                if(dequeInteiros.isEmpty()){
                    System.out.println("Não tem nada pra remover");
                }else{
                    System.out.println("Elemento "+dequeInteiros.Eject()+" foi removido :)");
                }
                break;
                case '5':
                if(dequeInteiros.isEmpty()){
                    System.out.println("E Deque está vazio");
                }else{
                    System.out.println("E deque contém elementos");
                }
                break;
                case '6':
                if(dequeInteiros.isFull()){
                    System.out.println("E deque está cheio");
                }else{
                    System.out.println("E deque não está cheio");
                }
                break;
                default:
                System.out.println("Nao tem essa opção man");
                break;
            }
        }while(op != 0);
    }

    static void Menu(){
        System.out.println("\nTESTE DA DEQUE");
        System.out.println("1 - Inserir numero no incio");
        System.out.println("2 - Remove e retorna o primeiro elemento");
        System.out.println("3 - Inserir numero no final");
        System.out.println("4 - Remove e retorna o ultimo elemento");
        System.out.println("5 - Checar se está vazia");
        System.out.println("6 - Checar se está cheia");
    }
}
