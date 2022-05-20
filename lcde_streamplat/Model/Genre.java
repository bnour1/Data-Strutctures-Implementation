package lcde_streamplat.Model;

import lcde_streamplat.Controller.MovieList;

// Objeto Genero com metodos obrigatorios
public class Genre implements Comparable <Genre> {
    private String description; 
    private MovieList list;

    public Genre(String description) {
        this.description = description;
        list = new MovieList();
    }

    @Override
    public String toString() {
        return "Categoria [description=" + description + ", list=" + list + "]";
    }
        
    @Override
    public int compareTo(Genre o) {
        return this.description.compareTo(o.description);
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public MovieList getList() {
        return list;
    }
    public void setList(MovieList list) {
        this.list = list;
    }
}