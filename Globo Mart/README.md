
globomart-gateway: Is the Gateway API Service created using Spring Cloud Zuul.

globomart-service-registry: Is the Service Discovery Register, all the microservices register to this registry and the status of each service can be seen on the registry dashboard. It's created using Spring Cloud Eureka.

globomart-product-catalog: Is the Product CRUD service, which helps in Creating, Reading, Updating and deleting products. It's created using Spring Boot, MVC.


Running the application:
-----------------------

1. Running the globomart-service-registry:
	a. Open terminal/CMD and navigate to the Globo Mart/globomart-service-registry folder.
	b. Do a mvn clean install
	c. To run the application mvn spring-boot:run

2. Running the globomart-gateway:
	a. Open a new terminal/cmd window and navigate to the Globo Mart/globomart-gateway folder.
	b. Do a mvn clean install
	c. To run the application mvn spring-boot:run

3. Running the globomart-product-catalog:
	a. Open a new terminal/cmd window and navigate to the Globo Mart/globomart-product-catalog folder.
	b. Do a mvn clean install
	c. To run the application mvn spring-boot:run

The globomart-gateway is configured to run on the port 8671

To view status of all the microservices: http://localhost:8071


CURL commands for creating products:
-----------------------------------
CURL -H "Content-Type: application/json" -X POST -d '{"productType":"phone", "productName":"iPhone X", "productDescription":"Apple iPhone X"}' http://localhost:8671/api/product-service/products

CURL -H "Content-Type: application/json" -X POST -d '{"productType":"phone", "productName":"Samsung Galaxy A5", "productDescription":"Samsung Galaxy A5"}' http://localhost:8671/api/product-service/products

CURL -H "Content-Type: application/json" -X POST -d '{"productType":"laptop", "productName":"Macbook Pro", "productDescription":"Apple Macbook Pro 2018"}' http://localhost:8671/api/product-service/products



CURL command for searching products by type:
-------------------------------------------
CURL -X GET  http://localhost:8671/api/product-service/products/phone

CURL command for deleting products:
----------------------------------
CURL -H "Content-Type: application/json" -X DELETE -d '{"productType":"phone", "productName":"iPhone X", "productDescription":"Apple iPhone X"}' http://localhost:8671/api/product-service/products