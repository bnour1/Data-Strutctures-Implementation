package homework.singly_linked_list.atividade1;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Logic library = new Logic();
        char op;
        String bookTitle, author, bookDescription;

        do{
            menu();
            op = in.next().charAt(0);
            Character.toLowerCase(op);

            switch(op){
                case '1':
                System.out.println("Insert the book Title");
                bookTitle = in.nextLine(); bookTitle = in.nextLine(); 
                System.out.println("Insert the name of the author");
                author = in.nextLine(); 
                System.out.println("Insert the book description");
                bookDescription = in.nextLine(); 
                Book newBook = new Book(bookTitle, author, bookDescription);
                library.addBook(newBook);
                break;
                case '2':
                    library.showCatalog();
                break;
                case '3':
                System.out.println("Insert the book Title");
                bookTitle = in.nextLine(); bookTitle = in.nextLine();
                library.removeBook(bookTitle);
                break;
                case '4':
                System.out.println("Insert the book Title");
                bookTitle = in.nextLine(); bookTitle = in.nextLine();
                library.searchBook(bookTitle);
                break;
                default:
                System.out.println("Invalid input.");
                break;
            }
        }while (op != '0');
    }

    static void menu(){
        System.out.println("\nWELCOME TO THE BEST LIBRARY IN THE WORLD");
        System.out.println("Insert 1 to insert a book in our catalog");
        System.out.println("Insert 2 to show all books in our catalog");
        System.out.println("Insert 3 to remove a book");
        System.out.println("Insert 4 to search for a book");
        System.out.println("Press 0 to leave :c");
    }
    
}
