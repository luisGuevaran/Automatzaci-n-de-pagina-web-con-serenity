package com.uam.automation.ui.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import com.uam.automation.ui.userinterface.ProductDetailsPage;
import com.uam.automation.ui.userinterface.SearchPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProduct implements Task {
    private final String product;

    public AddProduct(String product) {
        this.product = product;
    }

    public static AddProduct toCart(String product) {
        return instrumented(AddProduct.class, product);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(product).into(SearchPage.SEARCH_INPUT),
                Click.on(SearchPage.SEARCH_BUTTON),

                WaitUntil.the(SearchPage.SMART_WATCH_LINK, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(SearchPage.SMART_WATCH_LINK),

                // SOLUCIÓN AL ERROR DE DESPLAZAMIENTO:
                // Centrar el formulario de detalles en la pantalla antes de seleccionar
                WaitUntil.the(ProductDetailsPage.SIZE_SELECT, isVisible()).forNoMoreThan(10).seconds(),
                Scroll.to(ProductDetailsPage.SIZE_SELECT),

                // Selección de talla (usamos index 0 si es la única opción real)
                SelectFromOptions.byIndex(0).from(ProductDetailsPage.SIZE_SELECT),

                // Selección de color (usar el texto visible exacto, ej: "Black")
                WaitUntil.the(ProductDetailsPage.COLOR_SELECT, isClickable()).forNoMoreThan(5).seconds(),
                SelectFromOptions.byVisibleText("Black").from(ProductDetailsPage.COLOR_SELECT),

                Enter.theValue("1").into(ProductDetailsPage.QUANTITY_INPUT),
                Click.on(ProductDetailsPage.ADD_TO_CART_FINAL)
        );
    }
}