package com.project.steps;

import cucumber.api.Transformer;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.deps.com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ShoppingStepdefs {

    @Given("^the following groceries:$")
    public void the_following_groceries(List<Grocery> groceries) {
        
    }

    @When("^I pay (\\d+)$")
    public void i_pay(int amount) {
        
    }

    @Then("^my change should be (\\d+)$")
    public void my_change_should_be_(int change) {
        assertEquals(-5, change);
    }

    public static class Grocery {
        public String name;
        @XStreamConverter(Price.Converter.class)
        public Price price;

        public Grocery() {
            super();
        }
    }

    public static class Price {
        public int value;

        public Price(int value) {
            this.value = value;
        }

        public static class Converter extends Transformer<Price> {
            @Override
            public Price transform(String value) {
                return new Price(Integer.parseInt(value));
            }
        }
    }
}
