package tests;

import manager.HelperStudent;
import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class StudentFormTest extends TestBase implements HelperStudent {

    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void goToPracticeForm(){
        //hideBanner();
        //hideFooter();
        selectPracticeForm();
    }

    @Test
    public void studentFormPositiveTest(){
        //System.out.println("start");
        StudentDTO student = new StudentDTO("Frodo", "Baggins", "frodobaggins@mail.com",
                "F++++", "1234567890", "02 Jan 2000", "Maths,English",
                "Sports", "Street 2 house 1", "NCR", "Delhi");
        fillStudentForm(student);
        clickButtonSubmit();
        //=======================================
        WebElement elementEmail = driver.findElement(By.xpath("//tbody/tr[2]/td[2]"));
        WebElement elementPhone = driver.findElement(By.xpath("//tbody/tr[4]/td[2]"));
        System.out.println(elementEmail.getText());
        System.out.println(elementPhone.getText());

        //Assert.assertEquals(elementEmail.getText(), "frodobaggins@mail.com");
        softAssert.assertEquals(elementEmail.getText(), "frodobaggins@mail.com");
        System.out.println("assert 1");

        //Assert.assertEquals(elementPhone.getText(), "1234567890!");
        softAssert.assertEquals(elementPhone.getText(), "1234567890");
        System.out.println("assert 2");

        //Assert.assertTrue(isElementPresent_textThanksFor());
        softAssert.assertAll();
    }
}
