package Lab_9_2.Utilities;

public class Constant {

    protected final static String PATH = System.getProperty("user.dir") + "/Data/";

    public enum sheetName {
        Fantasy_Book,
        Horror_Book,
        Romance_Book,
    }

    protected final static String SHEET_FANTASY = "Fantasy Book";
    protected final static String SHEET_HORROR = "Horror Book";
    protected final static String SHEET_ROMANCE = "Romance Book";

}
