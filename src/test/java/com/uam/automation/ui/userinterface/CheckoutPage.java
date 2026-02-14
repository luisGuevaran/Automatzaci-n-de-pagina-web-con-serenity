package com.uam.automation.ui.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutPage {
    public static final Target CART_ICON = Target.the("icono del carrito").located(By.xpath("//i[@class='fa fa-shopping-cart']"));
    public static final Target PROCEED_CHECKOUT = Target.the("botón proceder").located(By.xpath("//a[contains(text(),'Proceed to Checkout')]"));

    // Manejo de Select2 (Menú desplegable de pago)
    public static final Target PAYMENT_METHOD_CONTAINER = Target.the("contenedor select2 de pago")
            .located(By.id("select2-advFieldsStatus-container"));
    public static final Target BANK_DEPOSIT_OPTION = Target.the("opción Bank Deposit")
            .located(By.xpath("//li[contains(text(),'Bank Deposit')]"));

    // Campos de transacción y pago
    public static final Target TRANSACTION_INFO = Target.the("campo de información").located(By.name("transaction_info"));
    public static final Target PAY_NOW_BUTTON = Target.the("botón Pay Now").located(By.name("form3"));

    // Validación y retorno
    public static final Target SUCCESS_MESSAGE = Target.the("mensaje de éxito").located(By.xpath("//*[contains(text(), 'Congratulation')]"));
    public static final Target BACK_TO_DASHBOARD = Target.the("botón volver al dashboard").located(By.xpath("//a[contains(text(),'Back to Dashboard')]"));
}