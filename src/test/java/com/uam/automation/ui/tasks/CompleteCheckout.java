package com.uam.automation.ui.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.JavaScriptClick; // Importación necesaria
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.uam.automation.ui.userinterface.CheckoutPage;
import java.util.UUID;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteCheckout implements Task {

    public static CompleteCheckout usingBankDeposit() {
        return instrumented(CompleteCheckout.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String randomUuid = java.util.UUID.randomUUID().toString();
        actor.attemptsTo(
                Click.on(CheckoutPage.CART_ICON),
                JavaScriptClick.on(CheckoutPage.PROCEED_CHECKOUT),

                // Manejo de Select2
                Scroll.to(CheckoutPage.PAYMENT_METHOD_CONTAINER),
                Click.on(CheckoutPage.PAYMENT_METHOD_CONTAINER),
                Click.on(CheckoutPage.BANK_DEPOSIT_OPTION),

                Enter.theValue(randomUuid).into(CheckoutPage.TRANSACTION_INFO),
                Click.on(CheckoutPage.PAY_NOW_BUTTON)
        );
    }
}