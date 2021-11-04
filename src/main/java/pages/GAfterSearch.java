package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GAfterSearch extends GBeforeSearch{

    private List<WebElement> results;
   // WebDriverWait wait = new WebDriverWait(chromeDriver, 120);


    public GAfterSearch(WebDriver chromeDriver) {
        super.chromeDriver = chromeDriver;
    }


    public List<WebElement> getResults() {
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='g']//*[@class='yuRUbf']")));
        results=chromeDriver.findElements(By.xpath("//*[@class='g']//*[@class='yuRUbf']"));
        return results;
    }
}
