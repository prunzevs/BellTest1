package com.google;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.GAfterSearch;
import pages.GBeforeSearch;
import pages.GPF;

import java.util.List;

public class Tests extends BaseTests{


    @Feature("Проверка результатов поиска без паттернов")
    @DisplayName("Проверка результатов поиска напрямую")
    @Test
    public void firstTest(){
        chromeDriver.get("https://www.google.com/");
        WebElement searchField = chromeDriver.findElement(By.xpath("//input[@aria-label='Найти']"));
        WebElement searchButton = chromeDriver.findElement(By.xpath("//input[@aria-label='Поиск в Google']"));

        searchField.click();
        searchField.sendKeys("Гладиолус");
        searchButton.click();

        List<WebElement> resultSearch = chromeDriver.findElements(By.xpath("//*[@class='g']//*[@class='yuRUbf']//cite"));

        Assertions.assertTrue(resultSearch.stream().anyMatch(x->x.getText().contains("https://ru.wikipedia.org")),"Ссылка на вики не найдена");
    }

    @Feature("Проверка результатов поиска используя паттерны")
    @DisplayName("Проверка результатов поиска с помощью PO")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @CsvSource({"Гладиолус, https://ru.wikipedia.org"})
    public void testPO(String keyWords, String link){
        chromeDriver.get("https://www.google.com/");
        GBeforeSearch gBeforeSearch = new GBeforeSearch(chromeDriver);
        gBeforeSearch.find(keyWords);
        GAfterSearch gAfterSearch = new GAfterSearch(chromeDriver);
        Assertions.assertTrue(gAfterSearch.getResults().stream().anyMatch(x->x.getText().contains(link)),"При поиске "+keyWords+"Ссылка на "+link+" не найдена");

    }

    @Feature("Проверка результатов поиска используя паттерны")
    @DisplayName("Проверка результатов поиска с помощью PF")
    @ParameterizedTest(name = "{displayName}: {arguments}")
    @CsvSource({"Гладиолус, https://ru.wikipedia.org"})
    public void testPF(String keyWords, String link){
        chromeDriver.get("https://www.google.com/");
        GPF gpf = PageFactory.initElements(chromeDriver, GPF.class);
        gpf.find("Гладиолус");
        Assertions.assertTrue(gpf.getAllElements().stream().anyMatch(x->x.getText().contains(link)),"При поиске "+keyWords+"Ссылка на "+link+" не найдена");

    }



}
