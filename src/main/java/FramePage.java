import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage {
    private final WebDriver webDriver;

    public FramePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //Заголовок с суммой платежа
    private By paymentSumHeader = By.xpath(".//p[@class = 'header__payment-amount']");

    // Кнопка "Оплатить"
    private By paymentButton = By.xpath(".//button[contains(text(), 'Оплатить')]");

    // Заголовок с номером телефона
    private By phoneNumberHeader = By.xpath(".//p[@class = 'header__payment-info']");

    // Плейсхолдер "Номер карты"
    private By cardNumberPlaceholder = By.xpath(".//label[text() = 'Номер карты']");

    // Лого платежных систем
    private By paymentSystemsLogos = By.xpath(".//img[contains(@class, 'ng-tns-c53-0')]");

    // Плейсхолдер "Срок действия"
    private By expirationDatePlaceholder = By.xpath(".//label[text() = 'Срок действия']");

    // Плейсхолдер "CVC"
    private By cvcPlaceholder = By.xpath(".//label[text() = 'CVC']");

    // Плейсхолдер "Имя держателя (как на карте)"
    private By namePlaceholder = By.xpath(".//label[text() = 'Имя держателя (как на карте)']");


    //Получить текст заголовка с суммой платежа
    public String getPaymentSumHeaderText() {
        return webDriver.findElement(paymentSumHeader).getAttribute("textContent");
    }

    //Получить текст кнопки "Оплатить"
    public String getPaymentButtonText() {
        return webDriver.findElement(paymentButton).getAttribute("textContent");
    }

    //Получить текст заголовка с номером телефона
    public String getPhoneNumberHeaderText() {
        return webDriver.findElement(phoneNumberHeader).getAttribute("textContent");
    }

    //Получить текст плейсхолдера "Номер карты"
    public String getCardNumberPlaceholderText() {
        return webDriver.findElement(cardNumberPlaceholder).getAttribute("textContent");
    }

    //Получить текст плейсхолдера "Срок действия"
    public String getExpirationDatePlaceholderText() {
        return webDriver.findElement(expirationDatePlaceholder).getAttribute("textContent");
    }

    //Получить текст плейсхолдера "CVC"
    public String getCvcPlaceholderText() {
        return webDriver.findElement(cvcPlaceholder).getAttribute("textContent");
    }

    //Получить текст плейсхолдера "Имя держателя (как на карте)"
    public String getNamePlaceholderText() {
        return webDriver.findElement(namePlaceholder).getAttribute("textContent");
    }

    //Получить название платежной системы по индексу
    public String getPaymentSystemsLogos(int index) {
        return webDriver.findElements(paymentSystemsLogos).get(index).getAttribute("src");
    }

}
