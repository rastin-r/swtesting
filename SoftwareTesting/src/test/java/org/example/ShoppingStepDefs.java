package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingStepDefs extends AbstractStepDefs {

    @Given("the {string} is added to the cart")
    public void somethingIsAddedToTheCart(String item) {
        homePage.addItemToCart(item);
    }

    @Then("the price should read {string}")
    public void thePriceShouldRead(String total) {
        assertEquals(total, homePage.getTotal());
    }

    @Then("the shopping cart must be emptied")
    public void theShoppingCartMustBeEmpty() { homePage.emptyCart();}


    @Then("the checkout error {string} is shown")
    public void theCheckoutErrorCheckoutErrorMessageIsShown(String checkoutError) {
        assertEquals(checkoutError, homePage.getCheckOutErrorMessage());
    }
}
