package com.example.cucumber;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginSteps {
    public WebDriver driver;

    @Given("navigate to Phone book root path")
    public void navigateToLoginPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://phonebook.telran-edu.de:8080/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Then("PhoneBook Login page appears")
    public void phonebookLoginPageAppears() {
        Assert.assertTrue(
                isElementPresent(By.cssSelector("body > app-root > app-login > div > div.col-xl-6.text-right.text-white.bg-dark > div > div > h2"))
        );
    }

    @Given("Enter valid username and password")
    public void enter_valid_username_and_password() {
        type( By.cssSelector("#defaultRegisterFormEmail") , "test@gmail.com" );
        type( By.cssSelector("#login-form > div:nth-child(2) > div.col-sm-5 > div > input") , "test@gmail.com" );
    }
    @Given("Click on login button")
    public void click_on_login_button() {
        driver.findElement(By.cssSelector("#login-form > div:nth-child(3) > div.col-sm-5 > button")).click();
    }
    @Then("SignOut button is shown")
    public void sign_out_button_is_shown() {
        Assert.assertTrue(
            isElementPresent(By.cssSelector("body > app-root > app-home-page > app-header > nav > div > div:nth-child(3) > button:nth-child(2)"))
        );
    }

    @After
    public void tearDown() {
        driver.close();
    }

    private boolean isElementPresent(By cssSelector) {
        return driver.findElements(cssSelector).size()>0;
    }

    public void type(By selector, String text){
        driver.findElement(selector).click();
        driver.findElement(selector).sendKeys(text);
    }
}
