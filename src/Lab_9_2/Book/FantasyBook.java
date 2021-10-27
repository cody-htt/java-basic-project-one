package Lab_9_2.Book;

public class FantasyBook extends AbstractBook {

    public FantasyBook(String ISBN , String bookName , String authorName , double price) {
        this.ISBN = ISBN;
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
    }

    @Override
    public String getBookISBN() { return ISBN; }

    @Override
    public String getBookName() { return bookName; }

    @Override
    public String getAuthorName() { return authorName; }

    @Override
    public double getPrice() { return price; }

    @Override
    public void setISBN(String ISBN) { this.ISBN = ISBN; }

    @Override
    public void setBoukName(String bookName) { this.bookName = bookName; }

    @Override
    public void setAuthorName(String authorName) { this.authorName = authorName; }

    @Override
    public void setPrice(double price) { this.price = price; }

    public static FantasyBook createNewBook(String ISBN , String bookName , String authorName , double price) {
        return new FantasyBook(ISBN ,
                bookName ,
                authorName ,
                price);
    }
}
