import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MainPageTest {
    WebDriver driver;

    // TestData testData = new TestData("297777777", 20, "test@mail.ru");

    static Stream<Arguments> placeholderTestData() {
        return Stream.of(
                arguments(0, "connection-phone", "Номер телефона"),
                arguments(0, "connection-sum", "Сумма"),
                arguments(0, "connection-email", "E-mail для отправки чека"),
                arguments(1, "internet-phone", "Номер абонента"),
                arguments(1, "internet-sum", "Сумма"),
                arguments(1, "internet-email", "E-mail для отправки чека"),
                arguments(2, "score-instalment", "Номер счета на 44"),
                arguments(2, "instalment-sum", "Сумма"),
                arguments(2, "instalment-email", "E-mail для отправки чека"),
                arguments(3, "score-arrears", "Номер счета на 2073"),
                arguments(3, "arrears-sum", "Сумма"),
                arguments(3, "arrears-email", "E-mail для отправки чека")
        );
    }


    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAcceptCookieButton();
        mainPage.scrollToPayBlock();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }


    @DisplayName("Проверить текст плейсхолдеров при разных видах услуг ")
    @ParameterizedTest
    @MethodSource("placeholderTestData")
    public void checkPlaceholderText(int index, String text, String expected) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickServiceType(index);
        assertEquals(expected, mainPage.getPlaceholderText(text));
    }

    @DisplayName("Заполнить поля и проверить работу кнопки «Продолжить»")
    @Test
    public void checkContinueButton() {
        MainPage mainPage = new MainPage(driver);
        //mainPage.clickServiceType(0);
        //System.out.println(mainPage.getPlaceholderText("Номер телефона"));
        System.out.println(driver.findElement(By.xpath(".//input[@placeholder = 'Номер телефона']")).getAttribute("placeholder"));

    }

}

