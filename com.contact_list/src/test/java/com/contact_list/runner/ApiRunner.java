package com.contact_list.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/features/api"},
        glue = {"com.contact_list.api.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber", "html:target/cucumber-reports.html", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","rerun:target/failedrerun.txt"},
        tags = "not @Skip and not @ignore and not @DEV-WIP"
)
public class ApiRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}