package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public interface AppManager {
    WebDriver driver = new ChromeDriver();

    //void first();
    default void init(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://demoqa.com");
    }

    default void stop(){
        driver.quit();
    }

}
