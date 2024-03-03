package ua.kozhukhar.hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Task1 {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriver webDriver = new ChromeDriver();

        webDriver.get("https://vodokanal.kharkov.ua/");

        WebElement image = webDriver.findElement(By.xpath("//img[@alt='КП «Харківводоканал»']"));

        Assert.assertTrue(image.isDisplayed(), "КП «Харківводоканал» page is not opened successfully");


    }
}



