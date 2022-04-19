package temptreino;

public class LDE {

    private Node primeiro;
    private Node ultimo;
    private int qtd;

    public boolean isEmpty() {
        if (this.qtd == 0 && this.primeiro == null && this.ultimo == null) {
            return true;
        } else {
            return false;
        }
    }

    public void add(Objeto o){
        Node novo = new Node(o);

        if(isEmpty()){
            this.primeiro = novo;
            this.ultimo = novo;
            qtd++;
        }else if(this.primeiro.getInfo().compareTo(o) > 0){
            novo.setProx(this.primeiro);
            this.primeiro.setAnt(novo);
            this.primeiro = novo;
            qtd++;
        }else if(this.ultimo.getInfo().compareTo(o) < 0){
            novo.setAnt(this.ultimo);
            this.ultimo.setProx(novo);
            this.ultimo = novo;
            qtd++;         
        }else{
            Node aux = this.primeiro;
            while(aux.getProx().getInfo().compareTo(o) < 0){
                aux = aux.getProx();
            }
            novo.setAnt(aux);
            novo.setProx(aux.getProx());
            aux.getProx().setAnt(novo);
            aux.setProx(novo);
            qtd++;
        }
    }

    public void showList(){
        if(isEmpty()){
            System.out.println("Lista vazia po");
        }

        Node aux = this.primeiro;
        while(aux != null){
            System.out.println(aux.getInfo());
            aux = aux.getProx();
        }
    }

}