package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/",//referencia donde se alojan los features
        glue = {"SeleniumCode"},//donde se ingresa el codigo de feature
        plugin ={"json:target/cucumber-report/cucumber.json"}
        //plugin = {"json:target/Destination/cucumber.json"}
)
public class Test_Runner {
}
