package com.LibraryCT.step_defs;

import com.LibraryCT.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class google {
    @When("user is on")
    public void user_is_on() {
        Driver.getDriver().get("https://www.google.com/");
    }
    @Then("verify")
    public void verify() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Google"));
        Driver.closeDriver();
    }
}
