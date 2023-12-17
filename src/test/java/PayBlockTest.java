import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PayBlockTest {
    WebDriver driver;
    TestData testData = new TestData("297777777", 20, "test@mail.ru");
    private final String EXPECTED_BLOCK_NAME = "Онлайн пополнение\nбез комиссии";
    private final String EXPECTED_PAY_FORM_HEADER = "Оплата: Услуги связи";

    private static final String URL_ABOUT_SERVICE = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

    static Stream<Arguments> logoTestData() {
        return Stream.of(
                arguments(0, "Visa"),
                arguments(1, "Verified By Visa"),
                arguments(2, "MasterCard"),
                arguments(3, "MasterCard Secure Code"),
                arguments(4, "Белкарт"),
                arguments(5, "МИР")
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

    @DisplayName("Проверить название блока оплаты")
    @Test
    public void checkBlockName() {
        MainPage mainPage = new MainPage(driver);
        assertEquals(EXPECTED_BLOCK_NAME, mainPage.getBlockName());
    }

    @DisplayName("Проверить наличие логотипов платёжных систем")
    @ParameterizedTest
    @MethodSource("logoTestData")
    public void checkPaySystemLogotypes(int index, String expected) {
        MainPage mainPage = new MainPage(driver);
        assertEquals(expected, mainPage.getPayPartnersLogos(index));
    }

    @DisplayName("Проверить работу ссылки «Подробнее о сервисе»")
    @Test
    public void checkAboutServiceLink() {

        MainPage mainPage = new MainPage(driver);
        AboutServiceInfoPage aboutServiceInfoPage = new AboutServiceInfoPage(driver);
        mainPage.clickAboutServiceLink();
        assertEquals(URL_ABOUT_SERVICE, aboutServiceInfoPage.getAboutServiceInfoPage());

    }

    @DisplayName("Заполнить поля и проверить работу кнопки «Продолжить»")
    @Test
    public void checkContinueButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.fillPayBlockForm(testData);
        mainPage.clickContinueButton();
        assertTrue(mainPage.getPayFormHeader().contains(EXPECTED_PAY_FORM_HEADER));

    }

}

