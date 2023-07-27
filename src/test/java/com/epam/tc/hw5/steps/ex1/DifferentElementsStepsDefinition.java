package com.epam.tc.hw5.steps.ex1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw5.common.DifferentElementsLog;
import com.epam.tc.hw5.common.DifferentElementsMainContent;
import com.epam.tc.hw5.common.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DifferentElementsStepsDefinition {
    WebDriver driver;

    @Before
    public void webDriverSetUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");

        driver = new ChromeDriver(options);
    }


    @Given("I open home page")
    public void openHomePage() {
        HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
    }

    @Given("The homepage title is correct")
    public void checkTitle() {
        HomePage homePage = new HomePage(driver);
        assertThat(homePage.checkTitle()).isEqualTo("Home Page");
    }

    @When("I perform login")
    public void performLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.performLogin("Roman", "Jdi1234");
    }

    @When("The logged username is correct")
    public void assertUsername() {
        HomePage homePage = new HomePage(driver);
        assertThat(homePage.assertUsername()).isEqualTo("ROMAN IOVLEV");
    }

    @When("I open different elements page")
    public void openDifferentElements() {
        HomePage homePage = new HomePage(driver);
        homePage.openDifferentElements();
    }

    @When("I select checkboxes Water and Wind")
    public void selectWaterAndWind() {
        DifferentElementsMainContent differentElementsMainContent = new DifferentElementsMainContent(driver);
        differentElementsMainContent.selectWater()
                .selectWind();
    }

    @When("I select radio button Selen")
    public void selectRadioSelen() {
        DifferentElementsMainContent differentElementsMainContent = new DifferentElementsMainContent(driver);
        differentElementsMainContent.selectRadioSelen();
    }

    @When("I select Yellow color from dropdown")
    public void selectDropdownYellow() {
        DifferentElementsMainContent differentElementsMainContent = new DifferentElementsMainContent(driver);
        differentElementsMainContent.selectDropdown()
                .selectYellow();
    }

    @Then("The log rows for Water and Wind are displayed and its value corresponds to the checkbox status")
    public void logRowForCheckbox() {
        DifferentElementsLog differentElementsLog = new DifferentElementsLog(driver);
        assertThat(differentElementsLog.isLogRowForWaterDisplayed())
                .as("Log row for Water checkbox is displayed").isTrue();
        assertThat(differentElementsLog.isLogRowForWindDisplayed())
                .as("Log row for Wind checkbox is displayed").isTrue();
    }

    @Then("The log row for Selen is displayed and its value corresponds to the radio status")
    public void logRowRadio() {
        DifferentElementsLog differentElementsLog = new DifferentElementsLog(driver);
        assertThat(differentElementsLog.isLogRowRadioDisplayed())
                .as("Log row for radio button Selen is displayed").isTrue();
    }

    @Then("The log row for Yellow color from dropdown is displayed  and its value corresponds to the dropdown status")
    public void logDropdown() {
        DifferentElementsLog differentElementsLog = new DifferentElementsLog(driver);
        assertThat(differentElementsLog.isLogDropdownDisplayed())
                .as("Log row for yellow color is displayed").isTrue();
    }

    @After
    public void closing() {
        driver.quit();
    }

}
