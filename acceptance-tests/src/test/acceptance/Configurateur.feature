Feature: Fonctionnalités de la page models
    Scenario: Vérification de la redirection du bouton de la commande
        Given je suis sur la page modelS
        Then j'appuie sur Commander
        And l'url de la page doit être "https://www.tesla.com/fr_fr/models/design#battery"

#  Scenario: Vérification du LOA
#    Given je suis sur la page modelS
#    Then j'appuie sur Commander
#    And Le prix du LOA doit être de "768 € /mois"
#
#  Scenario: Vérification du Prix de LOA avec pilotage automatique
#    Given je suis sur la page modelS
#    Then j'appuie sur Commander
#    And j'appuie sur pilotage automatique
#    And j'appuie sur option ajouter et on verifie l'augmentation de "89"
#
#  Scenario: Vérification des prix du modelS
#    Given je suis sur la page modelS
#    Then j'appuie sur Commander
#    And j'appuie sur modèle Grande Autonomie Plus
#    And le prix de LOA du modèle Grande Autonomie doit  être de "768" et "108" d'économie de carburant et un montant du contrat "84990"
#    And j'appuie sur Performance
#    And le prix de LOA de la Performance doit  être de "969" et "108" d'économie de carburant et un montant du contrat "101990"

  Scenario: Vérification des listes de localisation
    Given je suis sur la page modelS
    Then j'appuie sur Commander
    And j'appuie sur Suivant
    And je choisi les peneus d'hivers
    And j'appuie sur Suivant x2
    And j'appuie sur pilotage automatique
    And j'appuie sur tesla
    And j'appuie sur localisation et verifie si l'url et le bon
