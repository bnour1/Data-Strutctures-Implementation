package ds1.lde.atividadeextra;
import java.util.Scanner;


/* Atividade INDIVIDUAL de listas
   Duplamente encadeadas */

public class App {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LDE teste = new LDE();
        Tarefa task;
        String desc;
        char op;
        int prioridade;

        do{
            menu();
            System.out.println("Opcao?");
            op = input.next().charAt(0);
            switch(op){
                case '1':
                    System.out.println("Insira a prioridade da tarefa");
                    prioridade = input.nextInt();
                    while(prioridade > 10 || prioridade < 1)
                    {
                        System.out.println("A prioridade deve estar entre 1-10 \n Insira a prioridade da tarefa");
                        prioridade = input.nextInt();
                    }
                    System.out.println("Insira a Descricao");
                    desc = input.nextLine(); desc = input.nextLine();
                    task = new Tarefa(prioridade, desc);
                    teste.add(task);
                break;
                case '2': 
                    System.out.println("Informe a descrição da tarefa");
                    desc = input.nextLine(); desc = input.nextLine();
                    System.out.println(teste.tasksUntil(desc)+"\n");
                break;
                case '3':
                    teste.execTask();
                break;
                case '4':
                    System.out.println("Insira a tarefa a cancelar");
                    desc = input.nextLine(); desc = input.nextLine();
                teste.cancelTask(desc);
                break;
                case '5':
                    System.out.println("Insira a prioridade:");
                    prioridade = input.nextInt();
                    teste.showSamePriorityTasks(prioridade);
                break;
                case '6':
                    teste.showTasksDetailed();
                break;
                case '7':
                    System.out.println("Informe a descrição da tarefa:");
                    desc = input.nextLine(); desc = input.nextLine();
                    System.out.println("Insira a nova prioridade da tarefa");
                    prioridade = input.nextInt();
                    teste.changePriority(desc, prioridade);
                break;
                default:
                    System.out.println("Opção invalida!");
                break;
            }
        }while(op != '0');   
    }

    static void menu(){
        System.out.println("\n║ 1 - Adicionar (ORD)"); // item (a)
        System.out.println("║ 2 - Verificar fila até uma tarefa"); // item (b)
        System.out.println("║ 3 - Executar tarefa na vez."); // item (c)
        System.out.println("║ 4 - Cancelar tarefa"); // item (d)
        System.out.println("║ 5 - Exibir tarefas em uma prioridade"); // item (e)
        System.out.println("║ 6 - Exibir tarefas"); // item (f)
        System.out.println("║ 7 - Alterar prioridade de uma tarefa."); // item (g)
        System.out.println("║ 0 - Sair :c");
    }
    
}
