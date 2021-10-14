package Encapsulation.Lab7_2;

import java.util.ArrayList;

public class BookLibrary {

    private ArrayList<Book> listOfBook;

    public BookLibrary() {
        this.listOfBook = new ArrayList<>();
    }

    public boolean addBook(int ISBN, String bookName, String authorName) {
        if (findBook(ISBN) == null) {
            Book book = new Book.BookBuilder()
                    .enterISBN(ISBN)
                    .setBookName(bookName)
                    .whoIsAuthor(authorName)
                    .build();
            this.listOfBook.add(book);
            return true;
        }
        return false;
    }

    private Book findBook(int ISBN) {
        for (Book existedBook : this.listOfBook) {
            if (existedBook.getISBN() == ISBN) {
                return existedBook;
            }
        }
        return null;
    }


}
