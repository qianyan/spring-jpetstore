package ik.am.jpetstore.app.page;

import org.openqa.selenium.WebDriver;

/**
 * Created by azhu on 11/8/16.
 */
public class HomePage {
    public void checkOpened(WebDriver driver) {
        driver.getTitle().equals("JPetStore Demo");
    }
}
