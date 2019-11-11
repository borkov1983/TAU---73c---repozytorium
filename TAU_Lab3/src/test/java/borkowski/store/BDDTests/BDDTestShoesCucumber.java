package borkowski.store.BDDTests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/borkowski/store/", plugin = {"pretty"})
public class BDDTestShoesCucumber {

}
