import flight.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BookFlightTest extends BaseTest {
    private String numPassengers;
    private String expectedPrice;


    @BeforeTest
    @Parameters({"numPassengers", "expectedPrice"})
    public void setParam(String numPassengers, String expectedPrice) {
        this.numPassengers = numPassengers;
        this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPageTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserDetails("user", "pass");
        registrationPage.enterUserCredentials("user", "pass");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationTest() {
        RegistrationConfirmationPage registrationConfirmation = new RegistrationConfirmationPage(driver);
        registrationConfirmation.goToFlightPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationTest")
    public void flightDetailsTest() {
        FlightDetailsPage flightDetails = new FlightDetailsPage(driver);
        flightDetails.selectPassengers("2");
        flightDetails.goToFindFlightPage();
    }

    @Test(dependsOnMethods = "flightDetailsTest")
    public void findFlightTest() {
        FindFlightPage findFlight = new FindFlightPage(driver);
        findFlight.goToFindFlightPage();
        findFlight.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightTest")
    public void flightConfirmationPage() {
        FlightConfirmationPage flightConfirmation = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmation.getTotalPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
        flightConfirmation.signOff();
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
