package homework.abstract_data.avaliacao_1.questao_2.deque_generico;

class Node <T> {
    private T info;
    private Node <T> prox;
    
    Node (T valor) {
        this.info = valor;
    }

    T getInfo() {
        return this.info;
    }
    
    void setInfo (T valor) {
        this.info = valor;
    }
    
    Node<T> getProx() {
        return this.prox;
    }
    
    void setProx(Node<T> novoProx) {
        this.prox = novoProx;
    }
}
