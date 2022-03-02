package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstJUnitTest {

    @BeforeEach
    void openBrowser() {
        open("https://demoqa.com/automation-practice-form");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test
    void simpleTest() {
        sleep(2000);
        $("#firstName").setValue("Hope");
        $("#lastName").setValue("Hope");
        $("#userEmail").setValue("test@test.test");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("89999999999");
        $("#dateOfBirthInput").click();
        $x(("//select[@class=\"react-datepicker__month-select\"]")).selectOptionContainingText("April");
        $x(("//select[@class=\"react-datepicker__year-select\"]")).selectOptionContainingText("1997");
        $x(("//div[@class=\"react-datepicker__day react-datepicker__day--030\"]")).click();
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/blog-toughness.jpg");
        $("#currentAddress").setValue("Some_address");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldBe(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Hope Hope"), text("test@test.test"));

    }
}
