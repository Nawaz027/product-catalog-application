
# Product Catalog API

## Table of Contents
- [Overview](#overview)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [Example JSON Objects](#example-json-objects)
- [API Endpoints](#api-endpoints)
- [Logging](#logging)

## Overview
This is a simple Spring Boot application that provides a RESTful API for managing a product catalog. Users can create, read, update, delete, and search for products.

## Technologies Used
- Spring Boot
- Spring Data JPA
- MySQL Database
- Gradle
- Lombok
- SLF4J for logging

## Setup and Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Nawaz027/product-catalog-application.git
   cd product-catalog-application

    Install MySQL Ensure that you have MySQL installed and running on your local machine. You can download it from MySQL's official website.

    Create a MySQL Database Open the MySQL command line or a MySQL client and run the following command to create a new database:

    sql

CREATE DATABASE product_catalog;

Configure MySQL Credentials Open src/main/resources/application.properties and configure the MySQL connection settings:

properties

spring.datasource.url=jdbc:mysql://localhost:3306/product_catalog
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

Build the Application Use Gradle to build the application:

bash

./gradlew build

Run the Application Start the application:

bash

    ./gradlew bootRun

Configuration

You can change the following properties in application.properties to customize the application behavior:

    spring.jpa.hibernate.ddl-auto: Set to update, create, create-drop, or none to control the schema generation strategy.
    spring.jpa.show-sql: Set to true to display the SQL queries in the console.

Usage

Once the application is running, you can interact with it using Postman or any other API client.
Example JSON Objects

Here are five example JSON objects you can use to create products:

    Example Product 1

    json

{
    "name": "Computer",
    "brand": "BrandName",
    "description": "High-end laptop",
    "price": 1200,
    "quantity": 10,
    "category": "electronics",
    "sku": "12345",
    "manufacturer": "BrandManufacturer"
}

Example Product 2

json

{
    "name": "Smartphone",
    "brand": "PhoneBrand",
    "description": "Latest model smartphone",
    "price": 800,
    "quantity": 25,
    "category": "electronics",
    "sku": "67890",
    "manufacturer": "PhoneManufacturer"
}

Example Product 3

json

{
    "name": "Headphones",
    "brand": "AudioBrand",
    "description": "Noise-cancelling headphones",
    "price": 150,
    "quantity": 50,
    "category": "accessories",
    "sku": "54321",
    "manufacturer": "AudioManufacturer"
}

Example Product 4

json

{
    "name": "Television",
    "brand": "TVBrand",
    "description": "4K Ultra HD TV",
    "price": 600,
    "quantity": 15,
    "category": "electronics",
    "sku": "98765",
    "manufacturer": "TVManufacturer"
}

Example Product 5

json

    {
        "name": "Smartwatch",
        "brand": "WatchBrand",
        "description": "Smartwatch with fitness tracking",
        "price": 250,
        "quantity": 30,
        "category": "wearables",
        "sku": "11223",
        "manufacturer": "WatchManufacturer"
    }

API Endpoints
Create a Product

    POST /api/products
    Request Body: (Use one of the example JSON objects above)

Get a Product by ID

    GET /api/products/{id}

Get All Products

    GET /api/products

Update a Product

    PUT /api/products/{id}
    Request Body: (Use one of the example JSON objects above)

Delete a Product

    DELETE /api/products/{id}

Search Products

    GET /api/products/search
    Parameters:
        name (optional)
        category (optional)
        minPrice (optional)
        maxPrice (optional)

Logging

The application uses SLF4J for logging. You can view logs in the console while the application is running, which will include information about requests being processed.
