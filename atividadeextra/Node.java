package ds1.lde.atividadeextra;

public class Node{ 
    Node prox;
    Tarefa info;
    Node Ant;

    

    public Node(Tarefa info) {
        this.info = info;
    }
    
    public Node getProx() {
        return prox;
    }
    public void setProx(Node prox) {
        this.prox = prox;
    }
    public Tarefa getInfo() {
        return info;
    }
    public void setInfo(Tarefa info) {
        this.info = info;
    }
    public Node getAnt() {
        return Ant;
    }
    public void setAnt(Node ant) {
        Ant = ant;
    }

    

}