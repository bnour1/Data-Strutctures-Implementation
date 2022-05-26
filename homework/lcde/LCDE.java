package homework.lcde;

public class LCDE{

    private Node first;
    private Node last;
    private int size;

    boolean isEmpty(){
        return size == 0 && first == null && last == null;
    }

    public void concatenar(LCDE l2){

        if(this.isEmpty()){
            this.first = l2.first;
        }else{
            this.last.setNext(l2.first);
            l2.first.setPrev(this.last);
            l2.last.setNext(this.first);
            this.first.setPrev(l2.last);
            this.last = l2.last;
            this.size = this.size+l2.size;
        }
        this.cicle();
        l2.clear();
    }

    public LCDE dividir(){
        LCDE l2 = new LCDE();
        Node aux = this.first;

        int i = 0;
        for(i = 1; i < (this.size / 2); i++){
            aux = aux.getNext();
        }

        l2.first = aux.getNext();
        l2.last = this.last;
        l2.size = this.size - i;
        this.last = aux;
        this.size = this.size / 2;

        l2.cicle();
        this.cicle();
        this.clear();

        return l2;  
        
    }
    

    public void add(Integer numb){
        Node newIntNode = new Node(numb);

        if(isEmpty()){
            this.first = newIntNode;
            this.last = newIntNode;
            size++;
            cicle();
        }else if(numb < this.first.getInfo()){
            newIntNode.setNext(this.first);
            this.first.setPrev(newIntNode);
            this.first = newIntNode;
            size++;
            cicle();
        }else if(numb> this.last.getInfo()){
            this.last.setNext(newIntNode);
            newIntNode.setPrev(this.last);
            this.last = newIntNode;
            size++;
            cicle();
        }else{ 
            Node aux = this.first;
            do{
                aux = aux.getNext();
            }while(aux.getInfo() < numb && aux != this.first);
            aux = aux.getPrev();
            newIntNode.setPrev(aux);
            newIntNode.setNext(aux.getNext());
            aux.getNext().setPrev(newIntNode);
            aux.setNext(newIntNode);
            size++;
        }

    }

    void clear(){
        this.first = null;
        this.last = null;
        size = 0;
    }

    void cicle(){
        this.first.setPrev(this.last);
        this.last.setNext(this.first);
    }

    public void showCatalog(){
        Node aux = this.first;
        for(int i = 0; i < this.size; i++){
            System.out.println(aux.getInfo());
            aux = aux.getNext();
        }  
    }
}