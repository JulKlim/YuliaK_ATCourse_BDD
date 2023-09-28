package com.epam.tc.hw5.common.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsLog {
    final WebDriver driver;
    @FindBy(xpath = "//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
        + "Water: condition changed to true" + "')]")
    private WebElement waterLog;
    @FindBy(xpath = "//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
        + "Wind: condition changed to true" + "')]")
    private WebElement windLog;
    @FindBy(xpath = "//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
        + "metal: value changed to  Selen" + "')]")
    private WebElement selenLog;
    @FindBy(xpath = "//ul[contains(@class, 'panel-body-list')]/li[contains(text(), '"
        + "Colors: value changed to Yellow" + "')]")
    private WebElement yellowLog;

    public DifferentElementsLog(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
