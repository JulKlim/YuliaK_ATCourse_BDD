package com.epam.tc.hw5.common.pages;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageHeaderButtons {

    final WebDriver driver;
    @FindBy(css = ".dropdown-toggle")
    private WebElement serviceDropdown;
    @FindBy(xpath = "//a[contains(text(), 'User Table')]")
    private WebElement userTableButton;

    public HomePageHeaderButtons(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openServiceDropdown() {
        serviceDropdown.click();
    }

    public void clickOnUserTableButton() {
        userTableButton.click();
    }

    public String isTitleOnUserTableCorrect() {
        String actualTitle = driver.getTitle();
        return actualTitle;
    }
}
