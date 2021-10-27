package Lab_9_2.Book;

public abstract class AbstractBook implements Comparable<AbstractBook> {

    protected String ISBN;
    protected String bookName;
    protected String authorName;
    protected double price;

    public abstract String getBookISBN();

    public abstract String getBookName();

    public abstract String getAuthorName();

    public abstract double getPrice();

    public abstract void setISBN(String ISBN);

    public abstract void setBoukName(String bookName);

    public abstract void setAuthorName(String authorName);

    public abstract void setPrice(double price);

    @Override
    public int compareTo(AbstractBook newBook) {
        if (newBook != null) {
            if (this.ISBN.equals(newBook.getBookISBN()) &&
                    this.bookName.equals(newBook.getBookName()) &&
                    this.authorName.equals(newBook.getAuthorName()) &&
                    this.price == newBook.getPrice()) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "AbstractBook{" +
                "ISBN='" + ISBN + '\'' +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", price=" + price +
                "$}";
    }
}
