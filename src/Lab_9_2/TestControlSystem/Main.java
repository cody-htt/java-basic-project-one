package Lab_9_2.TestControlSystem;

import Lab_9_2.Book.AbstractBook;
import Lab_9_2.Book.FantasyBook;
import Lab_9_2.Book.HorrorBook;
import Lab_9_2.Book.RomanceBook;
import Lab_9_2.BookControlSystem.ControllerBookSystem;
import Lab_9_2.Utilities.ExcelReader;
import Lab_9_2.Utilities.ExcelWriter;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private final static Scanner SCANNER = new Scanner(System.in);
    private final static ExcelReader EXCEL_READER = new ExcelReader();
    private static ControllerBookSystem CONTROLLER_BOOK_SYSTEM;

    public static void main(String[] args) {

        CONTROLLER_BOOK_SYSTEM = new ControllerBookSystem(EXCEL_READER.getBookList());

        boolean quit = false;
        startConsole();
        printMenu();

        while (! quit) {
            System.out.print("Enter your action (0 - to show available action): ");
            int action = validateUserInput();
            SCANNER.nextLine();

            switch (action) {
                case 0 -> printMenu();
                case 1 -> addNewBookToList();
                case 2 -> deleteBookFromList();
                case 3 -> updateBookInfo();
                case 4 -> searchBookInList();
                case 5 -> printBooksList();
                case 6 -> {
                    quit = true;
                    System.out.println("Bye...See you again!");
                }
                default -> System.out.println("Wrong option selected! Please try again...");
            }
        }

        ExcelWriter EXCEL_WRITER = new ExcelWriter(CONTROLLER_BOOK_SYSTEM.getCurrentBookList());
        if (EXCEL_WRITER.saveNewFile()) {
            System.out.println("BOOK CONTROL SYSTEM is closed successfully");
            return;
        }
        System.out.println("Fail to close BOOK CONTROL SYSTEM");
    }

    private static void startConsole() { System.out.println("Starting the BOOK CONTROL SYSTEM..."); }

    private static void printMenu() {
        System.out.println("""
                Options list:
                \t 0 - Print choice options list
                \t 1 - Add a new book to list
                \t 2 - Delete a book in list
                \t 3 - Update a book in list
                \t 4 - Search a book in list
                \t 5 - Display all books in list
                \t 6 - Exit console!
                """);
    }

    private static void printBooksList() {
        if (CONTROLLER_BOOK_SYSTEM.getCurrentBookList().isEmpty()) {
            System.out.println("There is no book in the list");
            return;
        }
        System.out.println("The book list: ");
        CONTROLLER_BOOK_SYSTEM.printAllBookList();
    }

    /*
     * The following methods is used to add a new book to the book list
     */

    private static void addNewBookToList() {
        AbstractBook book = addNewBook();

        if (CONTROLLER_BOOK_SYSTEM.addNewBook(book)) {
            System.out.println("New book is added to the list");
        } else {
            System.out.println("Can not add, the book " + book.getBookName() + " is already on the book list");
        }
    }

    private static AbstractBook addNewBook() {
        AbstractBook book = null;
        int count = 0;

        while (book == null) {
            if (count >= 1) {
                System.out.print("Your book information is incorrect, please try again!\n");
            }
            System.out.print("Please enter the new book information.\n");

            System.out.print("Enter the ISBN: ");
            String ISBN = SCANNER.nextLine();

            System.out.print("Enter the book name: ");
            String bookName = SCANNER.nextLine();

            System.out.print("Enter the author name: ");
            String authorName = SCANNER.nextLine();

            System.out.print("Enter the book price: ");
            double price = SCANNER.nextDouble();

            book = addBookWithType(ISBN , bookName , authorName , price);
            count++;
        }
        return book;
    }

    private static AbstractBook addBookWithType(String ISBN , String bookName , String authorName , double price) {
        printBookTypeSelection();
        AbstractBook newBook = null;

        System.out.print("What is the book type? ");
        int option = validateUserInput();
        SCANNER.nextLine();
        switch (option) {
            case 1 -> newBook = FantasyBook.createNewBook(ISBN , bookName , authorName , price);
            case 2 -> newBook = HorrorBook.createNewBook(ISBN , bookName , authorName , price);
            case 3 -> newBook = RomanceBook.createNewBook(ISBN , bookName , authorName , price);
            default -> {
                System.out.println("Your option is wrong!");
                printBookTypeSelection();
            }
        }
        return newBook;
    }

    private static void printBookTypeSelection() {
        System.out.println("""
                Select the following book type:
                \t1 - Fantasy Book
                \t2 - Horror Book
                \t3 - Romance Book""");
    }

    /*
     * The following methods is used to update the book in the book list
     */

    private static void updateBookInfo() {
        AbstractBook existingBookRecord = getExistingBook();

        if (existingBookRecord == null) return;

        AbstractBook updatedBookRecord = updateExistingBook(existingBookRecord);
        if (CONTROLLER_BOOK_SYSTEM.updateBook(existingBookRecord , updatedBookRecord)) {
            System.out.println("Successfully update the book " + updatedBookRecord.getBookName());
        } else {
            System.out.println("The book " + existingBookRecord.getBookName() + " is not updated!");
        }
    }

    private static AbstractBook updateExistingBook(AbstractBook existingBookRecord) {
        String bookType = existingBookRecord.getClass().getSimpleName().toUpperCase();
        AbstractBook updatedBook;

        String ISBN = updateBookField("book ISBN" , String.class);
        if (ISBN == null) ISBN = existingBookRecord.getBookISBN();

        String bookName = updateBookField("book name" , String.class);
        if (bookName == null) bookName = existingBookRecord.getBookName();

        String authorName = updateBookField("author name" , String.class);
        if (authorName == null) authorName = existingBookRecord.getAuthorName();

        double bookPrice = updateBookField("book price" , Double.class);
        if (bookPrice == 0.0) bookPrice = existingBookRecord.getPrice();

        updatedBook = switch (BookType.valueOf(bookType)) {
            case FANTASYBOOK -> FantasyBook.createNewBook(ISBN , bookName , authorName , bookPrice);
            case HORRORBOOK -> HorrorBook.createNewBook(ISBN , bookName , authorName , bookPrice);
            case ROMANCEBOOK -> RomanceBook.createNewBook(ISBN , bookName , authorName , bookPrice);
        };
        return updatedBook;
    }

    private enum BookType {
        FANTASYBOOK,
        HORRORBOOK,
        ROMANCEBOOK,
    }

    /*
     * The following methods is used to delete the book in the book list
     */

    private static void deleteBookFromList() {
        AbstractBook existingBookRecord = getExistingBook();
        if (existingBookRecord == null) return;

        if (CONTROLLER_BOOK_SYSTEM.deleteBook(existingBookRecord)) {
            System.out.println("Successfully delete the book");
        } else {
            System.out.println("Error deleting book");
        }
    }

    /*
     * The following methods is used to delete the book in the book list
     */

    private static void searchBookInList() {
        AbstractBook searchedBook = getExistingBook();
        if (searchedBook == null) return;

        String bookPrice = String.format("%.2f" , searchedBook.getPrice()) + "$";
        String bookType = searchedBook.getClass().getSimpleName().replace("Book" , "").toUpperCase();
        String leftAlignFormat = "| %-14s | %-28s | %-25s | %-10s | %-9s |%n";

        System.out.println("The book is found: ");
        System.out.format("+----------------+------------------------------+---------------------------+-------------+-----------+%n");
        System.out.format("|      ISBN      |           Book Name          |        Author Name        |  Book Type  |   Price   |%n");
        System.out.format("+----------------+------------------------------+---------------------------+-------------+-----------+%n");
        System.out.format(leftAlignFormat ,
                searchedBook.getBookISBN() ,
                searchedBook.getBookName() ,
                searchedBook.getAuthorName() ,
                bookType ,
                bookPrice);

        System.out.format("+----------------+------------------------------+---------------------------+-------------+-----------+%n");
    }

    /* Common methods */

    private static AbstractBook getExistingBook() {
        System.out.println("Enter existing book ISBN: ");
        String ISBN = SCANNER.nextLine();
        AbstractBook existingBookRecord = CONTROLLER_BOOK_SYSTEM.searchBook(ISBN);

        if (existingBookRecord == null) {
            System.out.println("Book not found!");
            return null;
        }
        return existingBookRecord;
    }

    private static <Type> Type updateBookField(String bookField , Class<Type> castType) {
        System.out.println("Want to update " + bookField + "? (Y/N)");
        String option = SCANNER.nextLine();
        Type result = null;

        if (option.equalsIgnoreCase("y")) {
            System.out.println("Enter new " + bookField + ": ");
            try {
                // the next cast to String is safe
                if (castType == String.class) {
                    result = castType.cast(SCANNER.nextLine());
                }
                // the next cast to Double is safe
                if (castType == Double.class)
                    result = castType.cast(Double.parseDouble(SCANNER.next()));
            } catch (InputMismatchException exception) {
                System.out.println("Please try again");
            } catch (NumberFormatException exception) {
                result = castType.cast(0.0D);
            }
        } else {
            if (castType == Double.class) result = castType.cast(0.0D);
        }

        return result;
    }

    /* The old way to ask which book fields user want to update. */
    /* Old way:
    private static String updateBookISBN(AbstractBook existingBookRecord) {
        System.out.println("Want to update book ISBN? Y/N");
        String option = SCANNER.nextLine();
        if (option.equalsIgnoreCase("y")) {
            System.out.print("Enter new ISBN: ");
            return SCANNER.nextLine();
        }
        return existingBookRecord.getISBN();
    }

    private static String updateBookName(AbstractBook existingBookRecord) {
        System.out.println("Want to update book name? Y/N");
        String option = SCANNER.nextLine();
        if (option.equalsIgnoreCase("y")) {
            System.out.print("Enter new book name: ");
            return SCANNER.nextLine();
        }
        return existingBookRecord.getBookName();
    }

    private static String updateAuthorName(AbstractBook existingBookRecord) {
        System.out.println("Want to update author name? Y/N");
        String option = SCANNER.nextLine();
        if (option.equalsIgnoreCase("y")) {
            System.out.println("Enter new author name: ");
            return SCANNER.nextLine();
        }
        return existingBookRecord.getAuthorName();
    }

    private static double updateBookPrice(AbstractBook existingBookRecord) {
        System.out.println("Want to update book price? Y/N");
        String option = SCANNER.nextLine();
        if (option.equalsIgnoreCase("y")) {
            System.out.println("Enter new author name: ");
            return SCANNER.nextDouble();
        }
        return existingBookRecord.getPrice();
    }
    */

    private static int validateUserInput() {
        int defaultAction;

        try {
            defaultAction = Integer.parseInt(SCANNER.next());
        } catch (NumberFormatException error) {
            defaultAction = - 1;
        }
        return defaultAction;
    }

}

