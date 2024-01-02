package manager;

import models.StudentDTO;
import org.openqa.selenium.By;

public interface HelperStudent extends HelperBase{

    By buttonForms = By.xpath("//div[@class='category-cards']/div[2]");
    //By buttonPracticeForm = By.id("item-0");
    By buttonPracticeForm = By.xpath("//span[text()='Practice Form']");

    By inputFirstName = By.id("firstName");
    By inputLastName = By.id("lastName");
    By inputEmail = By.id("userEmail");

    default void selectPracticeForm(){
        clickBase(buttonForms);
        hideFooter();
        clickBase(buttonPracticeForm);
    }

    default void fillStudentForm(StudentDTO student){
        typeBase(inputFirstName, student.getFirstName());
        typeBase(inputLastName, student.getLastName());
        typeBase(inputEmail, student.getEmail());
        selectGender(student.getGender());
    }

    default void selectGender(String gender){
        if(gender.equals("Male")){
            clickBase(By.cssSelector("label[for='gender-radio-1']"));
        } else if (gender.equals("Female")) {
            clickBase(By.cssSelector("label[for='gender-radio-2']"));
        }else {
            clickBase(By.cssSelector("label[for='gender-radio-3']"));
        }
    }

}
