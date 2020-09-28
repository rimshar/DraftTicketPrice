# Draft Ticket Price Service
This application offers an API to receive a draft ticket price for travel agencies.

To receive the draft price, a JSON array with the passengers' information has to be be passed to the "/getPrice" endpoint using the GET method in the following format:

&nbsp;&nbsp;[ {  
&nbsp;&nbsp;&nbsp;&nbsp;"category": "ADULT or INFANT",  
&nbsp;&nbsp;&nbsp;&nbsp;"destination": "The end destination of the passenger",  
&nbsp;&nbsp;&nbsp;&nbsp;"bagCount": "The amount of bags the passenger has"  
&nbsp;&nbsp;} ]

Once a request is received, the application makes a call to external APIs defined in the "application.properties" file to receive a base price for the ticket to the passenger's destination, as well as the current VAT rate.   
For the purpose of this exercise it was assumed that the APIs return a single Double variable, representing percentage as a decimal in the case of the VAT (e.g. 21% = 0.21).

The application then returns a JSON object, which contains the total price of the tickets for the submitted passenger list, as well as individual ticket information in the following format:  

&nbsp;&nbsp;{  
&nbsp;&nbsp; "totalPrice": "22.99 EUR",  
&nbsp;&nbsp;&nbsp;&nbsp; "tickets":  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[ {  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "category": "ADULT",  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "basePrice": "12.10 EUR",  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "bagCount": 3,  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "totalBagPrice": "10.89 EUR"  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; } ]  
&nbsp;&nbsp;}

## Starting the application:

Open the files in your favourite IDE and launch TechTaskApplication.java or compile it and run it via your preferred method.  
By default the application will be started on http://localhost:8085  
A simple external test API for receiving VAT and ticket base price data can be found here: https://github.com/rimshar/VATandBasePriceTestAPI

## Technologies used:
* Java 8
* Spring Boot 2.3.4
* JUnit 5.6.2
* Mockito 3.3.3
* Maven 4.0.0
