package com.uam.automation.ui.userinterface; // Ajuste el package a su estructura real

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    // Enlace en el menú superior para ir al formulario
    public static final Target LOGIN_LINK = Target.the("Link to go to login page").located(By.xpath("//a[contains(text(),'Login')]"));

    // Campos del formulario con sus nombres reales (cust_email y cust_password)
    public static final Target EMAIL = Target.the("email field").located(By.name("cust_email"));
    public static final Target PASSWORD = Target.the("password field").located(By.name("cust_password"));
    public static final Target SUBMIT_BUTTON = Target.the("login button").located(By.name("form1"));
}