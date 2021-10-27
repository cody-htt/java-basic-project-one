package Lab_9_2.Utilities;

import Lab_9_2.Book.AbstractBook;
import Lab_9_2.Book.FantasyBook;
import Lab_9_2.Book.HorrorBook;
import Lab_9_2.Book.RomanceBook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReader extends Constant {

    private static final HashMap<String, HashMap<Integer, AbstractBook>> rootMap = new HashMap<>();
    private static HashMap<Integer, AbstractBook> childMap = new HashMap<>();

    private final List<AbstractBook> bookList;

    public ExcelReader() {
        this.bookList = convertHaspMapToArrayList(mapDataFromFile());
    }

    public List<AbstractBook> getBookList() {
        return bookList;
    }

    public HashMap<String, HashMap<Integer, AbstractBook>> mapDataFromFile() {
        String sheetName;
        try {
            File excelFile = new File(PATH + "booklist.xlsx");
            FileInputStream readFile = new FileInputStream(excelFile);
            XSSFWorkbook workbook = new XSSFWorkbook(readFile);

            for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
                XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
                sheetName = workbook.getSheetName(sheetIndex);

                Iterator<Row> rowIterator = sheet.rowIterator();

                while (rowIterator.hasNext()) {
                    XSSFRow row = ( XSSFRow ) rowIterator.next();
                    if (row.getRowNum() == 0) continue;

                    AbstractBook book = extractBookObject(sheetName , row);
                    if (book == null) continue;

                    childMap.put(row.getRowNum() , book);

                }
                rootMap.put(sheetName , childMap);
                childMap = new HashMap<>();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return rootMap;
    }

    private AbstractBook extractBookObject(String sheetName , XSSFRow row) {
        String bookType = sheetName.replace(" " , "_");

        return switch (Constant.sheetName.valueOf(bookType)) {
            case Fantasy_Book -> FantasyBook.createNewBook(row.getCell(0).getStringCellValue() ,
                    row.getCell(1).getStringCellValue() ,
                    row.getCell(2).getStringCellValue() ,
                    row.getCell(3).getNumericCellValue());
            case Horror_Book -> HorrorBook.createNewBook(row.getCell(0).getStringCellValue() ,
                    row.getCell(1).getStringCellValue() ,
                    row.getCell(2).getStringCellValue() ,
                    row.getCell(3).getNumericCellValue());
            case Romance_Book -> RomanceBook.createNewBook(row.getCell(0).getStringCellValue() ,
                    row.getCell(1).getStringCellValue() ,
                    row.getCell(2).getStringCellValue() ,
                    row.getCell(3).getNumericCellValue());
        };

    }

    private List<AbstractBook> convertHaspMapToArrayList(HashMap<String, HashMap<Integer, AbstractBook>> map) {
        if (map.isEmpty()) return null;

        ArrayList<String> masterKeySet = new ArrayList<>(map.keySet());
        List<AbstractBook> bookList = new ArrayList<>();

        for (String masterKey : masterKeySet) {
            HashMap<Integer, AbstractBook> bookHashMap = map.get(masterKey);
            for (int childKey : bookHashMap.keySet()) {
                bookList.add(bookHashMap.get(childKey));
            }
        }

        return bookList;
    }
}

