package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.dat.DataHelper;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class DashBoardTransferPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private SelenideElement buttonAdd = $("[data-test-id=action-transfer]");
    private SelenideElement amount = $("[data-test-id=amount] input");
    private SelenideElement from = $("[data-test-id=from] input");


    public DashBoardTransferPage() {
        heading.shouldBe(visible);
    }

    //пополнение карты
    public DashboardPage transferCard(DataHelper.MoneyTransfer moneyTransfer) {
        amount.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.DELETE);
        amount.setValue(moneyTransfer.getAmount());
        from.sendKeys(Keys.chord(Keys.CONTROL, "A"), Keys.DELETE);
        from.setValue(moneyTransfer.getCardNumber());
        buttonAdd.click();
        return new DashboardPage();
    }
}
