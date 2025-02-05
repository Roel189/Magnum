package com.roel.utils;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver INSTANCE = null;

    public static void createInstance(){
        String browser = GlobalParameters.BROWSER_DEFAULT;
        String execution = GlobalParameters.EXECUTION;

        if (INSTANCE==null){
            if(execution.equals("local")){
                if(browser.equals("chrome")){
                    INSTANCE = Browsers.getLocalChrome();
                }else if(browser.equals("chromeHeadless")){
                    INSTANCE = Browsers.getLocalChromeHeadless();
                }else if(browser.equals("firefox")){
                    // INSTANCE = Browsers.getLocalFirefox();
                }else if (browser.equals("edge")){
                    //INSTANCE = Browsers.getLocalEdgeExplorer();
                }else{
                    try{
                        throw new Exception("O browser informado não existe ou não é suportado pela automação");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            if(execution.equals("remote")){
                if(browser.equals("chrome")){
                    INSTANCE = Browsers.getRemoteChrome();
                }else if(browser.equals("chromeHeadless")){
                    INSTANCE = Browsers.getRemoteChromeHeadless();
                }else if(browser.equals("firefox")){
                    //INSTANCE = Browsers.getRemoteFirefox();
                }else if (browser.equals("edge")){
                    //INSTANCE = Browsers.getRemoteEdgeExplorer();
                }else{
                    try{
                        throw new Exception("O browser informado não existe ou não é suportado pela automação");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void quitInstance(){
        INSTANCE.quit();
        INSTANCE = null;
    }
}
