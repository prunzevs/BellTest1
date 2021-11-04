package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GBeforeSearch {

    protected WebDriver chromeDriver;
    protected WebElement searchField;
    protected WebElement searchButton;

    public GBeforeSearch() {
    }

    public GBeforeSearch(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        searchField = chromeDriver.findElement(By.xpath("//input[@aria-label='Найти']"));
        searchButton = chromeDriver.findElement(By.xpath("//input[@aria-label='Поиск в Google']"));
    }
    public void find(String keysFind){
        searchField.click();
        searchField.sendKeys(keysFind);
        searchButton.click();
    }
}
