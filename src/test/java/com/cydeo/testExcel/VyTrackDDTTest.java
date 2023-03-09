package com.cydeo.testExcel;

import com.cydeo.pages.VyTrackDashboardPage;
import com.cydeo.pages.VyTrackLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackDDTTest {

    VyTrackLoginPage loginPage =new VyTrackLoginPage();
    VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();

    @Before
    public void  setUp(){
       // Driver.getDriver().get(ConfigurationReader.getProperty("vyTrack.url"));

    }

    @After
    public  void  tearDown(){
        Driver.closeDriver();
    }

    @Test
    public void loginDDTTest() throws IOException {
        Driver.getDriver().get("https://qa2.vytrack.com/user/login");
        String filePath = "VyTrackQa2Users.xlsx";
        FileInputStream in = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(in);
        XSSFSheet sheet = workbook.getSheet("data");

        for (int i = 0; i<=sheet.getLastRowNum(); i++){
            String userName= sheet.getRow(i).getCell(0).toString();
            String password = sheet.getRow(i).getCell(1).toString();
            String  firstName = sheet.getRow(i).getCell(2).toString();
            String lastName= sheet.getRow(i).getCell(3).toString();

            loginPage.login(userName,password);

           BrowserUtils.sleep(5);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(),30);
           // wait.until(ExpectedConditions.visibilityOf(dashboardPage.fullName));
            //WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask-shown']"));
            //wait.until(ExpectedConditions.invisibilityOf(loaderMask));

            String actualFullname= dashboardPage.fullName.getText();
            XSSFCell resultCell = sheet.getRow(i).getCell(4);

            if (actualFullname.contains(firstName) && actualFullname.contains(lastName)){
                System.out.println("Pass");
                resultCell.setCellValue("Pass");
            }else {
                System.out.println("Failed");
                resultCell.setCellValue("Failed");
            }
            dashboardPage.logout();
        }
        FileOutputStream out = new FileOutputStream(filePath);
        workbook.write(out);

        in.close();
        out.close();
        workbook.close();



    }
}
