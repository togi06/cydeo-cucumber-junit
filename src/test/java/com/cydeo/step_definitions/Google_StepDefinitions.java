package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Google_StepDefinitions {


    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    @When("user types apple and clicks enter")
    public void user_types_and_clicks_enter2() {
        WebElement cookies = Driver.getDriver().findElement(By.xpath("//div[.='Tümünü kabul et']"));
        cookies.click();

        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
    }

    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String searchKeyword) {
        WebElement cookies = Driver.getDriver().findElement(By.xpath("//div[.='Tümünü kabul et']"));
        cookies.click();

            googleSearchPage.searchBox.sendKeys(searchKeyword + Keys.ENTER);
    }
    @Then("user sees {string} in the google title")
    public void user_sees_in_the_google_title(String string) {

        String expectedTitle = string+" - Google'da Ara";
        String actualTitle = Driver.getDriver().getTitle();

        //JUnıt assertion accepts first  argument as expected , second arg as actual
        Assert.assertEquals( "Title is not expected",expectedTitle,actualTitle);


    }

    @Then("user sees apple in the google title")
    public void userSeesAppleInTheGoogleTitle() {
        String expectedTitle = "apple - Google'da Ara";
        String actualTitle = Driver.getDriver().getTitle();

        //JUnıt assertion accepts first  argument as expected , second arg as actual
        Assert.assertEquals( "Title is not expected",expectedTitle,actualTitle);
       // 2. Yol -  Assert.assertTrue(actualTitle.equals(expectedTitle));

        Driver.closeDriver();
    }

    @When("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.getDriver().get("https://www.google.com");


    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {
        
        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);


    }

    @When("user gets the cookies")
    public void user_gets_the_cookies() {
       WebElement cookies = Driver.getDriver().findElement(By.xpath("//div[.='Tümünü kabul et']"));
       cookies.click();
    }
    @Then("user clicks and accept them")
    public void user_clicks_and_accept_them() {



    }



}
