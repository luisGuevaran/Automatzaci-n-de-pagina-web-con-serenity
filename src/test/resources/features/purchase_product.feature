Feature: Online Store Purchase Flow

  Scenario: Successful purchase of a smart product using Bank Deposit
    Given the user navigates to the online store
    When he logs in with email "luisf.guevaran@autonoma.edu.co" and password "uam_123*"
    And he searches for the product "smart" and adds it to the cart
    And he completes the checkout process using Bank Deposit
    Then he should see the confirmation message "Congratulation! Payment is successful."
    And the product should appear in the orders history