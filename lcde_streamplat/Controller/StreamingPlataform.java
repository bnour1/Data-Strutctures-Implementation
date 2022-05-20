package lcde_streamplat.Controller;

import lcde_streamplat.Model.*;
import lcde_streamplat.View.*;

//Classe criada opcionalmente com intuito se simplificar o codigo e diminuir a compelxidade dos metodos das classes GenresList e MovieList
public class StreamingPlataform extends MovieList{

    private GenresList genres = new GenresList();

	//Metodo que intemedia a adição de filmes ao catalogo, apenas chamando os metodos das listas
    public void addMovie(String title,	String genre,	String rating,	int year){
		Movie movie = new Movie(title, genre, rating, year); // criação do objeto do novo filme

		// tenta adicionar o genero, se o genero já na lista estiver o metodo retorna o objeto, se não, o metodo adiciona e retorna o objeto dps da adição
		Genre gen = genres.addGenre(genre); // esse objeto retornado é atribuido a variavel "gen"
        
        gen.getList().insertMovie(movie); // Adição no filme na lista do genero encontrado.
    }

	// Metodo que exibe todos os filmes em uma categoria, recebe como parametro a categoria.
    public void showMoviesOnGender(String gender){ 
        Genre gen = genres.searchGenre(gender); // busca pela categoria na lista e atribui o retorno à variavel gen (null ou o Objeto)

        if(gen == null){ // se null, categoria não existe
            System.out.println("Genre not on the list");
        }else{ // se existir, exibe todos os filmes na lista daquele Objeto
            gen.getList().showMovies();
        }
    }

    // Metodo que intermedia a remoção, apenas chama o metodo de remoção e informa se algo foi removido ou não.
	public void removeMovie(String title){ 
        boolean wasRemoved = genres.removeMovie(title); // atribui o retorno do metodo booleano de remoção à variavel "wasRemoved"
		
		if(wasRemoved){ // Se algo foi removido, exibe a menssagem informando, se não, também é informado que o titulo não foi encontrado
			System.out.println("Title removed.");
		}else{
			System.out.println("Title not found.");
		}
        
    }
    
	//Metodo para exibir os detalhes de um determinado filme recebendo seu titulo
	public void showMovieDetails(String title){
		Movie searchedMovie = genres.searchMovie(title); // Buscando filme nas listas

		if(searchedMovie == null){ // Se a variavel for null, filme não está listado
			System.out.println("Movie not found");
		}else{ // se não, exibe os detalhes desse filme.
			System.out.println("Showing "+searchedMovie.getTitle()+" Details");
			System.out.println(searchedMovie); // exibindo o objeto
		}
	}

	//Metodo só pra chamar a outra classe onde a logica está
	public void showAllMovies(){
		genres.showAllMovies();
	}

	// Metodo para a edição de filmes
	public void editMovie(String title){
		Movie movie = genres.searchMovie(title); // procura o filme em toda a lista de generos, se encontrar, o filme é atribuido à variavel "movie"
        if(movie != null){ //se o retorno do metodo não for null, é por que a variavel recebeu o objeto
            App.editMovieMenu(movie); // Chamando o metodo estatico da main que exibe menu e realiza edições no objeto, passando como parametro o objeto à ser editado.
        }else{ // se o retorno for null, o filme não foi encontrado
			System.out.println("Movie not found");
		}
	}
}
