package cucumberTests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		format = { "pretty", "json:target/cucumber.json", "html:target/site/cucumber-pretty" },
		features = {"features"},
		glue={"stepDefinition"},
		tags={"@Test"}
		)

public class TestRunner {

}