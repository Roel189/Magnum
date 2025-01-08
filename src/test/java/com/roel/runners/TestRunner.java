package com.roel.runners;

import com.roel.bases.TestBase;
import io.cucumber.core.options.Constants;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/roel/steps")
@ConfigurationParameter(key = Constants.FEATURES_PROPERTY_NAME,value = "src/test/java/com/roel/features/cadastro.feature")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "com/roel/steps")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@login")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/cucumber.html")


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "com/roel/steps"
)
public class TestRunner {
    TestBase testBase = new TestBase(); // Create an instance of TestBase

    @BeforeClass
    public void beforeClass(){
        testBase.beforeClass();
    }
}
