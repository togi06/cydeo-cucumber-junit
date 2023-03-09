package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DenemeLoginPage {

    public DenemeLoginPage (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@class='login-inp']")
    public WebElement userName;

    @FindBy (name = "USER_PASSWORD")
    public WebElement pass;

    @FindBy(className = "login-btn")
    public WebElement loginBtn;

    public void login(String username, String password){
        userName.sendKeys(username);
        pass.sendKeys(password);
        loginBtn.click();
    }

    //public void  login (String username, String password ){
    //        loginUser.sendKeys(username);
    //        loginPass.sendKeys(password);
    //        loginBtn.click();
}
