Feature: Fonctionnalités de ma Model 3
  Scenario Outline:
    Given je suis sur la page "https://www.tesla.com/fr_fr/model3"
    Then la categorie "<category>" contient "<weight>","<acceleration>","<battery>"
    Examples:
      | category | weight | acceleration | battery |
      | Performance | 1,844 kg | 3,3 secondes | 567 km |
      | Grande Autonomie AWD | 1,844 kg | 4,4 secondes | 580 km |
      | Standard Plus | 1,745 kg | 5,6 secondes| 430 km |