package com.automation.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    private int rows;
    private String str;
    private double val;

   // public   Object[][] ReadData(int row_num, int column_num) throws IOException {

      public   Object[][] ReadData() throws IOException {
        File src = new File("C:\\Users\\ZSINNIS\\eclipse-workspace\\Test-Project\\Test Data\\data.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        Sheet sh = wb.getSheet("Nishant");
        setRows(sh.getLastRowNum());
        Object [][] obj= new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
        
        
  /* *****************************************************************************************************************************************
        String st= sh.getRow(row_num).getCell(column_num).getCellType().toString();
          
       switch (st) {
         case "STRING":
             System.out.println(sh.getRow(row_num).getCell(column_num).getStringCellValue());
           //   setStr(sh.getRow(row_num).getCell(column_num).getStringCellValue());
       //      return ;
             break;
         case "NUMERIC":
             System.out.println(sh.getRow(row_num).getCell(column_num).getNumericCellValue());
      //    setVal(sh.getRow(row_num).getCell(column_num).getNumericCellValue());
//             return ;
             break;
                         }
   *********************************************************************************************************************************************/     
      
        
 //    /* **************************************************************************************************
    //    for (Row row: sh) {
            for (int i = 0; i < rows; i++) {
            //      short col = row.getLastCellNum();
              //  for (int j = 0; j < col; j++) {
                  
                  String Username= sh.getRow(i+1).getCell(0).getStringCellValue();
                  String Password =sh.getRow(i+1).getCell(1).getStringCellValue();
                  obj [i][0]=Username;
                  obj[i][1]=Password;
                  
                  
                           /*  String t = sh.getRow(i).getCell(j).getCellType().toString(); {
                        switch (t) {
                            case "STRING":
                                System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
                                 break;
                            case "NUMERIC":
                                System.out.println(sh.getRow(i).getCell(j).getNumericCellValue());
                                 break;

                        }
                    }
              
                }
                
            }
                */
        }
        
    //         ***********************************************************************************************************/ 
       
       
        wb.close();
        return obj ;
        
       
    }

    public int getRows() {
      return rows;
    }

    public void setRows(int rows) {
      this.rows = rows;
    }

    public String getStr() {
      return str;
    }

    public void setStr(String str) {
      this.str = str;
    }

    public double getVal() {
      return val;
    }

    public void setVal(double val) {
      this.val = val;
    }

}