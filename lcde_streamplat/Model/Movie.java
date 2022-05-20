package lcde_streamplat.Model;

// Objeto filme com metodos obrigatorios e um construtor extra utilziado apenas para criação de filmes temporarios / testes do App
public class Movie implements Comparable <Movie> {
    private String title; 
    private String genre; 
    private String rating; 
    private int year; 

    public Movie(String title, String genre, String rating, int year) {
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.year = year;
    }

    public Movie(String title) {
        this.title = title;
    }

    @Override
    public int compareTo(Movie o) {
        return this.title.compareTo(o.title);
    }
    @Override
    public String toString() {
        return "Movie [genre=" + genre + ", rating=" + rating + ", title=" + title + ", year=" + year + "]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
