package com.roel.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Browsers {

    private static String downloadPath = GlobalParameters.DOWNLOAD_DEFAULT_PATH;
    private static String seleniumHub = GlobalParameters.SELENIUM_HUB;

    public static WebDriver getLocalChrome(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("no-sandbox");
        chromeOptions.addArguments("--allow-running-insecure-content");
        chromeOptions.addArguments("--lang=en-US");
        chromeOptions.addArguments("download.default_directory", downloadPath);

        WebDriverManager.chromedriver().setup();
        return new ChromeDriver(chromeOptions);
    }

    public static WebDriver getRemoteChrome(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("no-sandbox");
        chromeOptions.addArguments("--allow-running-insecure-content");
        chromeOptions.addArguments("--lang=en-US");
        chromeOptions.addArguments("download.default_directory", downloadPath);

        //ChromeOptions options = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.merge(capabilities);

        WebDriverManager.chromedriver().setup();

        URL url = null;
        try {
            url = new URL(seleniumHub);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new RemoteWebDriver(url, capabilities);
    }

    public static WebDriver getLocalChromeHeadless(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("download.default_directory", downloadPath);
        chromeOptions.addArguments("--headless");

        return new ChromeDriver(chromeOptions);
    }

    public static WebDriver getRemoteChromeHeadless(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("download.default_directory", downloadPath);
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--lang=en-US");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("window-size=1280,800");

        chromeOptions.addArguments("--incognito");
        chromeOptions.setAcceptInsecureCerts(true);
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        chromeOptions.merge(capabilities);

        URL url = null;
        try {
            url = new URL(seleniumHub);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new RemoteWebDriver(url, capabilities);
    }
/*
    public static WebDriver getLocalFirefox(){
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--lang=en-US");
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver(firefoxOptions);
    }

    public static WebDriver getRemoteFirefox(){
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--lang=en-US");
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
        URL url = null;
        try {
            url = new URL(seleniumHub);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new RemoteWebDriver(url, capabilities);
    }

    public static WebDriver getLocalEdgeExplorer() {
        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--lang=en-US");
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(capabilities);
    }

    public static WebDriver getRemoteEdgeExplorer() {
        DesiredCapabilities capabilities = DesiredCapabilities.edge();

        URL url = null;
        try {
            url = new URL(seleniumHub);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new RemoteWebDriver(url, capabilities);
    }*/
}
