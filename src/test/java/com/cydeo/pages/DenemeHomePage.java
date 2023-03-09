package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DenemeHomePage {
    public DenemeHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user-name")
    public WebElement fullName;

    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logOutBtn;

    public void  logout(){
        fullName.click();
        logOutBtn.click();

    }



}
