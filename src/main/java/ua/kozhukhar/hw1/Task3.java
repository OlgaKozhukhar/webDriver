package ua.kozhukhar.hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Task3 {

    @Test
    public void retrieveSearchResultData() {
        String searchValue = "тумба";
        WebDriver webDriver = new ChromeDriver(); // Инициализация WebDriver
        webDriver.get("https://prozorro.gov.ua/en");
        WebElement input = webDriver.findElement(By.xpath("//input[@class='search-text__input']"));
        input.clear();
        input.sendKeys(searchValue);
        input.sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='item-title__title']")));
        List<WebElement> searchResults = webDriver.findElements(By.xpath("//a[@class='item-title__title']"));
        searchResults.get(0).click();
        WebElement nameElement = webDriver.findElement(By.xpath("//div[@class='tender--head--title col-sm-9']"));
        WebElement costElement = webDriver.findElement(By.xpath("//strong[contains(text(),'98 940,00')]/span[@class='small']"));
        WebElement statusElement = webDriver.findElement(By.xpath("//span[@class='marked'][contains(text(),'Завершена')]"));
        WebElement companyElement = webDriver.findElement(By.xpath("//td[@class='col-sm-6' and contains(text(), 'Комунальне некомерційне підприємство Білоцерківської міської ради \"Білоцерківська міська лікарня №2\"')]"));
        String name = nameElement.getText();
        String cost = costElement.getText(); // Исправление для получения текста стоимости
        String status = statusElement.getText(); // Исправление для получения текста статуса
        String company = companyElement.getText(); // Исправление для получения текста компании
        System.out.println("Название: " + name);
        System.out.println("Стоимость: " + cost);
        System.out.println("Статус: " + status);
        System.out.println("Компания: " + company);
        webDriver.quit(); // Закрытие сессии WebDriver
    }
}