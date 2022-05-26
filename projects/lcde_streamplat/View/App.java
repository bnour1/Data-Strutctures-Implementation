package projects.lcde_streamplat.View;
import java.util.Scanner;

import projects.lcde_streamplat.Controller.StreamingPlataform;
import projects.lcde_streamplat.Model.Movie;

public class App {

    public static StreamingPlataform uniflix = new StreamingPlataform();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String title, genre, rating; int year; // Variaveis usadas para atibuições por scanner
        char op;

        do{
            menu(); // Exibe menu de opções
            op = in.next().charAt(0);

            switch(op){

                case '1': // 1 - Add a new movie - Inserir um novo filme
                System.out.println("Insert the movie title");
                title = in.nextLine(); title = in.nextLine();
                System.out.println("insert the movie category");
                genre = in.nextLine();
                System.out.println("insert the movie rating");
                rating = in.nextLine();
                System.out.println("insert the movie year");
                year = in.nextInt();
                uniflix.addMovie(title, genre, rating, year); // Chamada do metodo que contém a logica da inserção
                break;
                case '2': // 2 - remove a movie - Remover um filme especifico
                System.out.println("Insert the movie title");
                title = in.nextLine(); title = in.nextLine();
                uniflix.removeMovie(title); // Chamada do metodo que contém a logica da remoção
                break;
                case '3': // 3 - show details of a movie - Exibir detalhes de um filme especifico
                System.out.println("Insert the movie title");
                title = in.nextLine(); title = in.nextLine();
                uniflix.showMovieDetails(title); // Chamada do metodo que contém a logica da exibição
                break;
                case '4': // 4 - Edit details of a movie - Edição de informações de um filme
                System.out.println("Inser the movie title");
                title = in.nextLine(); title = in.nextLine();
                uniflix.editMovie(title); // Chamada do metodo que contém a logica da edição
                break;
                case '5': // 5 - show all movies - Exibir todos os filmes de todas categorias
                uniflix.showAllMovies(); // Chamada do metodo que contém a logica da exibição
                break;
                case '6': // 6 - show all movies of a specific category - Exibir todos os filmes de uma categoria especifica
                System.out.println("Insert the category");
                genre = in.nextLine(); genre = in.nextLine();
                uniflix.showMoviesOnGender(genre); // Chamada do metodo que contém a logica da exibição
                break;
                default:
                System.out.println("Oops");
                break;
            }
        }while(op != 0);

        
    }

    static void menu(){
        System.out.println("\nSTREAMING PLATAFORM");
        System.out.println("1 - Add a new movie");
        System.out.println("2 - remove a movie");
        System.out.println("3 - show details of a movie");
        System.out.println("4 - Edit details of a movie");
        System.out.println("5 - show all movies");
        System.out.println("6 - show all movies of a specific category");
        System.out.println("0 - Leave :c");
    }
    
    public static void editMovieMenu(Movie movie){
        String title, genre, rating; int year;
        Scanner in = new Scanner(System.in);
        char op;

        do{
            System.out.println("\nWhat you want to edit?");
            System.out.println("1 - Movie title");
            System.out.println("2 - Movie Category");
            System.out.println("3 - Movie Rating");
            System.out.println("4 - Movie Year");
            System.out.println("0 - Return to main Menu");
            op = in.next().charAt(0);

            switch(op){
                case '1': // 1 - Movie title - Logica edição de titulo
                System.out.print("Insert the new Title: ");
                title = in.nextLine(); title = in.nextLine();
                uniflix.addMovie(title, movie.getGenre(), movie.getRating(), movie.getYear()); // adiciona um mesmo filme na lista apenas com o titulo novo
                uniflix.removeMovie(movie.getTitle()); // remove o Objeto antigo
                System.out.println("Title changed.");
                return;
                case '2': // Return para finalizar o metodo e atualizar o objeto para outras edições
                System.out.print("Insert the new Category: ");
                genre = in.nextLine(); genre = in.nextLine();
                title = movie.getTitle(); rating = movie.getRating(); year = movie.getYear();
                uniflix.removeMovie(movie.getTitle());
                uniflix.addMovie(title, genre, rating, year);
                System.out.println("Movie cantegory changed");
                return; // Return para finalizar o metodo e atualizar o objeto para outras edições
                case '3': // 3 - Movie Rating - Mudança na classificação do filme
                System.out.print("insert the new rating: ");
                rating = in.nextLine(); rating = in.nextLine();
                movie.setRating(rating);
                System.out.println("Rating changed");
                break;
                case '4': // 4 - Mudança no ano de lançamento do filme
                System.out.println("Insert the new year: ");
                year = in.nextInt();
                movie.setYear(year);
                System.out.println("Movie year changed.");
                break;
                default:
                System.out.println("Oops");
                break;
            }
    
        }while(op != '0');

    }
    
    
}
