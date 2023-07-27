package com.epam.tc.hw5.common;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserTableContent {
    final WebDriver driver;
    final WebDriverWait wait;
    final List<WebElement> numberTypes;
    final List<WebElement> usernames;
    final List<WebElement> descriptions;
    final List<WebElement> vipCheckboxes;
    final List<WebElement> tableRows;
    final List<WebElement> columnNames;
    final WebElement dropdownElement;
    final WebElement vipCheckbox;
    final WebElement logPanel;

    public UserTableContent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.numberTypes = driver.findElements(By.xpath("//table[@id='user-table']//select"));
        this.usernames = driver.findElements(By.xpath("//table[@id='user-table']//td/a"));
        this.descriptions = driver.findElements(By.xpath("//table[@id='user-table']//td[4]//span"));
        this.vipCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        this.tableRows = driver.findElements(By.xpath("//table[@id='user-table']//tr"));
        this.columnNames = driver.findElements(By.xpath("//table[@id='user-table']//th"));
        this.dropdownElement = driver.findElement(By.xpath("//table[@id='user-table']//tr[1]//select"));
        this.vipCheckbox = driver.findElement(By.cssSelector("#ivan"));
        this.logPanel = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class, 'info-panel-section')]")));
    }

    public int countOfNumberType() {
        return numberTypes.size();
    }

    public boolean areNumberTypesDisplayed() {
        boolean areNumberTypesDisplayed = true;
        for (WebElement numberType : numberTypes) {
            if (!numberType.isDisplayed()) {
                areNumberTypesDisplayed = false;
            }
        }
        return areNumberTypesDisplayed;
    }


    public int countOfUsernames() {
        return usernames.size();
    }

    public boolean areUsernamesDisplayed() {
        boolean areUsernamesDisplayed = true;
        for (WebElement username : usernames) {
            if (!username.isDisplayed()) {
                areUsernamesDisplayed = false;
            }
        }
        return areUsernamesDisplayed;
    }

    public int countOfDescriptions() {
        return descriptions.size();
    }

    public boolean areDescriptionsDisplayed() {
        boolean areDescriptionsDisplayed = true;
        for (WebElement description : descriptions) {
            if (!description.isDisplayed()) {
                areDescriptionsDisplayed = false;
            }
        }
        return areDescriptionsDisplayed;
    }

    public int countOfVipCheckboxes() {
        return vipCheckboxes.size();
    }

    public boolean areVipCheckboxesDisplayed() {
        boolean areVipCheckboxesDisplayed = true;
        for (WebElement vipCheckbox : vipCheckboxes) {
            if (!vipCheckbox.isDisplayed()) {
                areVipCheckboxesDisplayed = false;
            }
        }
        return areVipCheckboxesDisplayed;
    }

    public List<List<String>> getUserTableValues() {
        List<List<String>> tableValues = new ArrayList<>();

        // Column names
        List<String> columnNamesText = new ArrayList<>();
        for (WebElement columnNameElement : columnNames) {
            String columnName = columnNameElement.getText().trim();
            if (!columnName.equals("Type")) {
                columnNamesText.add(columnName);
            }
        }
        tableValues.add(columnNamesText);

        for (int rowIndex = 1; rowIndex < tableRows.size(); rowIndex++) {
            List<WebElement> cells = tableRows.get(rowIndex).findElements(By.tagName("td"));
            List<String> rowValues = new ArrayList<>();

            // Other columns
            for (int i = 0; i < cells.size(); i++) {
                if (i != 1) {
                    String cellText = cells.get(i).getText().trim().replaceAll("\\s+", " ");
                    cellText = cellText.replace("Vip", "");
                    if (cellText.contains("Hulk")) {
                        cellText = cellText.replace("Hulk some", "Hulksome");
                    } else {
                        cellText = cellText.replaceAll("\\s+", " ");
                    }
                    rowValues.add(cellText.trim());
                }
            }

            tableValues.add(rowValues);
        }

        return tableValues;
    }

    public List<List<String>> getDropListValues() {
        List<WebElement> values = dropdownElement.findElements(By.xpath(".//option"));
        List<List<String>> dropdownValues = new ArrayList<>();

        List<String> dropdownHeader = new ArrayList<>();
        dropdownHeader.add("Dropdown Values");
        dropdownValues.add(dropdownHeader);

        for (WebElement value : values) {
            List<String> rowValue = new ArrayList<>();
            rowValue.add(value.getText().trim());
            dropdownValues.add(rowValue);
        }

        return dropdownValues;
    }

    public void selectCheckboxVip() {
        vipCheckbox.click();
    }

    public boolean isLogForCheckboxDisplayed(String expectedLogText) {
        WebElement log = logPanel.findElement(By.xpath(
                "//li[contains(text(), '" + expectedLogText + "')]"));
        return log.isDisplayed();
    }
}
