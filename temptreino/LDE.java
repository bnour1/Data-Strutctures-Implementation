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

    public void add(Objeto o) {
        Node novo = new Node(o);

        if (isEmpty()) {
            this.primeiro = novo;
            this.ultimo = novo;
            qtd++;
        } else if (this.primeiro.getInfo().compareTo(o) > 0) {
            novo.setProx(this.primeiro);
            this.primeiro.setAnt(novo);
            this.primeiro = novo;
            qtd++;
        } else if (this.ultimo.getInfo().compareTo(o) < 0) {
            novo.setAnt(this.ultimo);
            this.ultimo.setProx(novo);
            this.ultimo = novo;
            qtd++;
        } else {
            Node aux = this.primeiro;
            while (aux.getProx().getInfo().compareTo(o) < 0) {
                aux = aux.getProx();
            }
            novo.setAnt(aux);
            novo.setProx(aux.getProx());
            aux.getProx().setAnt(novo);
            aux.setProx(novo);
            qtd++;
        }
    }

    public void remove(Objeto o){

        if(isEmpty()){
            System.out.println("Elemento ausente da lista");
        }else if(this.primeiro.getInfo().compareTo(o) == 0){
            Node aux = this.primeiro.getProx();

            aux.setAnt(null);
            this.primeiro = aux;
            qtd--;
        }else if(this.ultimo.getInfo().compareTo(o) == 0){
            Node aux = this.ultimo.getAnt();

            aux.setProx(null);
            this.ultimo = aux;
            qtd--;
        }else{
            Node aux = this.primeiro;

            while(aux.getProx().getInfo().compareTo(o) != 0){
                aux = aux.getProx();
            }
            Node auxprox = aux.getProx();
            auxprox.getProx().setAnt(aux);
            aux.setProx(auxprox.getProx());

            qtd--;
        }

    }

    public Node getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Node primeiro) {
        this.primeiro = primeiro;
    }

    public LDE intersecao(LDE l1, LDE l2){
        LDE result = new LDE();
        Node aux = l1.getPrimeiro();
        Node aux1 = l2.getPrimeiro();

        while(aux != null){
            if(aux.getInfo().compareTo(aux1.getInfo()) == 0){
                System.out.println("t4");
                result.add(aux.getInfo());
                aux = aux.getProx();
                aux1 = l2.getPrimeiro();
            }else if(aux.getInfo().compareTo(aux1.getInfo()) > 0){
                System.out.println("t2");
                aux1=aux1.getProx();
            }else if(aux.getInfo().compareTo(aux1.getInfo()) < 0){
                System.out.println("t3");
                aux = aux.getProx();
                aux1 = l2.getPrimeiro();
            }
        }
        return result;
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