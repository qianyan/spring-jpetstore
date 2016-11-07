package ik.am.jpetstore.app;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

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
//        driver = new RemoteWebDriver(new URL("http://192.168.99.100:4444"), DesiredCapabilities.firefox());
        getDriver().get("http://127.0.0.1:8080/spring-jpetstore");
//        getDriver().get("http://192.168.99.100:84");
    }

    @Before("@dev")
    public void beforeRunOnDEV() {
        getDriver().get("http://192.168.99.100:84/spring-jpetstore");
    }

    @Before("@sit")
    public void beforeRunOnSIT() {
        getDriver().get("http://192.168.99.100:81/spring-jpetstore");
    }

    @Before("@uat")
    public void beforeRunOnUAT() {
        getDriver().get("http://192.168.99.100:82/spring-jpetstore");
    }

    @After("@web")
    public void afterScenario() {
        getDriver().quit();
    }
}
