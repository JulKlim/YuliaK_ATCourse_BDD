package com.epam.tc.hw5.common;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DifferentElementsLog {

    final WebDriver driver;
    final WebDriverWait wait;
    final WebElement waterLog;
    final WebElement windLog;
    final WebElement selenLog;
    final WebElement yellowLog;

    public DifferentElementsLog(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.waterLog = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
                                + "Water: condition changed to true" + "')]"))
        );
        this.windLog = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
                                + "Wind: condition changed to true" + "')]")));
        this.selenLog = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
                                + "metal: value changed to  Selen" + "')]")));
        this.yellowLog = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
                                + "Colors: value changed to Yellow" + "')]")));
    }

    public boolean isLogRowForWaterDisplayed() {
        return waterLog.isDisplayed();
    }

    public boolean isLogRowForWindDisplayed() {
        return windLog.isDisplayed();
    }

    public boolean isLogRowRadioDisplayed() {
        return selenLog.isDisplayed();
    }

    public boolean isLogDropdownDisplayed() {
        return yellowLog.isDisplayed();
    }
}
