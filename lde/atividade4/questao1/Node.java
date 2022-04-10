package lde.atividade4.questao1;

public class Node {
    private Node ant;
    private User info;
    private Node prox;

    public Node(User c) {
        this.info = c;
    }

    public void setAnt(Node novoAnt) {
        this.ant = novoAnt;
    }

    public void setProx(Node novoProx) {
        this.prox = novoProx;
    }

    public void setInfo(User valor) {
        this.info = valor;
    }

    public Node getAnt() {
        return this.ant;
    }

    public Node getProx() {
        return this.prox;
    }

    public User getInfo() {
        return this.info;
    }
}