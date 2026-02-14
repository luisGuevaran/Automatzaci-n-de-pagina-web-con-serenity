package com.uam.automation.ui.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.uam.automation.ui.userinterface.LoginPage;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {
    private final String email;
    private final String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static Login withCredentials(String email, String password) {
        return instrumented(Login.class, email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(LoginPage.LOGIN_LINK),
                // Espera hasta que el campo de email sea visible antes de escribir
                WaitUntil.the(LoginPage.EMAIL, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(email).into(LoginPage.EMAIL),
                Enter.theValue(password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.SUBMIT_BUTTON)
        );
    }
}