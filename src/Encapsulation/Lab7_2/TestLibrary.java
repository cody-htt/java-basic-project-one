package Encapsulation.Lab7_2;

import java.util.ArrayList;
import java.util.List;

public class TestLibrary {

    private final static List<Book> bookLibraryList = new ArrayList<>();

    public static void main(String[] args) {

        //Create some books for testing
        Book book_1 = new Book.BookBuilder()
                .enterISBN(1000000001).setBookName("It Ends With Us").whoIsAuthor("Collen Hoover").build();
        Book book_2 = new Book.BookBuilder()
                .enterISBN(1000000002).setBookName("The Proposal").whoIsAuthor("Jasmin Guillory").build();
        Book book_3 = new Book.BookBuilder()
                .enterISBN(1000000003).setBookName("Gone With the Wind").whoIsAuthor("Margaret Mitchell").build();

        //Add the created book to the bookLibraryList
        bookLibraryList.add(0, book_1);
        bookLibraryList.add(1, book_2);
        bookLibraryList.add(2, book_3);

        //Instantiate the libraryConsole object
        BookLibraryConsole libraryConsole = new BookLibraryConsole(bookLibraryList);
        libraryConsole.openLibraryApp();

    }

}
