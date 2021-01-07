Feature: Fonctionnalités de ma page d'accueil
	Scenario: Vérification du titre et de la description
		Given je suis sur la homepage
		Then le titre doit être "Voitures électriques, énergie solaire et propre | Tesla France"
		And la description contient "Tesla accélère la transition mondiale vers une énergie durable en proposant des véhicules électriques, des panneaux solaires et des solutions intégrées d'énergie renouvelable pour les particuliers et les entreprises."

	Scenario Outline: Vérification de toutes les Fonctionalité basique de homepage
		Given je suis sur la homepage
		Then j'indique l'élément et le contenu "<element>" "<content>"
		Examples:
		|element |content									|
		|h1      |Model 3									|
		|h1      |Model S									|
		|h1      |Model X									|
		|h1      |Model Y									|
		|h1      |Systèmes d'énergie solaire et Powerwalls	|
		|a	     |/fr_fr/models								|
		|a	     |/fr_fr/model3								|
		|a	     |/fr_fr/modelx								|
		|a	     |/fr_fr/modely								|
		|a	     |/fr_fr/powerwall							|
		|a	     |/fr_fr/charging							|

	Scenario Outline: vérification du menu-burger
		Given je suis sur la homepage
		Then je choisi un element du menu-burger "<menu>"
		Examples:
		|menu |
		|Véhicules disponibles |
		|Véhicules d'occasion  |
		|Reprise               |
		|Cybertruck            |
		|Roadster              |
		|Énergie	    		|
		|Essais                |
		#|Flottes & Entreprises |
		|Nous trouver           |
		|Événements             |
		|Assistance             |


