# cabine d'auto-diagnostic

## Démo de l'application
L'application dockerisée est visible sur [Heroku](https://cabautodiag-spring-boot-docker.herokuapp.com/)

## Packaging de l'application
	mvn clean package spring-boot:repackage

## Lancement de l'application
	java -jar target\cabine-0.0.2-SNAPSHOT.jar

## Intégration du code source dans une IDE
L'application utilise la librairie Lombok
Suivre les indications sur le site pour permettre le fonctionnement de Lombok avec votre IDE

(ex. pour [Eclipse](https://projectlombok.org/setup/eclipse)).
