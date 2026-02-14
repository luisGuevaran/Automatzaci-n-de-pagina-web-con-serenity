package com.uam.automation.ui.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.questions.Text; // Importante para aserciones de texto
import com.uam.automation.ui.questions.PaymentMessage;
import com.uam.automation.ui.questions.OrderHistory;
import com.uam.automation.ui.tasks.AddProduct;
import com.uam.automation.ui.tasks.CompleteCheckout;
import com.uam.automation.ui.tasks.Login;
import com.uam.automation.ui.userinterface.CheckoutPage;
import com.uam.automation.ui.userinterface.DashboardPage;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
// Importaciones estáticas para mayor legibilidad
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class PurchaseStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    // Registro del tipo de parámetro para reconocer {actor} en el feature
    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @Given("the user navigates to the online store")
    public void navigatesToStore() {
        theActorCalled("Luis").wasAbleTo(Open.url("http://demo-shop.cesaragudelo.com/"));
    }

    @When("he logs in with email {string} and password {string}")
    public void logsIn(String email, String pass) {
        theActorInTheSpotlight().attemptsTo(Login.withCredentials(email, pass));
    }

    @When("he searches for the product {string} and adds it to the cart")
    public void searchesAndAdds(String product) {
        theActorInTheSpotlight().attemptsTo(AddProduct.toCart(product));
    }

    @When("he completes the checkout process using Bank Deposit")
    public void completesCheckout() {
        theActorInTheSpotlight().attemptsTo(CompleteCheckout.usingBankDeposit());
    }

    @Then("{actor} should see the confirmation message {string}")
    public void verifiesMessage(Actor actor, String expectedMessage) {
        actor.attemptsTo(
                // Sincronización: esperar a que el servidor procese el pago
                WaitUntil.the(CheckoutPage.SUCCESS_MESSAGE, isVisible()).forNoMoreThan(20).seconds()
        );

        actor.should(
                seeThat("El mensaje de confirmación de pago",
                        PaymentMessage.displayed(),
                        equalTo(expectedMessage))
        );
    }

    @Then("the product should appear in the orders history")
    public void verifiesHistory() {
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CheckoutPage.BACK_TO_DASHBOARD, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(CheckoutPage.BACK_TO_DASHBOARD),
                WaitUntil.the(DashboardPage.ORDERS_LINK, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(DashboardPage.ORDERS_LINK)
        );

        theActorInTheSpotlight().should(
                seeThat("El nombre del producto en el historial",
                        OrderHistory.lastProductName(),
                        containsStringIgnoringCase("smart")) // Ignora si es Smart o smart
        );
    }
}