package flight.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightConfirmationPage {
    private WebDriverWait wait;
    private WebDriver driver;
    @FindBy(xpath = "//td[text()='Tax']/following-sibling::td/font[contains(text(), 'USD')]")
    private WebElement tax;
    @FindBy(xpath = "//td[text()='Total Price']/following-sibling::td/font[contains(text(), 'USD')]")
    private WebElement totalPrice;
    @FindBy(id = "sign-on")
    private WebElement signOff;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }
    public String  getTax(){
        wait.until(ExpectedConditions.visibilityOf(tax));
        return tax.getText();
    }
    public String getTotalPrice(){
        return totalPrice.getText();
    }
    public void signOff(){
        signOff.click();
    }
}
