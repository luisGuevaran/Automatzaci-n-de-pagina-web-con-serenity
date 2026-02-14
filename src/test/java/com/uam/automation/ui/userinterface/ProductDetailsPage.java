package com.uam.automation.ui.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductDetailsPage {
    public static final Target SIZE_SELECT = Target.the("size dropdown").located(By.name("size_id"));
    public static final Target COLOR_SELECT = Target.the("color dropdown").located(By.name("color_id"));
    public static final Target QUANTITY_INPUT = Target.the("quantity field").located(By.name("p_qty"));

    // Botón final de añadir al carrito dentro del detalle
    public static final Target ADD_TO_CART_FINAL = Target.the("add to cart button").located(By.name("form_add_to_cart"));
}