package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Test
    public void firstXPath() {
        driver = new ChromeDriver();
        driver.get("https://demoqa.com");

        WebElement elementDiv = driver.findElement(By.xpath("//*[@class='card mt-4 top-card']"));
        System.out.println("tag name --> " + elementDiv.getTagName());

//        WebElement elementSvg = driver.findElement(
//                By.xpath("//*[@class='card mt-4 top-card']" +
//                        "/div/div[@class='avatar mx-auto white']/svg"));
//        System.out.println("fill value --> "+elementSvg.getAttribute("fill"));

        WebElement elementH5 = driver.findElement(
                By.xpath("//*[@class='card mt-4 top-card']/div/div[3]/h5"));
        System.out.println("text h5 --> " + elementH5.getText());

        WebElement elementH5_1 = driver.findElement(
                By.xpath("//div[@class='category-cards']/div[last()]//h5"));
        System.out.println("text h5_1 --> " + elementH5_1.getText());

        WebElement elementH5_CSS = driver.findElement(
                By.cssSelector("div[class='category-cards'] div div div[class='card-body'] h5"));
        System.out.println("h5 CSS --> " + elementH5_CSS.getText());

        WebElement elementH5_child5 = driver.findElement(
                By.cssSelector("div[class='category-cards'] :nth-child(5) div[class='card-body'] h5"));
        System.out.println("h5 child5 --> " + elementH5_child5.getText());

        driver.quit();
    }

    @Test
    public void secondXpath(){
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/checkbox");
        WebElement elementInput = driver.findElement(
                By.xpath("//*[@type='checkbox' and @id='tree-node-desktop']"));
        System.out.println("names element --> "+elementInput.getTagName());



        driver.quit();
    }


}
