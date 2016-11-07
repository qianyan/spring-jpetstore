package ik.am.jpetstore.app;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber", "rerun:target/rerun.txt"}, features = {"classpath:features"})
public class RunCukesTest {
}
