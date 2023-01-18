package flight.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(name = "firstName")
    private WebElement firstName;
    @FindBy(name = "lastName")
    private WebElement lastName;
    @FindBy(name = "email")
    private WebElement userName;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(name = "confirmPassword")
    private WebElement confirmPass;
    @FindBy(name = "register")
    private WebElement submit;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(300));
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html#");
        wait.until(ExpectedConditions.visibilityOf(firstName));
    }

    public void enterUserDetails(String first, String last) {
        firstName.sendKeys(first);
        lastName.sendKeys(last);
    }
    public void enterUserCredentials(String name, String pass){
        userName.sendKeys(name);
        password.sendKeys(pass);
        confirmPass.sendKeys(pass);
    }
    public void submit(){
        submit.click();
    }
}
