package com.epam.tc.hw5.common.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsMainContent {
    final WebDriver driver;
    @FindBy(xpath = "//div[@class='checkbox-row']/*[1]")
    private WebElement checkboxWater;
    @FindBy(xpath = "//div[@class='checkbox-row']/*[3]")
    private WebElement checkboxWind;
    @FindBy(css = "div:nth-child(3) > label:nth-child(4)")
    private WebElement radioSelen;
    @FindBy(css = ".colors")
    private WebElement colorsDropdown;
    @FindBy(xpath = "//select[@class='uui-form-element']/*[4]")
    private WebElement yellowColor;

    public DifferentElementsMainContent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DifferentElementsMainContent selectWater() {
        if (checkboxWater.getText().equals("Water")) {
            checkboxWater.click();
        }
        return this;
    }

    public void selectWind() {
        if (checkboxWind.getText().equals("Wind")) {
            checkboxWind.click();
        }
    }

    public DifferentElementsMainContent selectRadioSelen() {
        if (radioSelen.getText().equals("Selen")) {
            radioSelen.click();
        }
        return this;
    }

    public DifferentElementsMainContent selectDropdown() {
        colorsDropdown.click();
        return this;
    }

    public void selectYellow() {
        if (yellowColor.getText().equals("Yellow")) {
            yellowColor.click();
        }
    }
}
