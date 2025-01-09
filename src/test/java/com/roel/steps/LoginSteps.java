package com.roel.steps;

import com.roel.pages.LoginPage;
import com.roel.pages.MainPage;
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
    LoginPage loginPage;
    MainPage mainPage;
    private WebElement usernameField = driver.findElement(By.id("username"));
    private WebElement passwordField = driver.findElement(By.id("password"));
    private WebElement loginButton = driver.findElement(By.id("loginButton"));

    private WebElement errorPasswordMessage = driver.findElement(By.id("errorPasswordMessage"));


    @Given("que estou na pagina de login")
    public void i_am_on_the_login_page() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https:/test.com/login");
    }

    @When("eu insiro um nome de usuario e senha corretos")
    public void i_enter_correct_username_and_password() {

        eu_insiro_um_nome_de_usuario_corretamente();
        eu_insiro_uma_senha_de_usuario_corretamente();
    }

    @When("eu clico no botao de login")
    public void eu_clico_no_botao_de_login() {
        loginPage.clickLogin();
    }

    @When("eu insiro um nome de usuario corretamente")
    public void eu_insiro_um_nome_de_usuario_corretamente() {

        loginPage.fillUser("correctUsername");

    }

    @When("eu insiro a senha incorretamente")
    public void eu_insiro_a_senha_incorretamente() {

        loginPage.fillPassword("wrongPassword");

    }

    @When("eu insiro o nome de usuario incorretamente")
    public void eu_insiro_o_nome_de_usuario_incorretamente() {

        loginPage.fillUser("wrongUsername");

    }
    @When("eu insiro uma senha de usuario corretamente")
    public void eu_insiro_uma_senha_de_usuario_corretamente() {

        loginPage.fillPassword("correctPassword");

    }

    @When("eu insiro um nome de usuário e senha incorretos")
    public void eu_insiro_um_nome_de_usuário_e_senha_incorretos() {

        eu_insiro_uma_senha_de_usuario_corretamente();
        eu_insiro_a_senha_incorretamente();
    }
    @Then("devo ser redirecionado para a pagina inicial")
    public void devo_ser_redirecionado_para_a_pagina_inicial() {
        String expectedUrl = mainPage.mainURLText();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        driver.quit();
    }
    @Then("o campo de usuário esta presente")
    public void o_campo_de_usuário_esta_presente() {

        Assert.assertTrue(loginPage.usernameFieldDisplayed());
    }

    @Then("o campo de senha está presente")
    public void o_campo_de_senha_esta_presente() {

        Assert.assertTrue(loginPage.passwordFieldDisplayed());
    }

    @Then("mensagem de erro de senha incorreta")
    public void mensagem_de_erro_de_senha_incorreta() {
        Assert.assertTrue(loginPage.errorPasswordMessageDisplayed());

    }
    @Then("mensagem de erro de usuario inexistente")
    public void mensagem_de_erro_de_usuario_incorreta() {
        Assert.assertTrue(loginPage.errorUsernameMessageDisplayed());
    }
}
