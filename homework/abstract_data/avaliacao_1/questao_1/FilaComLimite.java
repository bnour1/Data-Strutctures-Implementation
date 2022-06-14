package homework.abstract_data.avaliacao_1.questao_1;

public class FilaComLimite <T> {
    private Node<T> inicio;
    private Node<T> fim;
    private int slots;

    public FilaComLimite(int limite){
        this.slots = limite;
    }

    public boolean isEmpty() {
        if (this.inicio == null && this.fim == null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean isFull() {
        return this.slots == 0;
    }

    public T head() {
        return this.inicio.getInfo();
    }
    public void enqueue (T valor) { // inserir no final da fila
        Node<T> novo = new Node<T>(valor);
        if (this.isEmpty() == true) {
            this.inicio = novo;
            this.fim = novo;
        }
        else {
            this.fim.setProx(novo);
            this.fim = novo;
        }
        this.slots--;   
    }
    public T dequeue () {  // remover o primeiro da fila
        Node<T> aux = this.inicio;
        T valor;
        this.inicio = this.inicio.getProx();
        if (this.inicio == null) {
            this.fim = null;
        }
        valor = aux.getInfo();
        this.slots++;
        return valor;
    }
}
