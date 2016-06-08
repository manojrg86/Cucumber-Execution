package com.automation.framework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

/**
 * An example of using TestNG when the test class does not inherit from 
 * AbstractTestNGCucumberTests but still executes each feature as a separate
 * TestNG test.
 */
@CucumberOptions(features="src/main/resources",format = {"json:target/cucumber-report-feature-composite.json"},glue ={"com"})
public class RunCukesByFeatureAndCompositionTest{
    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() throws Exception {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }
    
    /**
     * All logic that needs to be done before a scenario
     */
    @Before
    public void beforeScenario(){
    }

    /**
     * All logic that needs to be done after a scenario
     */
    @After
    public void afterScenario(){
    	
    }
    
    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    }
    
}
