package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement heading = $("[data-test-id=dashboard]");
    private ElementsCollection cards = $$(".list__item");
    private SelenideElement buttonAddOne = $("[data-test-id = \"92df3f1c-a033-48e6-8390-206f6b1f56c0\"] " +
            ">[data-test-id=action-deposit]");
    private SelenideElement buttonAddTwo = $("[data-test-id = \"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"] " +
            "> [data-test-id=action-deposit]");
    private SelenideElement balanceFirst = $("[data-test-id = \"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
    private SelenideElement balanceSecond = $("[data-test-id = \"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public int getFirstCardBalance() {
        var text = cards.get(0).text();
        return extractBalance(text);
    }

    public int getSecondCardBalance() {
        var text = cards.get(1).text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        var start = text.indexOf(balanceStart);
        var finish = text.indexOf(balanceFinish);
        var value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public DashboardPage() {
        heading.shouldBe(visible);
    }

    public DashBoardTransferPage makeTransferSecond() {
        buttonAddTwo.click();
        return new DashBoardTransferPage();
    }

    public DashBoardTransferPage makeTransferFirst() {
        buttonAddOne.click();
        return new DashBoardTransferPage();
    }


}