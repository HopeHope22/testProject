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
        new PORegistration().setNameInput();
        new PORegistration().setLastNameInput();
        new PORegistration().setEmailInput();
        $("#genterWrapper").$(byText("Female")).click();
        new PORegistration().setPhoneInput();
        new PORegistration().setBirthDate("30", "April", "1997");
        $("#subjectsInput").setValue("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/blog-toughness.jpg");
        new PORegistration().setAddressInput();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Agra")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldBe(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Hope Hope"),
                text("test@test.test"),
                text("Female"),
                text("Mobile 8999999999"),
                text("30 April,1997"),
                text("History"),
                text("Music"),
                text("blog-toughness.jpg"),
                text("Some_address"),
                text("Uttar Pradesh"),
                text("Agra"));
    }
}
