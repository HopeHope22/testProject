package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FirstJUnitTest {

    @BeforeEach
    void openBrowser() {
        open("https://demoqa.com/automation-practice-form");
    }

    @AfterEach
    void closeBrowser() {
        Selenide.closeWebDriver();}

    @Test
    void simpleTest() {
        sleep(4000);
        $("#firstName").setValue("Hope");
        $("#lastName").setValue("Hope");
        $("#userEmail").setValue("test@test.test");
        sleep(2000);
        $("#genterWrapper").$(new ByText("Female")).click();
        $("#userNumber").scrollTo().setValue("89999999999");
        $("#dateOfBirthInput").click();
        sleep(2000);
        $(new By.ByXPath("//select[@class=\"react-datepicker__month-select\"]")).selectOptionContainingText("April");
        $(new By.ByXPath("//select[@class=\"react-datepicker__year-select\"]")).selectOptionContainingText("1997");
        $(new By.ByXPath("//div[@class=\"react-datepicker__day react-datepicker__day--030\"]")).click();
        sleep(5000);
        $("#subjectsInput").setValue("History").pressEnter();
        sleep(1500);
        $("#hobbiesWrapper").$(new ByText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/blog-toughness.jpg");
        $("#currentAddress").setValue("Some_address");
        $("#state").click();
        $("#stateCity-wrapper").$(new ByText("Uttar Pradesh")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(new ByText("Merrut")).click();
        $("#submit").click();
        sleep(5000);

        $("#example-modal-sizes-title-lg").shouldBe(text("Thanks for submitting the form"));
    }
}
