package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        String firstName = "Tony";
        String lastName = "Soprano";
        String userEmail = "test@test.com";
        String phone = "1234567890";
        String gender = "Male";
        String outputForm = ".table-responsive";

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText(gender)).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").find("option[value='1']").click();
        $(".react-datepicker__year-select").find("option[value='1991']").click();
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("Accounting").pressEnter();
        $(byText("Sports")).click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("samia.jpg");
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $(outputForm).shouldHave(text("Tony Soprano"));
        $(outputForm).shouldHave(text("test@test.com"));
        $(outputForm).shouldHave(text("Male"));
        $(outputForm).shouldHave(text("1234567890"));
        $(outputForm).shouldHave(text("14 February,1991"));
        $(outputForm).shouldHave(text("Accounting"));
        $(outputForm).shouldHave(text("Sports, Reading"));
        $(outputForm).shouldHave(text("samia.jpg"));
        $(outputForm).shouldHave(text("Some street 1"));
        $(outputForm).shouldHave(text("NCR Delhi"));
    }
}
