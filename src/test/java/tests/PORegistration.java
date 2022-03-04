package tests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class PORegistration {
    //locators
    SelenideElement NameInput = $("#firstName");
    SelenideElement LastNameInput = $("#lastName");
    SelenideElement EmailInput = $("#userEmail");
    SelenideElement PhoneInput = $("#userNumber");
    SelenideElement AddressInput = $("#currentAddress");

    //actions

    public void setNameInput() {
        NameInput.setValue("Hope");
    }

    public void setLastNameInput() {
        LastNameInput.setValue("Hope");
    }

    public void setEmailInput() {EmailInput.setValue("test@test.test");}

    public void setPhoneInput() {PhoneInput.setValue("89999999999");}

    public void setAddressInput() {AddressInput.setValue("Some_Address");}

    public void setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $("[aria-label$='" + month + " " + day + "th, " + year + "']").click();
    }
}
