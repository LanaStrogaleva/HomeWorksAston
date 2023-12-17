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

    //
    private By acceptCookieButton = By.xpath(".//button[text() = 'Принять']");

    // Блок оплаты
    private By payBlock = By.xpath((".//div[@class = 'pay__wrapper']"));

    // Заголовок блока оплаты
    private By header = By.xpath((".//div[@class = 'pay__wrapper']/h2"));

    // Все логотипы платежных систем
    private By payPartnersLogos = By.xpath(".//div[@class='pay__partners']/ul/li/img");

    // Логотип "Visa"
    private By visaLogo = By.xpath(".//div[@class = 'pay__partners']/ul/li/img[@alt = 'Visa']");

    // Логотип "Verified By Visa"
    private By verifiedByVisaLogo = By.xpath(".//div[@class = 'pay__partners']/ul/li/img[@alt = 'Verified By Visa']");

    // Логотип "MasterCard"
    private By masterCardLogo = By.xpath(".//div[@class = 'pay__partners']/ul/li/img[@alt = 'MasterCard']");

    // Логотип "MasterCard Secure Code"
    private By masterCardSecureCodeLogo = By.xpath(".//div[@class = 'pay__partners']/ul/li/img[@alt = 'MasterCard Secure Code']");

    // Логотип "Белкарт"
    private By belcardLogo = By.xpath(".//div[@class = 'pay__partners']/ul/li/img[@alt = 'Белкарт']");

    // Логотип "МИР"
    private By mirLogo = By.xpath(".//div[@class = 'pay__partners']/ul/li/img[@alt = 'МИР']");

    // Ссылка "Подробнее о сервисе"
    private By aboutServiceLink = By.linkText("Подробнее о сервисе");

    // вид услуги -  выбрано "Услуги связи"
    private By serviceTypeName = By.xpath(".//span[text()= 'Услуги связи']");

    // Поле "Номер телефона"
    private By phoneField = By.xpath(".//input[@placeholder = 'Номер телефона']");

    // Поле "Сумма"
    private By sumField = By.xpath(".//form[@class = 'pay-form opened']//input[@placeholder = 'Сумма']");

    // Поле "E-mail для отправки чека"
    private By emailField = By.xpath(".//form[@class = 'pay-form opened']//input[@placeholder = 'E-mail для отправки чека']");

    // Кнопка "Продолжить"
    private By continueButton = By.xpath(".//form[@class = 'pay-form opened']//button[text() = 'Продолжить']");

    // Заголовок формы оплаты
    private By payFormHeader  = By.xpath(".//div[@class= 'header__payment']/p[2]");

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
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    // Получить название блока
    public String getBlockName() {
        return webDriver.findElement(header).getText();
    }
    // Получить логотип платежной системы по индексу
    public String getPayPartnersLogos(int index) {
        return webDriver.findElements(payPartnersLogos).get(index).getAttribute("alt");
    }
    // Кликнуть на ссылку "Подробнее о сервисе"
    public void clickAboutServiceLink() {
        webDriver.findElement(aboutServiceLink).click();
    }

    // Заполнить поле "Номер телефона"
    public void inputPhoneField(String phone) {
        webDriver.findElement(phoneField).sendKeys(phone);
    }

    // Заполнить поле "Сумма
    public void inputSumField(int sum) {
        webDriver.findElement(phoneField).sendKeys(String.valueOf(sum));
    }
    // Заполнить поле "E-mail для отправки чека"
    public void inputEmailField(String email) {
        webDriver.findElement(phoneField).sendKeys(email);
    }

    // Заполнить форму блока "Онлайн пополнение без комиссии"
    public void fillPayBlockForm(TestData testData) {
        webDriver.findElement(phoneField).sendKeys(testData.phone);
        webDriver.findElement(sumField).sendKeys(String.valueOf(testData.sum));
        webDriver.findElement(emailField).sendKeys(testData.email);
    }

    // Кликнуть на  кнопку "Продолжить"
    public void clickContinueButton() {
        webDriver.findElement(continueButton).click();
    }

     // Получить текст заголовка формы оплаты
    public String getPayFormHeader() {
      return webDriver.switchTo().frame(webDriver.findElement(By.className("bepaid-iframe"))).findElement(payFormHeader).getAttribute("textContent");

    }

}
