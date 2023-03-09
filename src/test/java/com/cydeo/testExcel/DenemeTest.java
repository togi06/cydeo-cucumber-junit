package com.cydeo.testExcel;

import com.cydeo.pages.DenemeHomePage;
import com.cydeo.pages.DenemeLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DenemeTest {
    DenemeLoginPage loginPage =new DenemeLoginPage();
    DenemeHomePage homePage = new DenemeHomePage();


    @Before
    public void setUp(){


    }

    @After
    public void tearDown(){

        //Driver.closeDriver();
    }

    @Test
    public void test() throws IOException {
        Driver.getDriver().get("https://qa.bleucrm.com/");
        String filePath = "Deneme.xlsx";
        FileInputStream in = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheet("Sayfa1");


        for (int i=1; i<=sheet.getLastRowNum(); i++){
            String userName = sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();
            String  firstName= sheet.getRow(i).getCell(2).toString();
            String lastName= sheet.getRow(i).getCell(3).toString();

            loginPage.login(userName,password);

            //WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
            //wait.until(ExpectedConditions.invisibilityOf(homePage.fullName));

            BrowserUtils.sleep(2);

            String actualFullName= homePage.fullName.getText();
            XSSFCell resultCell = sheet.getRow(i).getCell(4);

            if (actualFullName.contains(firstName) && actualFullName.contains(lastName)){
                resultCell.setCellValue("Pass");
            }else {
                resultCell.setCellValue("failed");
            }
            homePage.logout();
        }
        FileOutputStream out= new FileOutputStream(filePath);
        workbook.write(out);
        in.close();
        out.close();
        workbook.close();
    }


}
