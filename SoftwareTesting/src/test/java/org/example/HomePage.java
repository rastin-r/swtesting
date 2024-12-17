package org.example;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Set;


import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {

    private static final String PAGE_URL = "https://www.saucedemo.com/";

    private final WebDriver driver;

    @FindBy(css = "#login_button_container > div > form > div.error-message-container.error > h3")
    private WebElement errorMessage;
    @FindBy(css = "#checkout_summary_container > div > div.summary_info > div.summary_total_label")
    private WebElement priceLabel;

    private static final Map<String, By> textFields = Map.of(
            "Username", By.id("user-name"),
            "Password", By.id("password"),
            "First Name", By.id("first-name"),
            "Last Name", By.id("last-name"),
            "Zip Code", By.id("postal-code")
    );

    private static final Map<String, By> itemButtons = Map.of(
            "Sauce Labs Backpack", By.id("add-to-cart-sauce-labs-backpack"),
            "Sauce Labs Bike Light", By.id("add-to-cart-sauce-labs-bike-light"),
            "Sauce Labs Bolt T-Shirt", By.id("add-to-cart-sauce-labs-bolt-t-shirt"),
            "Sauce Labs Fleece Jacket", By.id("add-to-cart-sauce-labs-fleece-jacket"),
            "Sauce Labs Onesie", By.id("add-to-cart-sauce-labs-onesie"),
            "Test.allTheThings() T-Shirt (Red)", By.id("add-to-cart-test.allthethings()-t-shirt-(red)")
    );

    private static final Map<String, By> navigationButtons = Map.ofEntries(
            Map.entry("Login", By.id("login-button")),
            Map.entry("Cart", By.className("shopping_cart_link")),
            Map.entry("Checkout", By.id("checkout")),
            Map.entry("Menu", By.id("react-burger-menu-btn")),
            Map.entry("Continue", By.id("continue")),
            Map.entry("Arrangement", By.className("product_sort_container")),
            Map.entry("Logout", By.id("logout_sidebar_link")),
            Map.entry("Twitter", By.className("social_twitter")),
            Map.entry("Facebook", By.className("social_facebook")),
            Map.entry("LinkedIn", By.className("social_linkedin")),
            Map.entry("About", By.id("about_sidebar_link"))
    );


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public void closePage() {
        driver.quit();
    }

    public void fillOutField(String field, String text) {
        driver.findElement(textFields.get(field)).sendKeys(text);
    }

    public void clickButton(String button) {
        driver.findElement(navigationButtons.get(button)).click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void addItemToCart(String item) {
        driver.findElement(itemButtons.get(item)).click();
    }

    public String getTotal() {
        return priceLabel.getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }


    public String getRedirectedUrl() {

        // Capture the current window handle
        String mainWindowHandle = driver.getWindowHandle();

        // Wait for a new window or tab to open
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.getWindowHandles().size() > 1);

        // Initialize variable to store redirected URL
        String redirectedUrl = null;

        // Get all window handles and find the new one using Set<String>
        Set<String> allHandles = driver.getWindowHandles();
        allHandles.remove(mainWindowHandle);  // Remove the main window handle

        // If a new window is found, switch to it and retrieve its URL
        if (!allHandles.isEmpty()) {
            String newHandle = allHandles.iterator().next(); // Get the new handle
            driver.switchTo().window(newHandle);  // Switch to the new window
            redirectedUrl = driver.getCurrentUrl();  // Capture the URL of the new tab
            driver.close();  // Close the new tab
        }

        // Switch back to the original window
        driver.switchTo().window(mainWindowHandle);

        return redirectedUrl;
    }



}
