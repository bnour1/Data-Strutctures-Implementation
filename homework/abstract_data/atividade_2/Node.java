package homework.abstract_data.atividade_2;

class Node<T> { // classe com visibilidade de pacote
    private T info;
    private Node<T> prox;
    
    Node (T valor) {
        this.info = valor;
    }
    T getInfo() {
        return this.info;
    }
    void setInfo(T valor){
        this.info = valor;
    }
    Node<T> getProx() {
        return this.prox;
    }
    void setProx(Node<T> novoProx) {
        this.prox = novoProx;
    }
}