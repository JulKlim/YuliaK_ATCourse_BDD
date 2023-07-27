package com.epam.tc.hw5.common;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DifferentElementsMainContent {
    final WebDriver driver;
    final WebDriverWait wait;
    final WebElement checkboxWater;
    final WebElement checkboxWind;
    final WebElement radioSelen;
    final WebElement colorsDropdown;
    final WebElement yellowColor;

    public DifferentElementsMainContent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.checkboxWater = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@class='checkbox-row']/*[1]")));
        this.checkboxWind = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//div[@class='checkbox-row']/*[3]")));
        this.radioSelen = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("div:nth-child(3) > label:nth-child(4)")));
        this.colorsDropdown = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector(".colors")));
        this.yellowColor = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//select[@class='uui-form-element']/*[4]")));
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
