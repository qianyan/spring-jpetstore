package ik.am.jpetstore.app;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by azhu on 11/7/16.
 */
public class Hook {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before("@web")
    public void beforeScenario() throws Exception {
        driver = new FirefoxDriver();
        getDriver().get("http://127.0.0.1:8080/spring-jpetstore");
//        getDriver().get("http://192.168.99.100:84");
    }

    @After("@web")
    public void afterScenario() {
        getDriver().quit();
    }
}
