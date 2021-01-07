Feature: Fonctionnalités de la page models
  Scenario: Vérification de la redirection du bouton de la commande
    Given je suis sur la homepage
    Then j'appuie sur "Événements"
    And l'url de la page doit être "https://www.tesla.com/fr_FR/events"

  Scenario: Vérification du nombre d'événements
    Given je suis sur la page event
    Then la page doit contenir "15" evenements

  Scenario: Vérification de la redirection du bouton de la commande
    Given je suis sur la page event
    Then appuyer sur "Afficher plus"
    Then la page doit contenir plus de "15" evenements

  Scenario Outline: Vérification de la redirection du bouton de la commande
    Given je suis sur la page event
    Then je saisis le prénom "<prénom>"
    And je saisis le nom "<nom>"
    And je saisis le mail "<mail>"
    And je saisis le téléphone "<téléphone>"
    And je sélectionne la région "<region>"
    And je saisis le code postal "<postal>"
    And appuyer sur le bouton "Recevoir les News Tesla "
    And appuyer sur le bouton "Suivant"
    Examples:
    |prénom |nom  |mail           |téléphone  |region|postal|
    |first  |last |test@gmail.com |0606060606 |France|75017 |

