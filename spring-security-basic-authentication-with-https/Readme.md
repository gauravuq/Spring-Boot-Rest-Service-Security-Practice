## Basic Authentication Demo with HTTPS
* **This demo represents how to set up basic authentication for multiple RestMappings 
 using database based authentication provider**
* **H2 database has been used for quick demonstrations**
* **PKCS12 Keystore is used to save Server's private and public key**
* **Truststore for Client has not been configured as only server side ssl is enabled**
* **Any request made to port 8080 will be rerouted to secure port 8443**
#### Scenarios:
* **"localhost:8443/hello/helloWorld?name='yourname''"**  url will only allow those users which give valid credentials for basic authentication. The provided credentials are checked against the database entries**
* **"localhost:8443/helloV2/helloWorld?name='yourname''"**  url will allow access without any authentication**

