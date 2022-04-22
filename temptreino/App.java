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
                case 3:
                System.out.println("Insira o id do objeto");
                int idd = input.nextInt();
                Objeto rem = new Objeto(idd, "remover");
                teste.remove(rem);
                break;
                case 4:
                LDE lista1 = new LDE();
                LDE lista2 = new LDE();
                int umid; String umtype;
                
                Objeto ob = new Objeto(13, "13");
                lista1.add(ob);
                ob = new Objeto(12, "12");
                lista2.add(ob);
                ob = new Objeto(21, "21");
                lista1.add(ob);
                lista2.add(ob);
                ob = new Objeto(27, "27");
                lista1.add(ob);
                ob = new Objeto(26,"26");
                lista2.add(ob);
                ob = new Objeto(48,"48");
                lista1.add(ob);
                lista2.add(ob);
                ob= new Objeto(63, "63");
                lista1.add(ob);
                lista2.add(ob);
                ob = new Objeto(95, "95");
                lista1.add(ob);
                lista2.add(ob);
                LDE lista3 = new LDE();
                lista3 = teste.intersecao(lista1,lista2);
                lista1.showList();
                lista2.showList();
                lista3.showList();
                break;
                default:
                break;
            }
        }while(op != 0);

        
        
    }

    static void menu(){
        System.out.println("Op 1 Adicionar (ORD)");
        System.out.println("Op 2 Mostrar lista");
        System.out.println("Op 3 remover objeto");
        System.out.println("Op 4 intersecao");
    }
    
}
