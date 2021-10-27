package Lab_9_2.BookControlSystem;

import Lab_9_2.Book.AbstractBook;

import java.util.*;

public class ControllerBookSystem {

    private final List<AbstractBook> currentBookList;

    public ControllerBookSystem(List<AbstractBook> bookList) {
        this.currentBookList = bookList;
    }

    public List<AbstractBook> getCurrentBookList() {
        return currentBookList;
    }

    public boolean addNewBook(AbstractBook newBook) {
        if (findBook(newBook.getBookISBN()) >= 0) {
            System.out.println("This book with " + newBook.getBookISBN() + " is already existed");
            return false;
        }
        this.currentBookList.add(newBook);
        return true;
    }

    public boolean updateBook(AbstractBook oldBook , AbstractBook newBook) {
        int foundPosition = findBook(oldBook);
        if (foundPosition < 0) {
            System.out.println(oldBook.getBookName() + " with " +
                    oldBook.getBookISBN() + " is not found");
            return false;
        }

        if (oldBook.compareTo(newBook) > 0) return false;

        this.currentBookList.set(foundPosition , newBook);
        System.out.println(oldBook.getBookName() + " is updated to " + newBook.getBookName());
        return true;

    }

    public boolean deleteBook(AbstractBook book) {
        if (findBook(book.getBookISBN()) < 0) {
            System.out.println("This book with" + book.getBookISBN() + " is not found");
            return false;
        }

        this.currentBookList.remove(book);
        System.out.println(book.getBookName() + " was deleted!");
        return true;
    }

    public AbstractBook searchBook(String ISBN) {
        int position = findBook(ISBN);
        if (position >= 0) {
            return this.currentBookList.get(position);
        }
        return null;
    }

    private int findBook(AbstractBook book) {
        return this.currentBookList.indexOf(book);
    }

    private int findBook(String ISBN) {
        for (AbstractBook book : currentBookList) {
            if (book.getBookISBN().equals(ISBN)) {
                return currentBookList.indexOf(book);
            }
        }
        return - 1;
    }

    public void printAllBookList() {
        String leftAlignFormat = "| %-14s | %-28s | %-25s | %-11s | %-9s |%n";
        System.out.format("+----------------+------------------------------+---------------------------+-------------+-----------+%n");
        System.out.format("|      ISBN      |           Book Name          |        Author Name        |  Book Type  |   Price   |%n");
        System.out.format("+----------------+------------------------------+---------------------------+-------------+-----------+%n");
        for (AbstractBook book : currentBookList) {
            String bookPrice = String.format("%.2f" , book.getPrice()) + "$";
            String bookType = book.getClass().getSimpleName().replace("Book" , "").toUpperCase();
            System.out.format(leftAlignFormat , book.getBookISBN() , book.getBookName() , book.getAuthorName() , bookType , bookPrice);
        }
        System.out.format("+----------------+------------------------------+---------------------------+-------------+-----------+%n");
    }
}
