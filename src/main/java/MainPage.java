import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private static final String URL = "https://www.mts.by/";

    private final WebDriver webDriver;

    public MainPage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    private By acceptCookieButton = By.xpath(".//button[text() = 'Принять']");

    // Блок оплаты
    private By payBlock = By.xpath((".//div[@class = 'pay__wrapper']"));

    // Кнопка выбора списка услуг
    private By serviceTypeButton = By.xpath(".//button[@class = 'select__header']");

    // список видов услуг
    private By serviceTypesList = By.xpath(".//ul[@class = 'select__list']/li");


    // Плейсхолдер "Номер телефона"
    private By phonePlaceholder = By.xpath(".//input[@placeholder = 'Номер телефона']");

    // Плейсхолдер "Сумма"
    private By sumPlaceholder = By.xpath(".//form[@class = 'pay-form opened']//input[@placeholder = 'Сумма']");

    // Плейсхолдер "E-mail для отправки чека"
    private By emailPlaceholder = By.xpath(".//form[@class = 'pay-form opened']//input[@placeholder = 'E-mail для отправки чека']");

    // Кнопка "Продолжить"
    private By continueButton = By.xpath(".//form[@class = 'pay-form opened']//button[text() = 'Продолжить']");

    // Фрейм
    private By paymentFrame = By.className("bepaid-iframe");

    // Заголовок формы оплаты
    private By payFormHeader = By.xpath(".//div[@class= 'header__payment']/p[2]");

    // Открыть главную страницу
    public void open() {
        webDriver.get(URL);
    }

    // Нажать на кнопку "Принять" в окне "Обработка файлов cookie"
    public void clickAcceptCookieButton() {
        webDriver.findElement(acceptCookieButton).click();
    }

    // Проскроллить до блока "Онлайн пополнение без комиссии"
    public void scrollToPayBlock() {
        WebElement element = webDriver.findElement(payBlock);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Выбрать  вид усуги по индексу
    public void clickServiceType(int index) {
        webDriver.findElement(serviceTypeButton).click();
        webDriver.findElements(serviceTypesList).get(index).click();
    }

    //Получить текст плейсхолдера по id"
    public String getPlaceholderText(String id) {
        return webDriver.findElement(By.id(id)).getAttribute("placeholder");
    }


    // Заполнить поле "Номер телефона"
    public void inputPhoneField(String phone) {
        webDriver.findElement(phonePlaceholder).sendKeys(phone);
    }

    // Заполнить поле "Сумма
    public void inputSumField(int sum) {
        webDriver.findElement(sumPlaceholder).sendKeys(String.valueOf(sum));
    }

    // Заполнить поле "E-mail для отправки чека"
    public void inputEmailField(String email) {
        webDriver.findElement(emailPlaceholder).sendKeys(email);
    }

    // Заполнить форму блока "Онлайн пополнение без комиссии"
    public void fillPayBlockForm(TestData testData) {
        inputPhoneField(testData.phone);
        inputSumField(testData.sum);
        inputEmailField(testData.email);
    }

    // Кликнуть на  кнопку "Продолжить"
    public void clickContinueButton() {

        webDriver.findElement(continueButton).click();
    }

    // Переключится на фрейм
    public void checkoutPaymentFramePage() {
        webDriver.switchTo().frame(webDriver.findElement(paymentFrame));
    }

}
