package Lab_9_2.Utilities;

import Lab_9_2.Book.AbstractBook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class ExcelWriter extends Constant {

    private final List<AbstractBook> workingBookList;
    private final XSSFWorkbook workbook;

    public ExcelWriter(List<AbstractBook> workingBookList) {
        this.workingBookList = workingBookList;
        this.workbook = new XSSFWorkbook();
    }

    public boolean saveNewFile() {
        File excelFile = new File(PATH + "booklist.xlsx");
        if (excelFile.exists() && excelFile.delete()) {
            for (Constant.sheetName name : Constant.sheetName.values()) {
                String sheetName = name.toString().replace("_" , " ");
                importDataToExcel(sheetName);
            }
            saveFileOnDisk(excelFile);
            return true;
        }
        System.out.println("Failed to save the book list!");
        return false;
    }

    private HashMap<String, HashMap<Integer, Object[]>> createRootMap() {
        HashMap<String, HashMap<Integer, Object[]>> rootMap = new HashMap<>();
        HashMap<Integer, AbstractBook> childMap = createChildMap(workingBookList);
        HashMap<Integer, Object[]> fantasyBookMap = new HashMap<>();
        HashMap<Integer, Object[]> horrorBookMap = new HashMap<>();
        HashMap<Integer, Object[]> romanceBookMap = new HashMap<>();

        int rowNumSheetFantasy = 0;
        int rowNumSheetHorror = 0;
        int rowNumSheetRomance = 0;

        for (int childKey : childMap.keySet()) {
            AbstractBook book = childMap.get(childKey);
            String bookType = childMap.get(childKey).getClass().getSimpleName().replace("Book" , "_Book");

            switch (sheetName.valueOf(bookType)) {
                case Fantasy_Book -> {
                    rowNumSheetFantasy++;
                    fantasyBookMap.put(rowNumSheetFantasy ,
                            new Object[] { book.getBookISBN() , book.getBookName() , book.getAuthorName() , book.getPrice() });
                }
                case Horror_Book -> {
                    rowNumSheetHorror++;
                    horrorBookMap.put(rowNumSheetHorror ,
                            new Object[] { book.getBookISBN() , book.getBookName() , book.getAuthorName() , book.getPrice() });
                }
                case Romance_Book -> {
                    rowNumSheetRomance++;
                    romanceBookMap.put(rowNumSheetRomance ,
                            new Object[] { book.getBookISBN() , book.getBookName() , book.getAuthorName() , book.getPrice() });
                }
            }
        }

        rootMap.put(Constant.SHEET_FANTASY , fantasyBookMap);
        rootMap.put(Constant.SHEET_HORROR , horrorBookMap);
        rootMap.put(Constant.SHEET_ROMANCE , romanceBookMap);

        return rootMap;
    }

    private HashMap<Integer, AbstractBook> createChildMap(List<AbstractBook> bookList) {
        HashMap<Integer, AbstractBook> childMap = new HashMap<>();
        int rowNum = 1;
        for (AbstractBook book : bookList) {
            childMap.put(rowNum , book);
            rowNum++;
        }
        return childMap;
    }

    private void importDataToExcel(String sheetName) {
        HashMap<Integer, Object[]> dataSet = createRootMap().get(sheetName);
        Set<Integer> set = dataSet.keySet();
        XSSFSheet workbookSheet = workbook.createSheet(sheetName);

        int rowNum = 0;
        for (int key : set) {
            Row row = workbookSheet.createRow(rowNum++);
            Object[] data = dataSet.get(key);
            int cellNum = 0;
            for (Object value : data) {

                Cell cell = row.createCell(cellNum++);

                if (value instanceof String) {
                    cell.setCellValue(( String ) value);
                } else if (value instanceof Double) {
                    cell.setCellValue(( Double ) value);
                }
            }
        }
    }

    private void saveFileOnDisk(File newFile) {
        try {
            FileOutputStream fileOut = new FileOutputStream(newFile);
            workbook.write(fileOut);
            fileOut.flush();
            workbook.close();
            fileOut.close();
        } catch (IOException error) {
            error.printStackTrace();
        }
    }

}
