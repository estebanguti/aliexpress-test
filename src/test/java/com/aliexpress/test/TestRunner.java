package com.aliexpress.test;

import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CucumberContextConfiguration
@CucumberOptions(features = "src/test/resources/features",
        plugin = "pretty")
public class TestRunner extends AbstractTestNGCucumberTests {
}

