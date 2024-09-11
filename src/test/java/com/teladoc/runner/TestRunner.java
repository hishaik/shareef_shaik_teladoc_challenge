package com.teladoc.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.teladoc.steps"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
