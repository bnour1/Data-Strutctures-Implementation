package homework.abstract_data.atividade_1.my_stack;

public class MyStack <T> {
    private Node<T> topo; // primeiro nó ou início da LSE
    
    public boolean isEmpty() {
        if (this.topo == null) {
            return true;
        }
        else {
            return false;
        }
    }
    public void push (T valor) { // empilhar = inserir no início
        Node<T> novo = new Node<T>(valor);
        if (this.isEmpty() == true) {
            topo = novo;
        }
        else {
            novo.setProx(this.topo);
            topo = novo;
        }
    }
    public T pop () { // desempilhar = remover o primeiro
        T valor;
        Node<T> aux;
        aux = this.topo;
        this.topo = this.topo.getProx();
        valor = aux.getInfo();
        return valor;
    }
    public T top () {
        return this.topo.getInfo();
    }
    public boolean isFull() {
        return false;        
    }
}
