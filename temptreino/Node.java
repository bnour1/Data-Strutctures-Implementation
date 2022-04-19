package temptreino;

public class Node{ 
    Node prox;
    Objeto info;
    Node Ant;

    

    public Node(Objeto info) {
        this.info = info;
    }
    
    public Node getProx() {
        return prox;
    }
    public void setProx(Node prox) {
        this.prox = prox;
    }
    public Objeto getInfo() {
        return info;
    }
    public void setInfo(Objeto info) {
        this.info = info;
    }
    public Node getAnt() {
        return Ant;
    }
    public void setAnt(Node ant) {
        Ant = ant;
    }

    

}