package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormTests {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
        // Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        String firstName = "Tony";
        String lastName = "Soprano";
        String userEmail = "test@test.com";
        String phone = "1234567890";
        String gender = "Male";

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(phone);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").find("option[value='1']").click();
        $(".react-datepicker__year-select").find("option[value='1991']").click();
        $(".react-datepicker__day--014").click();
        $("#subjectsInput").setValue("Accounting").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("samia.jpg");
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Tony Soprano"));
        $(".table-responsive").shouldHave(text("test@test.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("14 February,1991"));
        $(".table-responsive").shouldHave(text("Accounting"));
        $(".table-responsive").shouldHave(text("Sports, Reading"));
        $(".table-responsive").shouldHave(text("samia.jpg"));
        $(".table-responsive").shouldHave(text("Some street 1"));
        $(".table-responsive").shouldHave(text("NCR Delhi"));
    }
}
