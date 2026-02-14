package com.uam.automation.ui.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import com.uam.automation.ui.userinterface.DashboardPage;

public class OrderHistory {
    public static Question<String> lastProductName() {
        return actor -> Text.of(DashboardPage.LAST_ORDER_PRODUCT).answeredBy(actor).trim();
    }
}