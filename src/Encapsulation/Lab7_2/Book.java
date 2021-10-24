package Encapsulation.Lab7_2;

public class Book {

    private final String bookName;
    private final String authorName;
    private final long ISBN;

    private Book(BookBuilder bookBuilder) {
        this.bookName = bookBuilder.bookName;
        this.authorName = bookBuilder.authorName;
        this.ISBN = bookBuilder.ISBN;
    }

    @Override
    public String toString() {
        return "=======================================\n" +
                "The book is \"" + this.bookName.toUpperCase() +
                "\"\nThe author is \"" + this.authorName.toUpperCase() +
                "\" and it's ISBN is \"" + this.ISBN +
                "\"\n=======================================\n";
    }

    public long getISBN() {
        return ISBN;
    }

    public static class BookBuilder {

        private String bookName;
        private String authorName;
        private long ISBN;

        public BookBuilder setBookName(String bookName) {
            this.bookName = bookName;
            return this;
        }

        public BookBuilder whoIsAuthor(String authorName) {
            this.authorName = authorName;
            return this;
        }

        public BookBuilder enterISBN(long ISBN) {
            this.ISBN = ISBN;
            return this;
        }

        public Book build () {
            return new Book(this);
        }

    }

}
