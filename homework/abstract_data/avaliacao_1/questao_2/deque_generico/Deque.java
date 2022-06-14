package homework.abstract_data.avaliacao_1.questao_2.deque_generico;

public class Deque<T> {
    private Node<T> inicio;
    
    public boolean isEmpty() {
        if (this.inicio == null) {
            return true;
        }
        else {
            return false;
        }
    }
    public void push (T valor) {
        Node<T> novo = new Node<T>(valor);
        if (this.isEmpty() == true) {
            inicio = novo;
        }
        else {
            novo.setProx(this.inicio);
            inicio = novo;
        }
    }

    public void inject(T valor){
        Node<T> novo = new Node<T>(valor);
        if(this.isEmpty()){
            inicio = novo;
        }else{
            Node<T> aux = this.inicio;
        while(aux.getProx() != null){
            aux = aux.getProx();
        }
        aux.setProx(novo);
        }
    }

    public T Eject(){
        T valor;
        Node<T> aux = this.inicio;
        if(this.inicio.getProx() == null){
            valor = pop();
        }else{
            while(aux.getProx().getProx() != null){
                aux = aux.getProx();
            }
            valor = aux.getProx().getInfo();
            aux.setProx(null); 
        }
        return valor; 
    }

    public T pop () {
        T valor;
        Node<T> aux = this.inicio;
        this.inicio = this.inicio.getProx();
        valor = aux.getInfo();
        return valor;
    }

    public boolean isFull() {
        return false;        
    }
}
