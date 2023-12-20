package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class Locators {
    WebDriver driver;

    @Test
    public void first() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        WebElement elementHeader = driver.findElement(By.cssSelector("header"));
        System.out.println("tag name --> " + elementHeader.getTagName());

        WebElement elementDiv = driver.findElement(By.cssSelector("div[id='app']"));
        System.out.println("attribute id --> " + elementDiv.getAttribute("id"));

        List<WebElement> listDiv = driver.findElements(By.cssSelector("div[class='card mt-4 top-card']"));
        System.out.println("size listDiv --> " + listDiv.size());

        driver.quit();
    }

    @Test
    public void second() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement elementInputFullName = driver.findElement(By.cssSelector("*[id='userName']"));
        System.out.println("value placeholder --> " + elementInputFullName.getAttribute("placeholder"));

        WebElement elementTextArea = driver.findElement(By.cssSelector("textarea[id='permanentAddress']"));
        System.out.println("attribute class --> " + elementTextArea.getAttribute("class"));

        driver.quit();
    }
}
