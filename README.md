# Library-Managment-System
INTRO:

This project is about development of REST API's for both Student and Admin. its built using Spring boot With Maven.
No Authentication or Authorization used in this project. so, in a way all the EndPoints are open to public.

FUNCTIONALITIES:

users can add a book to database using an endpoint
Users can see books available in database.
Users can apply filter for book Search.
users can add a student to database.
Users can retrive student details using studentId.
Users can place a request to borrow a book.
Admin can Create another Admin.
Admin can retrive details of another admin using adminId.
Admin can process the request placed by user.
Admin can either reject or Accept the request.
If admin accept the request a transcation will be created.

Changes to make:

In application.properties:
    change "spring.datasource.username=root" to your database username.
    change "spring.datasource.password= ****" to your database password.

RUN:
    run the file LibraryManagmentSystemApplication.java to make your server up and running.



