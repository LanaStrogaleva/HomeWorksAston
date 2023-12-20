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

public class FramePageTest {
    WebDriver driver;
    TestData testData = new TestData("297777777", 20, "test@mail.ru");
    private final String EXPECTED_PAYMENT_SUM = testData.sum + ".00 BYN";
    private final String EXPECTED_PHONE_NUMBER = testData.phone;
    private final String EXPECTED_CARD_NUMBER_PLACEHOLDER = "Номер карты";
    private final String EXPECTED_EXPIRATION_DATE_PLACEHOLDER = "Срок действия";
    private final String EXPECTED_CVC_PLACEHOLDER = "CVC";
    private final String EXPECTED_NAME_PLACEHOLDER = "Имя держателя (как на карте)";


    static Stream<Arguments> logoTestData() {
        return Stream.of(
                arguments(0, "mastercard"),
                arguments(1, "visa"),
                arguments(2, "belkart"),
                arguments(3, "mir"),
                arguments(4, "maestro")
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
        mainPage.fillPayBlockForm(testData);
        mainPage.clickContinueButton();
        mainPage.checkoutPaymentFramePage();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @DisplayName("Проверить сумму оплаты в заголовке")
    @Test
    public void checkHeaderSum() {
        FramePage framePage = new FramePage(driver);
        assertTrue(framePage.getPaymentSumHeaderText().contains(EXPECTED_PAYMENT_SUM));
    }

    @DisplayName("Проверить сумму оплаты на кнопке")
    @Test
    public void checkButtonSum() {
        FramePage framePage = new FramePage(driver);
        assertTrue(framePage.getPaymentButtonText().contains(EXPECTED_PAYMENT_SUM));
    }

    @DisplayName("Проверить номер телефона в заголовке")
    @Test
    public void checkHeaderPhoneNumber() {
        FramePage framePage = new FramePage(driver);
        assertTrue(framePage.getPhoneNumberHeaderText().contains(EXPECTED_PHONE_NUMBER));
    }

    @DisplayName("Проверить плейсхолдер 'Номер карты'")
    @Test
    public void checkCardNumberPlaceholder() {
        FramePage framePage = new FramePage(driver);
        assertEquals(EXPECTED_CARD_NUMBER_PLACEHOLDER, framePage.getCardNumberPlaceholderText());
    }

    @DisplayName("Проверить плейсхолдер 'Срок действия'")
    @Test
    public void checkExpirationDatePlaceholder() {
        FramePage framePage = new FramePage(driver);
        assertEquals(EXPECTED_EXPIRATION_DATE_PLACEHOLDER, framePage.getExpirationDatePlaceholderText());
    }

    @DisplayName("Проверить плейсхолдер 'CVC'")
    @Test
    public void checkCvcPlaceholder() {
        FramePage framePage = new FramePage(driver);
        assertEquals(EXPECTED_CVC_PLACEHOLDER, framePage.getCvcPlaceholderText());
    }

    @DisplayName("Проверить плейсхолдер 'Имя держателя (как на карте)'")
    @Test
    public void checkNamePlaceholder() {
        FramePage framePage = new FramePage(driver);
        assertEquals(EXPECTED_NAME_PLACEHOLDER, framePage.getNamePlaceholderText());
    }

    @DisplayName("Проверить наличие логотипов платёжных систем")
    @ParameterizedTest
    @MethodSource("logoTestData")
    public void checkPaySystemLogotypes(int index, String expected) {
        FramePage framePage = new FramePage(driver);
        assertTrue(framePage.getPaymentSystemsLogos(index).contains(expected));
    }


}
