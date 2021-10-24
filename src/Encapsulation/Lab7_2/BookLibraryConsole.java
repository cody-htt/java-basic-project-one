package Encapsulation.Lab7_2;

import java.util.*;

public class BookLibraryConsole {

    private final static Scanner scanner = new Scanner(System.in);
    private final List<Book> listOfBook;

    public BookLibraryConsole(List<Book> listOfBook) {
        this.listOfBook = listOfBook;
    }

    public void openLibraryApp() {
        if (this.listOfBook.size() == 0) {
            System.out.println("There is no book in library yet");
            return;
        } else {
            printMenu();
        }
        libraryBookEngine();
    }

    private void libraryBookEngine() {
        boolean exit = false;
        while (!exit) {
            System.out.print("Your option (press 5 to view option list): ");
            int action = validateUserInput();
            switch (action) {
                case 1:
                    exit = isExit();
                    break;
                case 2:
                    importUserBook();
                    break;
                case 3:
                    searchExistBook();
                    break;
                case 4:
                    printListOfBook();
                    break;
                case 5:
                    printMenu();
                    break;
                default:
                    printWarning();
                    break;
            }
        }
    }

    /*The following methods is used to add a new book
     * After user enter all the information
     * -> getUserBook() will call addNewBookToList()
     * -> addNewBookToList() invoke checkBookExistence() to see if the book is already exist in the List
     * 1. If the book is not exist, add the book to List
     * 2. If the book is existed, will not add the book to List
     * */
    private void importUserBook() {
        System.out.print("Please enter the book ISBN: ");
        long ISBN = validateInputISBN();
        scanner.nextLine();
        System.out.print("Please enter the book name: ");
        String bookName = scanner.nextLine();
        System.out.print("Please enter the author name: ");
        String authorName = scanner.nextLine();
        if (ISBN > 0) {
            addNewBookToList(ISBN, bookName, authorName);
        } else {
            System.out.println("Your book information is invalid");
        }
    }

    private void addNewBookToList(long ISBN, String bookName, String authorName) {
        Book newBook = new Book.BookBuilder().enterISBN(ISBN).setBookName(bookName).whoIsAuthor(authorName).build();
        if (checkBookExistence(newBook.getISBN()) == null) {
            this.listOfBook.add(newBook);
            System.out.println("The new book has added successfully!!!");
        } else {
            System.out.println("This book is already exist");
        }
    }

    private Book checkBookExistence(long ISBN) {
        for (Book existBook : this.listOfBook) {
            if (existBook.getISBN() == ISBN) {
                return existBook;
            }
        }
        return null;
    }

    /* The following methods is used to search for the existed book in the list */
    private void searchExistBook() {
        System.out.print("Enter the book ISBN: ");
        int ISBN = validateUserInput();
        if (checkBookExistence(ISBN) == null) {
            System.out.println("This book is not existed!!!");
        } else {
            Book searchedBook = checkBookExistence(ISBN);
            System.out.println(searchedBook);
        }
    }

    /* Some services methods for internally invoke */
    private static void printMenu() {
        System.out.print("Hello, please select the below action:\n" +
                "1. Exit App\n" +
                "2. Insert new book\n" +
                "3. Search for a book\n" +
                "4. Show all books\n" +
                "5. Show option menu\n");
    }

    private static void printWarning() {
        System.out.println("You are allowed to select option from 1 - 5" +
                "\nPlease try again!!!\n");
    }

    private void printListOfBook() {
        for (Book book : this.listOfBook) {
            System.out.println(book);
        }
    }

    private boolean isExit() {
        System.out.println("Apps will be closed");
        return true;
    }

    /* Validate the selected option from user -> if it is invalid, the default action will always be 0 */
    private static int validateUserInput() {
        int defaultAction;
        try {
            defaultAction = Integer.parseInt(scanner.next());
        } catch (NumberFormatException error) {
            defaultAction = 0;
        }
        return defaultAction;
    }

    /* Validate the ISBN from user */
    private static Long validateInputISBN() {
        long validISBN = 0L;
        String inputISBN;
        try {
            inputISBN = scanner.next();
            if (inputISBN.length() == 10) {
                validISBN = Long.parseLong(inputISBN);
            }
        } catch (NumberFormatException error) {
            validISBN = -1L;
        }
        return validISBN;
    }

}
