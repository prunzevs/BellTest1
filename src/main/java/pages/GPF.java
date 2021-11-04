package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class GPF {

    private WebDriver chromeDriver;

    @FindBy(how= How.XPATH,using="//input[@aria-label='Найти']")
    WebElement searchField;

    @FindBy(how= How.XPATH, using="//input[@aria-label='Поиск в Google']")
    WebElement searchButton;

    @FindBy(how= How.XPATH, using = "//*[@class='g']//*[@class='yuRUbf']//cite")
    List<WebElement> allElements;

    //FindAny
    //FindAll

    public GPF(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
    }

    public  void find(String keysFind){
        searchField.click();
        searchField.sendKeys(keysFind);
        searchButton.click();
    }

    public List<WebElement> getAllElements() {
        return allElements;
    }
}

