package temptreino;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        LDE teste = new LDE();
        Scanner input = new Scanner(System.in);
        int op;

        do{
            menu();
            System.out.println("Opcao?");
            op = input.nextInt();
            switch(op){
                case 1:
                System.out.println("ID");
                int id = input.nextInt();
                System.out.println("tipo");
                String type = input.next();

                Objeto novo = new Objeto(id, type);
                teste.add(novo);
                break;
                case 2:
                teste.showList();
                break;
                default:
                break;
            }
        }while(op != 0);

        
        
    }

    static void menu(){
        System.out.println("Op 1 Adicionar (ORD)");
        System.out.println("Op 2 Mostrar lista");
    }
    
}
