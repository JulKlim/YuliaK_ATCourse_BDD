package com.epam.tc.hw5.common;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePageHeaderButtons {

    final WebDriver driver;
    final WebDriverWait wait;

    public HomePageHeaderButtons(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openServiceDropdown() {
        WebElement serviceDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".dropdown-toggle")));
        serviceDropdown.click();
    }

    public void clickOnUserTableButton() {
        WebElement userTableButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'User Table')]")));
        userTableButton.click();
    }

    public void isTitleOnUserTableCorrect(String expectedTitle) {
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = driver.getTitle();
        assertThat(actualTitle).isEqualTo(expectedTitle);
    }
}
