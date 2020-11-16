## Docker
### Création d'une image docker
	mvn spring-boot:build-image -Dspring-boot.build-image=marcfr13/cabautodiag-spring-boot-docker
### Renommer (taguer) une image
	docker image tag cabine:0.0.1-SNAPSHOT marcfr13/cabautodiag-spring-boot-docker
### Exécuter une image
	docker run -p 8080:8080 marcfr13/cabautodiag-spring-boot-docker