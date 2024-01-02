package tests;

import manager.HelperStudent;
import models.StudentDTO;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StudentFormTest extends TestBase implements HelperStudent {

    @BeforeClass
    public void goToPracticeForm(){
        hideBanner();
        //hideFooter();
        selectPracticeForm();
    }

    @Test
    public void studentFormPositiveTest(){
        //System.out.println("start");
        StudentDTO student = new StudentDTO("Frodo", "Baggins", "frodobaggins@mail.com",
                "Female", "1234567890", "02 Jan 2000", "Maths,English",
                "Sports,Music", "Street 2 house 1", "NCR", "Delhi");
        fillStudentForm(student);
    }
}
