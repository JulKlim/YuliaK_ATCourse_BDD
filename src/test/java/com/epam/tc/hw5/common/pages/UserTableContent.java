package com.epam.tc.hw5.common.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTableContent {
    final WebDriver driver;
    @FindBy(xpath = "//table[@id='user-table']//select")
    private List<WebElement> numberTypes;
    @FindBy(xpath = "//table[@id='user-table']//td/a")
    private List<WebElement> usernames;
    @FindBy(xpath = "//table[@id='user-table']//td[4]//span")
    private List<WebElement> descriptions;
    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> vipCheckboxes;
    @FindBy(xpath = "//table[@id='user-table']//tr")
    private List<WebElement> tableRows;
    @FindBy(xpath = "//table[@id='user-table']//th")
    private List<WebElement> columnNames;
    @FindBy(xpath = "//table[@id='user-table']//tr[1]//select")
    private WebElement dropdownElement;
    @FindBy(css = "#ivan")
    private WebElement vipCheckbox;
    @FindBy(xpath = "//div[contains(@class, 'info-panel-section')]")
    private WebElement logPanel;

    public UserTableContent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int countOfNumberType() {
        return numberTypes.size();
    }

    public boolean areNumberTypesDisplayed() {
        return numberTypes.stream()
                          .allMatch(WebElement::isDisplayed);
    }

    public int countOfUsernames() {
        return usernames.size();
    }

    public boolean areUsernamesDisplayed() {
        return usernames.stream()
                        .allMatch(WebElement::isDisplayed);
    }

    public int countOfDescriptions() {
        return descriptions.size();
    }

    public boolean areDescriptionsDisplayed() {
        return descriptions.stream()
                           .allMatch(WebElement::isDisplayed);
    }

    public int countOfVipCheckboxes() {
        return vipCheckboxes.size();
    }

    public boolean areVipCheckboxesDisplayed() {
        return vipCheckboxes.stream()
                            .allMatch(WebElement::isDisplayed);
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

    public List<String> getDropListValues() {
        List<WebElement> values = dropdownElement.findElements(By.xpath(".//option"));
        List<String> dropdownValues = new ArrayList<>();

        for (WebElement value : values) {
            dropdownValues.add(value.getText().trim());
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
