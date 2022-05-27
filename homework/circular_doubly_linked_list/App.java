package homework.circular_doubly_linked_list;

import java.util.Scanner;

public class App {




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LCDE list1 = new LCDE();
        LCDE list2 = new LCDE();
        int numb;
        char op;
        String bookTitle, author, bookDescription;

        do{
            menu();
            op = in.next().charAt(0);
            Character.toLowerCase(op);

            switch(op){
                case '1':
                System.out.println("Insira na lista 1");
                numb = in.nextInt();
                list1.add(numb);
                break;
                case '2':
                System.out.println("Insira na lista 2:");
                numb = in.nextInt();
                list2.add(numb);
                break;
                case '3':
                list1.showCatalog();
                System.out.println("---------------");
                list2.showCatalog();
                break;
                case '4':
                list1.concatenar(list2);
                break;
                case '5':
                list2 = list1.dividir();
                break;
                default:
                    
                break;
            }
        }while (op != '0');
    }

    static void menu(){
        System.out.println("/n1 - Inser number in the first list");
        System.out.println("2 - Insert number in the second list");
        System.out.println("3 - show list1");
        System.out.println("4 - concatenar");
        System.out.println("5 - dividir list1");
        System.out.println("Press 0 to leave :c");
    }
    
}
