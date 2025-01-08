package com.roel.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;

public class LoginSteps {

    private WebDriver driver;

    private WebElement usernameField = driver.findElement(By.id("username"));
    private WebElement passwordField = driver.findElement(By.id("password"));
    private WebElement loginButton = driver.findElement(By.id("loginButton"));
    private WebElement errorMessage = driver.findElement(By.id("errorMessage"));

    @Given("que estou na pagina de login")
    public void i_am_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https:/test.com/login");
    }

    @When("eu insiro um nome de usuario e senha corretos")
    public void i_enter_correct_username_and_password() {

        usernameField.sendKeys("correctUsername");
        passwordField.sendKeys("correctPassword");
        loginButton.click();
    }

    @When("eu clico no botao de login")
    public void eu_clico_no_botao_de_login() {
        loginButton.click();
    }
    @When("eu insiro um nome de usuário e senha incorretos")
    public void i_enter_incorrect_username_and_password() {

        usernameField.sendKeys("wrongUsername");
        passwordField.sendKeys("wrongPassword");
        loginButton.click();
    }

    @Then("devo ser redirecionado para a página inicial")
    public void i_should_be_redirected_to_the_home_page() {
        String expectedUrl = "https://test.com/home";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }
    @Then("o campo de usuário está presente")
    public void the_username_field_is_present() {
        Assert.assertTrue(usernameField.isDisplayed());
    }

    @Then("o campo de senha está presente")
    public void the_password_field_is_present() {
        Assert.assertTrue(passwordField.isDisplayed());
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        Assert.assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }
}
