# 🛒 Online Store Automation - Serenity BDD & Screenplay

Este proyecto automatiza el flujo de compra de un reloj inteligente en la tienda virtual **Demo Shop**, validando desde el inicio de sesión hasta el registro en el historial de órdenes.

## 🚀 Arquitectura y Tecnologías
El proyecto se construyó utilizando el patrón de diseño **Screenplay**, que mejora la legibilidad, el mantenimiento y la escalabilidad del código al seguir los principios SOLID.

* **Lenguaje:** Java 17 (JDK)
* **Framework de Automatización:** Serenity BDD
* **Motor de Pruebas:** Cucumber (Gherkin)
* **Gestor de Dependencias:** Gradle
* **Patrón de Diseño:** Screenplay

## 🛠️ Requisitos Previos
* Java JDK 17
* Geckodriver (instalado automáticamente por Serenity para Firefox)
* Gradle 9.0+

## 🏃 Ejecución de Pruebas
Para ejecutar las pruebas y generar el reporte de evidencias, utilice el siguiente comando en la terminal:

```bash
./gradlew clean test aggregate

📊 Evidencias y Reportes

Tras la ejecución, el reporte detallado (con capturas de pantalla de cada paso) se genera en:
target/site/serenity/index.html
📁 Estructura del Proyecto

    src/test/resources/features: Definición de los escenarios de prueba en lenguaje Gherkin.

    src/main/java/.../tasks: Acciones de alto nivel realizadas por el actor (Login, AddProduct).

    src/main/java/.../userinterface: Localizadores de elementos web (Targets).

    src/main/java/.../questions: Verificaciones y aserciones de la prueba.

    src/main/java/.../stepdefinitions: Mapeo entre Gherkin y el código Java.

Automatizado por Luis - 2026
