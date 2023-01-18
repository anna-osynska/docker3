package flight.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightDetailsPage {
    private WebDriverWait wait;
    private WebDriver driver;
    @FindBy(name = "passCount")
    private WebElement numOfPassengers;
    @FindBy(id = "findFlights")
    private WebElement coninue;

    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void selectPassengers(String number) {
        wait.until(ExpectedConditions.visibilityOf(numOfPassengers));
        Select dropdown = new Select(numOfPassengers);
        dropdown.selectByVisibleText(number);
    }
    public void goToFindFlightPage(){
        coninue.click();
    }
}
