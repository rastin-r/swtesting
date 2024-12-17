package org.example;

import io.cucumber.java.en.Then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDefs extends AbstractStepDefs {

    @Then("the {string} message is shown")
    public void theErrorMessageMessageIsShown(String errorMessage) {
        assertEquals(errorMessage, homePage.getErrorMessage());
    }

    @Then("the user enters {string}")
    public void theUserEnters(String url) {
        assertEquals(url, homePage.getCurrentUrl());
    }

}
