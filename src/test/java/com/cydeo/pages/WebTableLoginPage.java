package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {
    public WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(name = "username")
    public WebElement inputUsername;

    @FindBy(name = "password")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;

    /**
     * aşağıdaki üç method da aynı işi görüyor sen hangisini istersen kullan
     * ikisi de sayfaya gidip gerekli yerleri doldurup giriş yapıyor yukarıda
     * locate ettiğin verilere göre...
     */

    /**
     * No parameters.
     * When we call this method, it will directly login using
     * Username: Test
     * Password: Tester
     */
    public void login(){
        this.inputUsername.sendKeys("Test");
        this.inputPassword.sendKeys("Tester");
        this.loginButton.click();

    }

    /**
     * This method will accept two argument and login
     * @param username
     * @param password
     */
    public void login(String username, String password){

        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    /**
     * This method will log in using credentials
     * form configuration.properties
     */
    public void loginWithConfig(){
        inputUsername.sendKeys(ConfigurationReader.getProperty("webTableUsername"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("webTablePw"));
        loginButton.click();
    }



}
