package com.project.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class RpnCalculatorStepdefs {

    @Given("^a calculator I just turned on$")
    public void a_calculator_I_just_turned_on() {
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void adding(int arg1, int arg2) {
        
    }

    @Given("^I press (.+)$")
    public void I_press(String what) {
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(double expected) {
        assertEquals(expected, 11);
    }

    @Before({"~@foo"})
    public void before() {
        System.out.println("Runs before scenarios *not* tagged with @foo");
    }

    @After
    public void after(Scenario scenario) {
        // result.write("HELLLLOO");
    }

    @Given("^the previous entries:$")
    public void thePreviousEntries(List<Entry> entries) {
        
    }

    public class Entry {
        Integer first;
        Integer second;
        String operation;
    }
}
