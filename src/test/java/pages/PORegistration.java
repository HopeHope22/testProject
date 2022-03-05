package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PORegistration {

    CalendarComponent calendarComponent = new CalendarComponent();

    //locators
    public static SelenideElement nameInput = $("#firstName");
    public static SelenideElement lastNameInput = $("#lastName");
    public static SelenideElement emailInput = $("#userEmail");
    public static SelenideElement phoneInput = $("#userNumber");
    public static SelenideElement addressInput = $("#currentAddress");
    public static SelenideElement dataPicker = $("#dateOfBirthInput");
    public static SelenideElement blockStateCity = $("#stateCity-wrapper");
    public static SelenideElement stateSelect = $("#state");
    public static SelenideElement citySelect = $("#city");
    public static SelenideElement buttonSubmit = $("#submit");
    public static SelenideElement femaleGender = $("#genterWrapper").$(byText("Female"));
    public static SelenideElement subjectsInput = $("#subjectsInput");
    public static SelenideElement checkboxHobbyMusic = $("#hobbiesWrapper").$(byText("Music"));
    public static SelenideElement addFileButton = $("#uploadPicture");
    public static SelenideElement userCardTitle = $("#example-modal-sizes-title-lg");
    public static SelenideElement userCard = $(".table-responsive");

    // const
    public static String name = "Hope";
    public static String lastName = "Hope";
    public static String email = "test@test.test";
    public static String phone = "89999999999";
    public static String address = "Some_Address";
    public static String pathToImage = "img/blog-toughness.jpg";

    //actions

    public PORegistration setInput(SelenideElement element, String value){
        element.should(visible).setValue(value);
        return this;
    }

    public PORegistration clickButton(SelenideElement element){
        element.should(visible).click();
        return this;
    }

    public PORegistration setSubject(String subject){
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public PORegistration addFile(String path){
        addFileButton.uploadFromClasspath(path);
        return this;
    }


    public PORegistration setBirthDate(String day, String month, String year) {
        dataPicker.click();
        calendarComponent.setDatePicker(day, month, year);
        return this;
    }

    public PORegistration setLocation(String stateValue, String cityValue) {
        stateSelect.click();
        blockStateCity.$(byText(stateValue)).click();
        citySelect.click();
        blockStateCity .$(byText(cityValue)).click();
        return this;
    }


}
