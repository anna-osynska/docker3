package search.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(name = "q")
    private WebElement input;
    @FindBy(id = "search_button_homepage")
    private WebElement search;
    @FindBy(xpath = "//a[@data-zci-link='videos']")
    private WebElement videosLink;
    @FindBy(className = "tile--vid")
    private WebElement video;
    @FindBy(className = "tile--vid")
    private List<WebElement> videos;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(300));
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://duckduckgo.com/");
    }

    public void searchFor(String text) {
        wait.until(ExpectedConditions.visibilityOf(input));
        input.sendKeys(text);
        search.click();
    }

    public void goToVideos() {
        wait.until(ExpectedConditions.visibilityOf(videosLink));
        videosLink.click();
    }

    public Integer getVideoSize() {
        wait.until(ExpectedConditions.visibilityOf(video));
        return videos.size();
    }

}
