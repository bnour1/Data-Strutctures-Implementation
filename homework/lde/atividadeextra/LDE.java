package homework.lde.atividadeextra;

public class LDE {

    private Node primeiro;
    private Node ultimo;
    private int qtd;

    public boolean isEmpty() {
        if (this.qtd == 0 && this.primeiro == null && this.ultimo == null) {
            return true;
        } else {
            return false;
        }
    }

    public void cancelTask(String desc){
        if(isEmpty())
        {
            System.out.println("Não há tarefas para cancelar");
            return;
        }
        else if(this.primeiro.getInfo().getDescricao().equals(desc))
        {
            this.primeiro = this.primeiro.getProx();
            qtd--;
        }
        else if (this.ultimo.getInfo().getDescricao().equals(desc))
        {
            this.ultimo = this.ultimo.getAnt();
            qtd--;
        }
        else
        {
            Node toCancel = searchNode(desc);
            if(toCancel == null)
            {
                System.out.println("Tarefa não encontrada");
                return;
            }
            else
            {
                toCancel.getProx().setAnt(toCancel.getAnt());
                toCancel.getAnt().setProx(toCancel.getProx());
                qtd--;
            }
        }
        System.out.println("Tarefa cancelada.");
    }

    public Node searchNode(String desc){
        Node aux = this.primeiro;
        while(aux != null){
            if(aux.getInfo().getDescricao().equals(desc)){
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    public String tasksUntil(String desc) {

            Node aux = this.primeiro;
            int count = 0;
            if(isEmpty())
            {
                return "Não existem tarefas na fila";
            }
            else if(this.primeiro.getInfo().getDescricao().equals(desc))
            {
                count++;
                return "Está tarefa é a proxima na lista";
            }
            else if(this.ultimo.getInfo().getDescricao().equals(desc))
            {
                return "Restam "+(this.qtd-1)+" tarefas até a tarefa inserida";
            }
            else
            {
                while(aux != null)
                    {
                        if(desc.equals(aux.getInfo().getDescricao()))
                        {
                        return "Restam "+count+" tarefas até a tarefa inserida";
                        }
                        else
                        {
                        aux = aux.getProx();
                        count++;
                        }
                    } 
                return "Tarefa não encontrada";
            }
        
        

    }

    private void cleanList() {
        this.primeiro = null;
        this.ultimo = null;
        this.qtd = 0;
    }

    public void execTask() {
        if (isEmpty()) {
            System.out.println("Não existem tarefas para serem executadas");
        } else if (qtd == 1) {
            cleanList();
        } else {
            System.out.println("Tarefa" + this.primeiro.getInfo().getDescricao() + " sera marcada como concluida");
            this.primeiro = this.primeiro.getProx();
            qtd--;
            System.out.println("Feito. :)");
        }
    }

    private boolean alreadyHas(Tarefa t) {
        Node aux = this.primeiro;
        while (aux != null) {
            if (aux.getInfo().getDescricao().equals(t.getDescricao())) {
                return true;
            }
            aux = aux.getProx();
        }
        return false;
    }

    public void add(Tarefa o) {
        Node novo = new Node(o);

        if (isEmpty()) {
            this.primeiro = novo;
            this.ultimo = novo;
            qtd++;
        } else if (alreadyHas(o)) {
            System.out.println("Uma tarefa com uma descriçã idêntica já foi inserida.\n Nada feito.");
        } else if (this.primeiro.getInfo().compareTo(o) < 0) {
            novo.setProx(this.primeiro);
            this.primeiro.setAnt(novo);
            this.primeiro = novo;
            qtd++;
        } else if (this.ultimo.getInfo().compareTo(o) >= 0) {
            novo.setAnt(this.ultimo);
            this.ultimo.setProx(novo);
            this.ultimo = novo;
            qtd++;
        } else {
            Node aux = this.primeiro;
            while (aux.getProx().getInfo().compareTo(o) >= 0) {
                aux = aux.getProx();
            }
            novo.setAnt(aux);
            novo.setProx(aux.getProx());
            aux.getProx().setAnt(novo);
            aux.setProx(novo);
            qtd++;
        }
    }

    public void showTasks() {
        if (isEmpty())
        {
            System.out.println("Lista vazia po");
        }
        else
        {
            Node aux = this.primeiro;
        while (aux != null)
        {
            System.out.println("> "+aux.getInfo().getDescricao());
            aux = aux.getProx();
        }
        }
    }

    public void showSamePriorityTasks(int p){
        if(isEmpty())
        {
            System.out.println("Não existes tarefas na fila.");
        }
        else
        {
            LDE tasks = new LDE(); Node aux;
            if(this.primeiro.getInfo().getPrioridade() == p)
            {
                aux = this.primeiro;
                while(aux != null){
                    if(aux.getInfo().getPrioridade() == p)
                    {
                        tasks.add(aux.getInfo());
                    }
                    else if(aux.getInfo().getPrioridade() != p)
                    {
                        break;
                    }
                    aux = aux.getProx();
                }
            }
            // Otimização opicional para caso a prioriodade esteja no final
            /* 
            else if(this.ultimo.getInfo().getPrioridade() == p)
            {
                aux = this.ultimo;
                while(aux != null){
                    if(aux.getInfo().getPrioridade() == p)
                    {
                        tasks.addLast(aux.getInfo());
                    }
                    else if(aux.getInfo().getPrioridade() != p)
                    {
                        break;
                    }
                    aux = aux.getAnt();
                }
            }
            */
            else
            {
                aux = this.primeiro;
                while(aux != null){
                   if(aux.getInfo().getPrioridade() == p)
                   {
                       tasks.add(aux.getInfo());
                   }
                   else if(aux.getInfo().getPrioridade() < p)
                   {
                       break;
                   } 
                   aux = aux.getProx();
                }
            }
            System.out.println("Foram encontradas "+tasks.qtd+" tarefas:");
            tasks.showTasks();
        }
        
    }

    public void showTasksDetailed(){
        if(isEmpty())
        {
            System.out.println("Não há tarefas.");
        }
        else
        {
            Node aux = this.primeiro;
            while(aux != null){
                System.out.println("> "+aux.getInfo());
                aux = aux.getProx();
            }
        }
    }
    
    public void changePriority(String desc, int p){
        Node temp = searchNode(desc);

        if(temp == null)
        {
            System.out.println("Esta tarefa não está na lista");
        }
        else
        {
            Tarefa toChange = new Tarefa(p, temp.getInfo().getDescricao());
            cancelTask(desc);
            this.add(toChange);
            System.out.println("A prioridade da tarefa foi atualizada.");
        }

    }
}
