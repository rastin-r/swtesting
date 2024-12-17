package org.example;

import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OthersStepDefs extends AbstractStepDefs{
    @Then("the user gets redirected to {string}")
    public void verifyUserRedirectionToUrl(String expectedUrl) {
        String currentUrl = homePage.getRedirectedUrl();
        assertEquals(expectedUrl, currentUrl, "The user was not redirected to the correct URL.");
    }

}
