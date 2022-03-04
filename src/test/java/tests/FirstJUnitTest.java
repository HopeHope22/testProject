package tests;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static tests.PORegistration.*;

public class FirstJUnitTest {

    PORegistration poRegistration;

    @BeforeEach
    void openBrowser() {
        open("https://demoqa.com/automation-practice-form");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Test
    void simpleTest() {
        poRegistration = new PORegistration();
        poRegistration.setInput(nameInput, name)
                .setInput(lastNameInput, lastName)
                .setInput(emailInput, email)
                .setInput(phoneInput, phone)
                .setInput(addressInput, address)
                .clickButton(femaleGender)
                .setBirthDate("30", "April", "1997")
                .setSubject("History")
                .clickButton(checkboxHobbyMusic)
                .addFile(pathToImage)
                .setLocation("Uttar Pradesh", "Agra")
                .clickButton(buttonSubmit);
        userCardTitle.shouldBe(text("Thanks for submitting the form"));
        userCard.shouldHave(
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