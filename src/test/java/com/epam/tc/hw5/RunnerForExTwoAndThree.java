package com.epam.tc.hw5;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/exTwoAndThree",
        glue = {"com.epam.tc.hw5.steps.ex2and3", "com.epam.tc.hw5.hooks"})
public class RunnerForExTwoAndThree extends AbstractTestNGCucumberTests {
}
