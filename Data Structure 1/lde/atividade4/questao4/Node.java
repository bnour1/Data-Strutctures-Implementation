package atividade4.questao4;

public class Node {
    private Node ant;
    private Pessoa info;
    private Node prox;

    public Node(Pessoa c) {
        this.info = c;
    }

    public void setAnt(Node novoAnt) {
        this.ant = novoAnt;
    }

    public void setProx(Node novoProx) {
        this.prox = novoProx;
    }

    public void setInfo(Pessoa valor) {
        this.info = valor;
    }

    public Node getAnt() {
        return this.ant;
    }

    public Node getProx() {
        return this.prox;
    }

    public Pessoa getInfo() {
        return this.info;
    }
}