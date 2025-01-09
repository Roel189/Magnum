package com.roel.pages;

import com.roel.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    //Mapping
    By usernameField = By.name("username");
    By passwordField = By.id("password");
    By loginButton = By.xpath("/html/body/div[2]/form/button");
    By loginErroTextArea = By.xpath("//div[@class='alert alert-danger']/p");
    By successTextArea = By.xpath("//div[@class='alert alert-success center']/p[2]");
    By lostPasswordLink = By.xpath("//fieldset/a");
    By successLogin = By.xpath("//div[@class='alert alert-success center']/p[2]");
    By errorUsernameMessage = By.id("errorUsernameMessage");
    By errorPasswordMessage = By.id("errorPasswordMessage");

    //Actions
    public void fillUser(String usuario){
        sendKeys(usernameField, usuario);
    }

    public void fillPassword(String senha){
        sendKeys(passwordField, senha);
    }

    public String errorPasswordMessageText(){

        return  getText(errorPasswordMessage);
    }
    public String errorUsernameMessageText(){

        return  getText(errorUsernameMessage);
    }
    public boolean errorUsernameMessageDisplayed(){
        return returnIfElementIsDisplayed(errorUsernameMessage);
    }
    public boolean errorPasswordMessageDisplayed(){
        return returnIfElementIsDisplayed(errorPasswordMessage);
    }
    public boolean usernameFieldDisplayed(){
        return returnIfElementIsDisplayed(usernameField);
    }
    public boolean passwordFieldDisplayed(){
        return returnIfElementIsDisplayed(passwordField);
    }
    public void clickLogin(){
        click(loginButton);
    }

    public String returnErrorMessage(){
        return getText(loginErroTextArea);
    }

    public String returnSuccessMessage(){
        return getText(successTextArea);
    }

    public void fillUserJs(String usuario){
        SendKeysJavaScript(usernameField, usuario);
    }

    public void fillPasswordJs(String password){
        SendKeysJavaScript(passwordField, password);
    }

    public void clickLoginJS(){
        ClickJavaScript(loginButton);
    }

    public String getCurrentUrl(){
        return getURL();
    }

    public void clickLostPassword(){
        click(lostPasswordLink);
    }
}







