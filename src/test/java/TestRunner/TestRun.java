package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature" , 
glue={"StepsDefinition"},
monochrome=true , 
dryRun=false,
plugin= {"pretty" , "html:target/HtmlReport" }
)
public class TestRun {

}
