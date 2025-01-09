package com.roel.pages;

import com.roel.bases.PageBase;
import org.openqa.selenium.By;

public class MainPage extends PageBase {
    //Mapping
    By mainURL = By.linkText("https:/test.com/home");

    public String mainURLText(){
        return getText(mainURL);
    }



}
