package ik.am.jpetstore.app.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import ik.am.jpetstore.app.Hook;
import ik.am.jpetstore.app.page.HomePage;

public class HomepageStep {
    @Given("^I open homepage$")
    public void iOpenHomepage() throws Throwable {
        // The home page is opened by default.
    }

    @Then("^I should see pet store home page$")
    public void iShouldSeePetStoreHomePage() throws Throwable {
        new HomePage().checkOpened(Hook.getDriver());

    }

}
