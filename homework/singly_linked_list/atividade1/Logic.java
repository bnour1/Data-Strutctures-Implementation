
package homework.singly_linked_list.atividade1;

public class Logic{

    private Node first;
    private Node last;
    private int size;

    boolean isEmpty(){
        return size == 0 && first == null && last == null;
    }

    public boolean inCatalog(Book b){
        Node aux = this.first;

        if(isEmpty()){
            return false;
        }

        do{
            if(b.getTitle().equals(aux.getInfo().getTitle())){
                return true;
            }
            aux = aux.getNext();
        }while(aux != this.first);
        
        return false;
    }

    public void addBook(Book newBook){
        Node newBookNode = new Node(newBook);

        if(isEmpty()){
            this.first = newBookNode;
            this.last = newBookNode;
            size++;
            cicle();
        }else if(inCatalog(newBook)){
            System.out.println("This book is already listed");
            return;
        }else if(newBook.compareTo(this.first.getInfo()) < 0){
            newBookNode.setNext(this.first);
            this.first.setPrev(newBookNode);
            this.first = newBookNode;
            size++;
            cicle();
        }else if(newBook.compareTo(this.last.getInfo()) > 0){
            this.last.setNext(newBookNode);
            newBookNode.setPrev(this.last);
            this.last = newBookNode;
            size++;
            cicle();
        }else{ 
            Node aux = this.first;
            do{
                aux = aux.getNext();
            }while(aux.getInfo().compareTo(newBook) < 0 && aux != this.first);
            aux = aux.getPrev();
            newBookNode.setPrev(aux);
            newBookNode.setNext(aux.getNext());
            aux.getNext().setPrev(newBookNode);
            aux.setNext(newBookNode);
            size++;
        }

    }

    public void removeBook(String Title){
        Book temp = new Book(Title);

        if(!inCatalog(temp)){
            System.out.println("Not in catalog");
            return;
        }

        if(isEmpty()){
            System.out.println("There library catalog is empty");
            return;
        }else{
            if (size == 1){
                emptyLibrary();
                size--; 
            }else if(this.first.getInfo().getTitle().equals(Title)){
                this.first = this.first.getNext();
                cicle();
                size--;
            }else if(this.last.getInfo().getTitle().equals(Title)){
                this.last = this.last.getPrev();
                cicle();
                size--;
            }else{
                Node aux = this.first;
                do{
                    aux = aux.getNext();
                }while(aux.getInfo().getTitle().equals(Title) && aux != this.first);
                
                aux.setNext(aux.getNext().getNext());
                aux.getNext().setPrev(aux);
                size--;
            }
        }
    }

    public void searchBook(String Title){

        if(isEmpty()){
            System.out.println("The catalog is empty");
            return;
        }else if(this.first.getInfo().getTitle().equals(Title)){
            System.out.println(this.first.getInfo());
        }else if(this.last.getInfo().getTitle().equals(Title)){
            System.out.println(this.last.getInfo());
        }else{
            Node aux = this.first;

            for(int i = 0; i < size; i++){
                if(aux.getInfo().getTitle().equals(Title)){
                    System.out.println(aux.getInfo());
                    break;
                }else{
                    aux = aux.getNext();
                }
            }
        }
    }

    void emptyLibrary(){
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