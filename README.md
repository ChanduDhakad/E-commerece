# E-commerece

# REST API for an Online Bus Reservation System Portal  Application
<li>We have developed this REST API for an E-commerce application. This API performs all the fundamental CRUD operations of any E-commerce platform with user validation at every step. This API performs
  all the fundamental CRUD operations of any Online Bus Reservation System Portal  platform with user validation at every step.</li>
<li>This project is developed by team of 4 Back-end Developers during project week in Masai School.</li>










# Tech Stack
- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- MySQL
- Swagger UI
- Lambok
- Maven


# Modules

- Login Module
- Feedback Module
- User Module
- Bus Module
- Route Module
- Admin Module
- CurrentUser module



# Features

- Data Authentication and Validation for all the users (Bus owner, User)

## Owner Features
- Admin can log in using valid credentials.
- Admin can add product details and update the product inventory.
- Admin can view all orders and the list of customers.
- Admin can update product details and admin information.
- Admin can delete any product from the inventory.


## Customer Features
- Customers can log in to the application and update their information using their username and password.
- Customers can browse and search for products.
- Customers can add products to their cart and place orders.
- Customers can view their order history and update their profile information.
- Customers are able to cancel their orders and delete their accounts from the system.


# Installation & Run
 - Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```
    server.port=8080

spring.datasource.url=jdbc:mysql://localhost:3306/EcommerceDB;
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=root
spring.datasource.password=root

```

# API Root Endpoint
```
https://localhost:8080/
```
```
http://localhost:8080/swagger-ui/
```


![ErDiagram](![Screenshot (664)](https://github.com/ChanduDhakad/E-commerece/assets/97527158/db86d3af-26ab-4203-99cb-487cace50421))



