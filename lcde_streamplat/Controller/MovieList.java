package lcde_streamplat.Controller;

import lcde_streamplat.Model.*;

public class MovieList{
    private SecondaryNode first;
    private int size;
    private SecondaryNode last;
    // métodos da classe (inserção ordenada na lista, remoção na lista, busca na lista, exibição da lista)

    //Metodo isEmpty()
    protected boolean isEmpty() { 
        return this.size == 0 && this.first == null && this.last == null;
    }

    //Metodo cicle utilizado apenas para manter a lista circular
    private void cicle(){
        this.first.setPrev(this.last);
        this.last.setNext(this.first);
    }

    //Metodo para inserir um filme na lista, recebe como parametro o filme que será inserido.
    protected void insertMovie(Movie theMovie){
    SecondaryNode newDataNode = new SecondaryNode(theMovie);

    if(isEmpty()){
        this.first = newDataNode;
        this.last = newDataNode;
        this.cicle();
        this.size++;
    }else if(theMovie.compareTo(this.first.getData()) < 0){
        newDataNode.setNext(this.first);
        this.first.setPrev(newDataNode);
        this.first = newDataNode;
        this.cicle();
        this.size++;
    }else if(theMovie.compareTo(this.last.getData()) > 0){
        this.last.setNext(newDataNode);
        newDataNode.setPrev(this.last);
        this.last = newDataNode;
        this.cicle();
        this.size++;
    }else{
        SecondaryNode aux = this.first;

        do{
            aux = aux.getNext();
            if(aux.getData().compareTo(theMovie) == 0){
                System.out.println("Error while trying to insert, the movie is already on the list.");
                return;
            }
        }while(aux != this.first && theMovie.compareTo(aux.getData()) > 0);

        newDataNode.setNext(aux);
        newDataNode.setPrev(aux.getPrev());
        aux.getPrev().setNext(newDataNode);
        aux.setPrev(newDataNode);
        this.size++;
    }
        
    }

    //Metodo para exibir todos os filmes da lista atual
    protected void showMovies(){
        SecondaryNode aux = this.first;

        do{
            System.out.println(aux.getData());
            aux = aux.getNext();
        }while(aux != this.first);      
    }

    //Metodo utilizado na remoção para encontrar no node que vai ser removido.
    SecondaryNode searchNode(String title){
        SecondaryNode aux = this.first;
        if(this.isEmpty()){
            return null;
        }else if(this.first.getData().getTitle().compareTo(title) == 0){
            return this.first;
        }else if(this.last.getData().getTitle().compareTo(title) == 0){
            return this.last;
        }else{
            do{
                if(aux.getData().getTitle().compareTo(title) == 0){
                    return aux;
                }
                aux = aux.getNext();
            }while(aux != this.first);
    
            return null;
        }
    }
    
    //Metodo de remoção de filme, retorna um booleano informando se removeu ou não (true ou false)
    protected boolean removeFromList(String title){
        boolean wasRemoved;
        
        if(this.isEmpty()){
            wasRemoved = false;
        }else if(this.size == 1 && this.first.getData().getTitle().compareTo(title) == 0){
            this.first = null;
            this.last = null;
            this.size = 0;
            wasRemoved = true;
        }else{
            SecondaryNode aux = searchNode(title);
            if(aux == null){
                return false;
            }
            if(this.first == aux){
                this.first = this.first.getNext();
                this.cicle();
                this.size--;
                wasRemoved = true;
            }else if(this.last == aux){
                this.last = this.last.getPrev();
                this.cicle();
                this.size--;
                wasRemoved = true;
            }else{
                aux.getNext().setPrev(aux.getPrev());
                aux.getPrev().setNext(aux.getNext());
                this.size--;
                wasRemoved = true;
            }
        }

        return wasRemoved;
    }

    //Metodo para procurar filme da lista (BUSCA MELHORADA)
    protected Movie search(String title){
        Movie searchedMovie = new Movie(title);

        if(this.isEmpty()){
            return null;
        }else if(this.first.getData().compareTo(searchedMovie) == 0){
            return this.first.getData();
        }else if(this.last.getData().compareTo(searchedMovie) == 0){
            return this.last.getData();
        }else{
            SecondaryNode aux = this.first;
            do{
                if(aux.getData().compareTo(searchedMovie) == 0){
                    return aux.getData();
                }else if(aux.getData().compareTo(searchedMovie) > 0){
                    break;
                }
                aux = aux.getNext();
            }while(aux != this.first);
        }

        return null;
    }
}
