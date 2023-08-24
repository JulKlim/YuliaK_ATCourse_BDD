package com.epam.tc.hw5.steps.ex2and3;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw5.common.pages.HomePage;
import com.epam.tc.hw5.common.pages.HomePageHeaderButtons;
import com.epam.tc.hw5.common.pages.UserTableContent;
import com.epam.tc.hw5.hooks.BaseHooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class UserTableStepsDefinition {

    WebDriver driver = BaseHooks.getDriver();
    SoftAssertions softAssertions = new SoftAssertions();

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
        softAssertions.assertThat(userTableContent.countOfNumberType()).isEqualTo(expectedCountOfNumberType);
        softAssertions.assertThat(userTableContent.areNumberTypesDisplayed())
                      .as("Number Type dropdowns are displayed").isTrue();
        softAssertions.assertAll();
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void areUsernamesDisplayed(int expectedNumberOfUsernames) {
        UserTableContent userTableContent = new UserTableContent(driver);
        softAssertions.assertThat(userTableContent.countOfUsernames()).isEqualTo(expectedNumberOfUsernames);
        softAssertions.assertThat(userTableContent.areUsernamesDisplayed())
                      .as("Usernames are displayed").isTrue();
        softAssertions.assertAll();
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

    @Then("^droplist should contain values in column Type for user (.*)$")
    public void verifyDropList(String username, DataTable dataTable) {
        List<String> expectedDropListValues = dataTable.asList(String.class).subList(1, dataTable.asLists().size());
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
}

