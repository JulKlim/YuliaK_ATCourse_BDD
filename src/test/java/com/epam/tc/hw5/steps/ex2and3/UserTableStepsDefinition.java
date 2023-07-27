package com.epam.tc.hw5.steps.ex2and3;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw5.common.HomePage;
import com.epam.tc.hw5.common.HomePageHeaderButtons;
import com.epam.tc.hw5.common.UserTableContent;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class UserTableStepsDefinition {

    WebDriver driver;

    @Before
    public void webDriverSetUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
    }

    @Given("I open JDI GitHub site")
    public void openHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
    }

    @Given("I login as user {string}")
    public void performLogin(String username) {
        HomePage homePage = new HomePage(driver);
        homePage.performLogin("Roman", "Jdi1234");
        assertThat(homePage.assertUsername()).isEqualTo(username);
    }

    @When("I click on \"Service\" button in Header")
    public void openServiceDropdown() {
        HomePageHeaderButtons homePageHeaderButtons = new HomePageHeaderButtons(driver);
        homePageHeaderButtons.openServiceDropdown();
    }

    @When("I click on \"User Table\" button in Service dropdown")
    public void clickUserTableButton() {
        HomePageHeaderButtons homePageHeaderButtons = new HomePageHeaderButtons(driver);
        homePageHeaderButtons.clickOnUserTableButton();
    }

    @Then("{string} page should be opened")
    public void checkUserPageIsOpened(String expectedTitle) {
        HomePageHeaderButtons homePageHeaderButtons = new HomePageHeaderButtons(driver);
        homePageHeaderButtons.isTitleOnUserTableCorrect(expectedTitle);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void areNumberTypesDisplayed(int expectedCountOfNumberType) {
        UserTableContent userTableContent = new UserTableContent(driver);
        assertThat(userTableContent.countOfNumberType()).isEqualTo(expectedCountOfNumberType);
        assertThat(userTableContent.areNumberTypesDisplayed())
                .as("Number Type dropdowns are displayed").isTrue();
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void areUsernamesDisplayed(int expectedNumberOfUsernames) {
        UserTableContent userTableContent = new UserTableContent(driver);
        assertThat(userTableContent.countOfUsernames()).isEqualTo(expectedNumberOfUsernames);
        assertThat(userTableContent.areUsernamesDisplayed())
                .as("Usernames are displayed").isTrue();
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void areDescriptionTextsDisplayed(int expectedNumberOfDescriptions) {
        UserTableContent userTableContent = new UserTableContent(driver);
        assertThat(userTableContent.countOfDescriptions()).isEqualTo(expectedNumberOfDescriptions);
        assertThat(userTableContent.areDescriptionsDisplayed())
                .as("Description texts under images are displayed").isTrue();
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void areCheckboxesDisplayed(int expectedNumberOfCheckboxes) {
        UserTableContent userTableContent = new UserTableContent(driver);
        assertThat(userTableContent.countOfVipCheckboxes()).isEqualTo(expectedNumberOfCheckboxes);
        assertThat(userTableContent.areVipCheckboxesDisplayed())
                .as("Vip checkboxes are displayed").isTrue();
    }

    @Then("User table should contain following values:")
    public void verifyUserTableValues(List<List<String>> expectedTableValues) {
        UserTableContent userTableContent = new UserTableContent(driver);
        assertThat(userTableContent.getUserTableValues()).isEqualTo(expectedTableValues);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void verifyDropList(List<List<String>> expectedDropListValues) {
        UserTableContent userTableContent = new UserTableContent(driver);
        assertThat(userTableContent.getDropListValues()).isEqualTo(expectedDropListValues);
    }

    @Then("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectCheckboxVip() {
        UserTableContent userTableContent = new UserTableContent(driver);
        userTableContent.selectCheckboxVip();
    }

    @Then("1 log row has {string} text in log section")
    public void verifyLogForVipCheckboxDisplayed(String expectedLogText) {
        UserTableContent userTableContent = new UserTableContent(driver);
        assertThat(userTableContent.isLogForCheckboxDisplayed(expectedLogText))
                .as("Log for checkbox Vip is displayed").isTrue();
    }


    @After
    public void closing() {
        driver.quit();
    }
}
