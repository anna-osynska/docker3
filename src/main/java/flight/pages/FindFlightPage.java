package flight.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindFlightPage {
    private WebDriverWait wait;
    private WebDriver driver;
    @FindBy(name = "reserveFlights")
    private WebElement submit;
    @FindBy(name = "buyFlights")
    private WebElement buyButton;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goToFindFlightPage() {
        wait.until(ExpectedConditions.visibilityOf(submit));
        submit.click();
    }

    public void goToFlightConfirmationPage() {
        wait.until(ExpectedConditions.visibilityOf(buyButton));
        buyButton.click();
    }
}
