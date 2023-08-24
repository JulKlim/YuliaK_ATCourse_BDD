package com.epam.tc.hw5.common.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;
    @FindBy(css = "#user-icon")
    private WebElement dropdownMenu;
    @FindBy(css = "#name")
    private WebElement loginField;
    @FindBy(css = "#password")
    private WebElement passField;
    @FindBy(css = "#login-button")
    private WebElement enter;
    @FindBy(css = "#user-name")
    private WebElement username;
    @FindBy(css = ".menu-title[index='3']")
    private WebElement menuService;
    @FindBy(linkText = "Different elements")
    private WebElement differentElements;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public String checkTitle() {
        return driver.getTitle();
    }

    public HomePage performLogin(String username, String password) {
        dropdownMenu.click();
        loginField.sendKeys(username);
        passField.sendKeys(password);
        enter.click();
        return this;
    }

    public String assertUsername() {
        return username.getText();
    }

    public void openDifferentElements() {
        menuService.click();
        differentElements.click();
    }
}
