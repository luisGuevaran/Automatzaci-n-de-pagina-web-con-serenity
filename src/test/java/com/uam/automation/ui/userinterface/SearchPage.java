package com.uam.automation.ui.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchPage {
    public static final Target SEARCH_INPUT = Target.the("campo de búsqueda").located(By.name("search_text"));
    public static final Target SEARCH_BUTTON = Target.the("botón de búsqueda").located(By.xpath("//button[@type='submit']"));

    // Identificado por ID 86 en inspecciones previas
    public static final Target SMART_WATCH_LINK = Target.the("enlace del Smart Watch")
            .located(By.xpath("//h3/a[contains(@href, 'id=86')]"));
}