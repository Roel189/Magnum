package com.roel.bases;

import com.roel.utils.CustomTestWatcher;
import com.roel.utils.DriverFactory;
import com.roel.utils.ExtentReportUtils;
import com.roel.utils.GlobalParameters;
//import cucumber.api.annotation.Before;
import io.cucumber.java.After;
import io.cucumber.java.Before;

//import org.junit.After;
//import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Method;

public class TestBase {
    @Rule
    public CustomTestWatcher watcher = new CustomTestWatcher();
    @BeforeClass
    public void beforeClass() {
        new GlobalParameters();
        ExtentReportUtils.createReport();
    }

    @Before
    public void beforeScenario() {
        new GlobalParameters();
        ExtentReportUtils.createReport();
        ExtentReportUtils.addTest("Default Test", this.getClass().getSimpleName());
        DriverFactory.createInstance();
        WebDriver driver = DriverFactory.INSTANCE;
        driver.manage().window().maximize();
        driver.navigate().to(GlobalParameters.URL_DEFAULT);
    }
    /*@Before
    public void before(Method method) {
        ExtentReportUtils.addTest(method.getName(), method.getDeclaringClass().getSimpleName());
        DriverFactory.createInstance();
        WebDriver driver = DriverFactory.INSTANCE;
        driver.manage().window().maximize();
        driver.navigate().to(GlobalParameters.URL_DEFAULT);
    }
    //@Before
   /* public void setUp() {
        ExtentReportUtils.addTest("Default Test", this.getClass().getSimpleName());
        DriverFactory.createInstance();
        WebDriver driver = DriverFactory.INSTANCE;
        driver.manage().window().maximize();
        driver.navigate().to(GlobalParameters.URL_DEFAULT);
    }*/
    @After
    public void afterScenario() {
        ExtentReportUtils.addTestResult(watcher);
        DriverFactory.quitInstance();
    }


}
