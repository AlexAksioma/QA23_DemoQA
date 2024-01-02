package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public interface HelperBase extends AppManager{

    //document.querySelector('#adplus-anchor').style.display='none'    hide banner
    default void clickBase(By locator){
        driver.findElement(locator).click();
    }

    default void typeBase(By locator, String text){
        WebElement element = driver.findElement(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    default void hideBanner(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#adplus-anchor').style.display='none'");
    }

    default void hideFooter(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}
