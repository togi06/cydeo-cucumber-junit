package com.cydeo.testExcel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void read_from_excel_file() throws IOException {
        String path = "SampleData.xlsx";

        // to read from excel we need to load it to FileInput Stream
        FileInputStream fileInputStream = new FileInputStream(path);

        // workbook>sheet>row>cell
        //1) Creat a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //2)We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        //3) Select row and cell = hangi sıranın hangi hücresinde ne olduğunu yazdırmak için
        // Print out mary's cell
        // Indexes start from 0
        System.out.println(sheet.getRow(1).getCell(0));

        //Print out Developer
        System.out.println(sheet.getRow(3).getCell(2));

        //Return the count of used cells only = Excel de kaç sıra yazılmış onun için
        //Starts counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println(usedRows);

        // returns the number from top cell to bottom cell =  başlıksız kaç sıra kullanılmış
        //It doesn't care if the cell is empty or not
        // starts counting from 0
        int lastUsedRow = sheet.getLastRowNum();
        System.out.println(lastUsedRow);


        //TODO: create a logic to print  Vinod's name = excel içindeki herhangi bir sırayı kullanmak için

        for (int rowNum=0; rowNum<usedRows; rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Vinod")){
                System.out.println(sheet.getRow(rowNum).getCell(0));
            }
        }

        //TODO: Create a logic to print out Linda's Job_ID
        // Check if name is Linda --> print out Job_ID of Linda
        for(int rowNum=0 ; rowNum<usedRows; rowNum++ ){
            if(sheet.getRow(rowNum).getCell(0).toString().equals("Linda")){
                System.out.println("Linda's Job_ID " + sheet.getRow(rowNum).getCell(2));
            }
        }





    }
}
