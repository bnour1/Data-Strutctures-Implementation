package projects.lcde_streamplat.Controller;

import projects.lcde_streamplat.Model.*;

public class GenresList{
    private MainNode first;
    private int size;
    private MainNode last;
    // métodos da classe (inserção ordenada na lista, remoção na lista, busca na lista, exibição da lista

    // Metodo isEmpty.
    Boolean isEmpty(){
        return this.first == null && this.last == null && size == 0;
    }

    // Metodo para adicionar um novo genero na lista de generos.
    protected Genre addGenre(String genreName){
        Genre newGenre = new Genre(genreName);
        MainNode newGenreNode = new MainNode(newGenre);

        if(isEmpty()){
            this.first = newGenreNode;
            this.last = newGenreNode;
            this.cicle();
            this.size++;
        }else if(newGenre.compareTo(this.first.getData()) < 0){
            newGenreNode.setNext(this.first);
            this.first.setPrev(newGenreNode);
            this.first = newGenreNode;
            this.cicle();
            this.size++;
        }else if(newGenre.compareTo(this.last.getData()) > 0){
            newGenreNode.setPrev(this.last);
            this.last.setNext(newGenreNode);
            this.last = newGenreNode;
            this.cicle();
            this.size++;
        }else{
            MainNode aux = this.first;

            do{
                if(newGenre.compareTo(aux.getData()) == 0 ){
                    return aux.getData();
                }
                aux = aux.getNext();
            }while(aux != this.first && newGenre.compareTo(aux.getData()) > 0);
            
            newGenreNode.setNext(aux);
            newGenreNode.setPrev(aux.getPrev());
            aux.getPrev().setNext(newGenreNode);
            aux.setPrev(newGenreNode);
            this.size++;
        }
        return newGenreNode.getData();
    }

    // Metodo para procurar um genero na lista, recebe uma string como parametro e retorna o genero se encontrado ou null se não encontrar o genero na lista. (BUSCA MELHORADA)
    protected Genre searchGenre(String searchedGenreName) {
            Genre searchResult = null;

            
            
            Genre searchedGenre = new Genre(searchedGenreName);
            if(this.isEmpty()){
                return searchResult;
            }else if(searchedGenre.compareTo(this.first.getData()) == 0){
                searchResult = this.first.getData();
            }else if(searchedGenre.compareTo(this.last.getData()) == 0){
                searchResult = this.last.getData();
            }else{
                MainNode aux = this.first;
                do{
                    if(aux.getData().compareTo(searchedGenre) == 0){
                        searchResult =  aux.getData();
                        break;
                    }else if(aux.getData().compareTo(searchedGenre) > 0){
                        break;
                    }
                    else{
                        aux = aux.getNext();
                    }
                }while(aux != this.first); 
            }
            return searchResult;
    } 
    
    // Metodo só utilizado para simplificar a circularização da lista.
    void cicle(){
        this.first.setPrev(this.last);
        this.last.setNext(this.first);
    }

    /* Metodo para remove um genero da lista de generos (apenas chamado quando uma lista de filmes fica vazia)
     Recebe como parametro o Nó de removerFlme e remove esse nó da lista de generos. */
    void removeNodeFromList(MainNode aux){
        if(this.size == 1 && this.first == aux){
            this.first = null;
            this.last = null;
            this.size = 0;
        }else{
            if(aux == this.first){
                this.first.setNext(this.first.getNext());
                this.cicle();
                this.size--;
            }else if(aux == this.last){
                this.last = this.last.getPrev();
                this.cicle();
                this.size--;
            }else{
                aux.getNext().setPrev(aux.getPrev());
                aux.getPrev().setNext(aux.getNext());
                this.size--;
            }
        }
        
    }

    /*Metodo para remover um filme, percorre todas as listas existes até encontrar o filme, se encontrar, para de percorrer e após isso
    verifica se o nó no qual está o genero de que o filme foi removido está vazio, se estiver, encaminha para o metodo que remove nó da lista de generos
    (removeFromList) da classe GenresList*/
    protected boolean removeMovie(String title){
        MainNode aux = this.first;
        boolean wasRemoved = false; // variavel apenas para retorno

        //Loop para percorrer a lista
        do{ 
            wasRemoved = aux.getData().getList().removeFromList(title); // chama o metodo de remoção da lista de filme que retorna um booleano informando se algo foi removido.
            if(wasRemoved && aux.getData().getList().isEmpty()){ // se foi removido, e o genero ficar vazio, o nó do genero é removido da lista
                this.removeNodeFromList(aux); // metodo de remoção de nó
                break;
            }else if(wasRemoved){ //se só for removido e o nó não ficou vazio, para o loop.
                break;
            }else{ // enquanto nenhuma condicionala cima for valida, continua à percorrer
                aux = aux.getNext();
            }
        }while(aux != this.first);

        return wasRemoved; // retornando booleano informando se removel algo ou não.
    }

    //Metodo para procurar um filme nas listas dos generos, se encontrar retorna o filme, se não, retornal null
    protected Movie searchMovie(String searchedMovieTitle){
        Movie searchedMovie;
        MainNode aux = this.first;

        if(this.isEmpty()){ // se a lista está vazia, informa que o genero não está cadastrado
            System.out.println("Nothing on the genres list");
            return null;
        }else{
            // Loop para percorrer a lista de generos
            do{
                searchedMovie = aux.getData().getList().search(searchedMovieTitle); //Chamando metodo para procurar filme na lista do genero do node aux
                if(searchedMovie != null){ // se o filme é encontrado, loop é finalizado
                    break;
                }
                aux = aux.getNext();
            }while(aux != this.first);
            return searchedMovie; // retorna o filme ou null
        }
    }

    //Metodo para exibir todos os filmes
    protected void showAllMovies(){
        MainNode aux = this.first;
        if(isEmpty()){ //se não hà generos, também não existem filmes
            System.out.println("Nothing to show here");
        }else{
           //Loop para percorrer a lista usando for, e exibindo todos os filmes da lista presente no Objeto do note aux
        for(int i = 0; i < this.size; i++){ 
            aux.getData().getList().showMovies();
            aux = aux.getNext();
            } 
        }
    }
}
