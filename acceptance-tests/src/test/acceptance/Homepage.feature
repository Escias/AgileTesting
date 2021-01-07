Feature: Fonctionnalités de ma page d'accueil
	Scenario: Vérification du titre et de la description
		Given je suis sur la homepage
		Then le titre doit être
		And la description contient "Partagez vos passions et faites bouger votre ville"

Feature: Fonctionnalités de la page models
	Scenario: Vérification de la redirection du bouton de la commande
		Given Je suis sur la modelSpage
		When Le bouton de commande doit etre cliquer
		Then Le boutons commande doit avoir en url "https://www.tesla.com/fr_FR/models/design"

