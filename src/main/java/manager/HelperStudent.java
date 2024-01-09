package manager;

import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public interface HelperStudent extends HelperBase {

    By buttonForms = By.xpath("//div[@class='category-cards']/div[2]");
    //By buttonPracticeForm = By.id("item-0");
    By buttonPracticeForm = By.xpath("//span[text()='Practice Form']");

    By inputFirstName = By.id("firstName");
    By inputLastName = By.id("lastName");
    By inputEmail = By.id("userEmail");

    //===========================================
    By inputPhone = By.id("userNumber");

    //By inputDateOfBirth = By.id("dateOfBirth");
    By inputDateOfBirth = By.id("dateOfBirthInput");

    By inputSubjects = By.id("subjectsInput");

    By checkBoxSports = By.xpath("//label[@for='hobbies-checkbox-1']");
    By checkBoxReading = By.xpath("//label[@for='hobbies-checkbox-2']");
    By checkBoxMusic = By.xpath("//label[@for='hobbies-checkbox-3']");

    By textAreaCurrentAddress = By.id("currentAddress");

    //===============================================
    By inputSelectState = By.id("react-select-3-input");
    By inputSelectCity = By.id("react-select-4-input");

    By buttonSubmit = By.id("submit");

    By textThanksFor = By.id("example-modal-sizes-title-lg");

    default void selectPracticeForm() {
        hideFooter();
        hideDiv();
        clickBase(buttonForms);
        hideFooter();
        clickBase(buttonPracticeForm);
    }

    default void fillStudentForm(StudentDTO student) {
        typeBase(inputFirstName, student.getFirstName());
        typeBase(inputLastName, student.getLastName());
        typeBase(inputEmail, student.getEmail());
        selectGender(student.getGender());
        //===============================================
        typeBase(inputPhone, student.getPhone());
        //typeBase(inputDateOfBirth, student.getDateOfBirth());

        typeBDayByKeys(inputDateOfBirth, student.getDateOfBirth());
        typeSubjects(inputSubjects, student.getSubjects());
        selectHobbies(student.getHobbies());
        typeBase(textAreaCurrentAddress, student.getCurrentAddress());
        //=================================================
        //typeBase(inputSelectState, student.getState());
        typeState(inputSelectState, student.getState());
        typeCity(inputSelectCity, student.getCity());

    }

    default void typeState(By inputSelectState, String state) {
        driver.findElement(inputSelectState).sendKeys(state);
        driver.findElement(inputSelectState).sendKeys(Keys.ENTER);
    }

    default void typeCity(By inputSelectCity, String city) {
        driver.findElement(inputSelectCity).sendKeys(city);
        //driver.findElement(inputSelectState).sendKeys(Keys.ENTER);
    }

    default void selectHobbies(String hobbies) {
        switch (hobbies) {
            case "Sports":
                clickBase(checkBoxSports);
                break;
            case "Reading":
                clickBase(checkBoxReading);
                break;
            case "Music":
                clickBase(checkBoxMusic);
                break;
        }
    }

    default void typeSubjects(By inputSubjects, String subjects) {  //Maths,English
        String[] splitArray = subjects.split(",");
        clickBase(inputSubjects);
        for (String str : splitArray) {
            driver.findElement(inputSubjects).sendKeys(str);
            driver.findElement(inputSubjects).sendKeys(Keys.ENTER);
        }
    }

    default void typeBDayByKeys(By inputDateOfBirth, String dateOfBirth) {
        WebElement element = driver.findElement(inputDateOfBirth);
        element.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println("os system --> " + operationSystem);
        if (operationSystem.startsWith("Win")) {
            element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        } else {
            element.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        }
        element.sendKeys(dateOfBirth);
        element.sendKeys(Keys.ENTER);
    }

    default void selectGender(String gender) {
        if (gender.equals("Male")) {
            clickBase(By.cssSelector("label[for='gender-radio-1']"));
        } else if (gender.equals("Female")) {
            clickBase(By.cssSelector("label[for='gender-radio-2']"));
        } else {
            clickBase(By.cssSelector("label[for='gender-radio-3']"));
        }
    }

    default void clickButtonSubmit() {
        clickBase(buttonSubmit);
    }
    default boolean isElementPresent_textThanksFor(){
        return isElementPresent(buttonSubmit);
    }

}
