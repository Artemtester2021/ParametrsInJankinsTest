package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class PracticFormTest extends TestBase {

    @Test
    @Tag("demoqa")
    void fillFormTest() {
        step("Открытие формы", () -> {
            open("/automation-practice-form");

            executeJavaScript("$('footer').remove();");
            executeJavaScript("$('#fixedban').remove();");
        });
        step("Заполнение формы", () ->{
            $("#firstName").setValue("Nikolai");
            $("#lastName").setValue("Inov");
            $("#userEmail").setValue("test@test.ru");
            $("#genterWrapper").$(byText("Male")).click();
            $("#userNumber").setValue("7776665544");
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").selectOption("May");
            $(".react-datepicker__year-select").selectOption("2005");
            $$("div.react-datepicker__day").findBy(text("3")).click();
            $("#subjectsInput").setValue("Maths").pressEnter();
            $("#hobbiesWrapper").$(byText("Music")).click();
            $("#uploadPicture").uploadFromClasspath("img.png");
            $("#currentAddress").setValue("Some address");
            $("#state").scrollTo().click();
            $("#react-select-3-input").setValue("NCR").pressEnter();
            $("#city").scrollTo().click();
            $("#react-select-4-input").setValue("Delhi").pressEnter();
            $("#submit").scrollTo().click();

        });
        step("Проверка данных", () -> {
            $(".table-responsive").shouldBe(visible);
            $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Nikolai Inov"));
            $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("test@test.ru"));
            $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
            $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("7776665544"));
            $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("03 May,2005"));
            $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Maths"));
            $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Music"));
            $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("img.png"));
            $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Some address"));
            $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Delhi"));
        });
    }
}
