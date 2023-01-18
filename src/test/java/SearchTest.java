import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import search.pages.SearchPage;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void searchTest(String keyword) {
        SearchPage search = new SearchPage(driver);
        search.goTo();
        search.searchFor(keyword);
        search.goToVideos();
        Assert.assertTrue(search.getVideoSize() > 0);
    }

    @AfterTest
    public void quit() {
        driver.quit();
    }
}
