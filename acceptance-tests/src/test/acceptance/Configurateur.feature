Feature: Fonctionnalités de la page models
    Scenario: Vérification de la redirection du bouton de la commande
        Given je suis sur la page modelS
        Then j'appuie sur Commander
        And l'url de la page doit être "https://www.tesla.com/fr_fr/models/design#battery"

  Scenario: Vérification du LOA
    Given je suis sur la page modelS
    Then j'appuie sur Commander
    And Le prix du LOA doit être de "768 € /mois"