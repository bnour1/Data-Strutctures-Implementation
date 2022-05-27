package homework.circular_doubly_linked_list;

public class Book implements Comparable<Book>{

    private String title;
    private String author;
    private String Description;

    public Book(String title, String author, String Description) {
        this.title = title;
        this.author = author;
        this.Description = Description;
    }
    
    public Book(String Title){
        this.title = Title;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public int compareTo(Book b){
        return this.getTitle().compareTo(b.getTitle());
    }

    @Override
    public String toString() {
        return "Livro [Description=" + Description + ", author=" + author + ", title=" + title + "]";
    }

    
    
}
