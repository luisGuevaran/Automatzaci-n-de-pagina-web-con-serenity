package com.uam.automation.ui.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import com.uam.automation.ui.userinterface.CheckoutPage;

public class PaymentMessage {
    public static Question<String> displayed() {
        return actor -> Text.of(CheckoutPage.SUCCESS_MESSAGE)
                .answeredBy(actor)
                .trim(); // Elimina espacios en blanco extra
    }
}