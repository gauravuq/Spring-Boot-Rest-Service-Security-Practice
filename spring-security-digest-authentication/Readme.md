## Basic Authentication Demo 
* **This demo represents how to set up digest authentication for multiple RestMappings 
 using database based authentication provider**
* **H2 database has been used for quick demonstrations**
#### Scenarios:
* **"localhost:8080/hello/helloWorld?name='yourname''"**  url will only allow those users which give valid credentials for digest authentication. The provided credentials are checked against the database entries**
* **"localhost:8080/helloV2/helloWorld?name='yourname''"**  url will allow access without any authentication**
