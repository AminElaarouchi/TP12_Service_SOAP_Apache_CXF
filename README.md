# TP12 — Service SOAP avec Apache CXF

Projet Maven Java 17 fondé sur le [TP12 du cours](https://mliaedu.toubkalit.com/student/courses/7/labs/219). Il illustre un contrat JAX-WS, un modèle JAXB, un WSDL généré, un client Java et WS-Security UsernameToken.

## Exécuter

```bash
mvn clean test
mvn exec:java -Dexec.mainClass=com.acme.cxf.Server
```

WSDL : `http://localhost:8080/services/hello?wsdl`. Pendant que le serveur tourne, lancer le client dans un second terminal :

```bash
mvn exec:java -Dexec.mainClass=com.acme.cxf.client.ClientDemo
```

Pour le serveur sécurisé, arrêter le premier serveur puis lancer :

```bash
mvn exec:java -Dexec.mainClass=com.acme.cxf.SecureServer
```

WSDL sécurisé : `http://localhost:8080/services/hello-secure?wsdl`. Dans SoapUI, configurer un UsernameToken `student` / `secret123` de type PasswordText. Le mot de passe de démonstration peut être changé via `SOAP_DEMO_PASSWORD`. Un appel sans token doit renvoyer une SOAP Fault. Ce mode est pédagogique ; utiliser TLS et une gestion de secrets adaptée pour un déploiement réel.

Le WSDL est généré directement par CXF ; il expose `SayHello` et `FindPerson`. UDDI est présenté dans le cours comme mécanisme historique de découverte de services.
