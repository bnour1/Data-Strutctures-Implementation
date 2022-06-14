package homework.abstract_data.atividade_2;

public class Queue <T> {
    private Node<T> inicio;
    private Node<T> fim;
    public boolean isEmpty() {
        if (this.inicio == null && this.fim == null) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean isFull() {
        return false;
    }
    public T head() {
        return this.inicio.getInfo();
    }
    public void enqueue (T valor) { // inserir no final da fila
        Node<T> novo = new Node (valor);
        if (this.isEmpty() == true) {
            this.inicio = novo;
            this.fim = novo;
        }
        else {
            this.fim.setProx(novo);
            this.fim = novo;
        }   
    }
    public T dequeue () {  // remover o primeiro da fila
        Node<T> aux = this.inicio;
        T valor;
        this.inicio = this.inicio.getProx();
        if (this.inicio == null) {
            this.fim = null;
        }
        valor = aux.getInfo();
        return valor;
    }
}
