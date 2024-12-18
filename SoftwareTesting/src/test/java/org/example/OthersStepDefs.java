package org.example;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OthersStepDefs extends AbstractStepDefs{
    @Then("the user gets redirected to {string}")
    public void verifyUserRedirectionToUrl(String expectedUrl) {
        String currentUrl = homePage.getRedirectedUrl();
        assertEquals(expectedUrl, currentUrl, "The user was not redirected to the correct URL.");
    }

    @Then("all product thumbnails should be visible")
    public void allProductThumbnailsShouldBeVisible() {
        // Locate all product thumbnails using a CSS selector
        List<WebElement> productImages = homePage.locateThumbnail();

        // Verify that all images are displayed
        for (WebElement image : productImages) {
            assertTrue(image.isDisplayed(), "Thumbnail is not displayed: " + image.getAttribute("src"));
        }
    }


}
