package ds1.lde.ldeforclass;

public class Node {
    private Node ant;
    private Cliente info;
    private Node prox;

    public Node(Cliente c) {
        this.info = c;
    }

    public void setAnt(Node novoAnt) {
        this.ant = novoAnt;
    }

    public void setProx(Node novoProx) {
        this.prox = novoProx;
    }

    public void setInfo(Cliente valor) {
        this.info = valor;
    }

    public Node getAnt() {
        return this.ant;
    }

    public Node getProx() {
        return this.prox;
    }

    public Cliente getInfo() {
        return this.info;
    }
}