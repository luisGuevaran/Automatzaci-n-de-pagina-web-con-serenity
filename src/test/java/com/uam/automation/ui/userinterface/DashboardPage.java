package com.uam.automation.ui.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashboardPage {
    // Apunta al botón dentro del enlace de órdenes
    public static final Target ORDERS_LINK = Target.the("botón de órdenes")
            .located(By.xpath("//a[@href='customer-order.php']//button"));

    public static final Target LAST_ORDER_PRODUCT = Target.the("nombre del producto pedido")
            .located(By.xpath("(//table//tr[last()]/td[2])[1]"));
}