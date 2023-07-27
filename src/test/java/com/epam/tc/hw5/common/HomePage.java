package com.epam.tc.hw5.common;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
    final WebDriver driver;
    final WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public HomePage openHomePage() {
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
        return this;
    }

    public String checkTitle() {
        return driver.getTitle();
    }

    public HomePage performLogin(String username, String password) {
        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-icon")));
        dropdownMenu.click();

        WebElement loginField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#name")));
        loginField.sendKeys(username);

        WebElement passField = driver.findElement(By.cssSelector("#password"));
        passField.sendKeys(password);

        WebElement enter = driver.findElement(By.cssSelector("#login-button"));
        enter.click();

        return this;
    }

    public String assertUsername() {
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-name")));
        return username.getText();
    }

    public void openDifferentElements() {
        WebElement menuService = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector(".menu-title[index='3']")));
        menuService.click();

        WebElement differentElements = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText("Different elements")));
        differentElements.click();
    }
}
