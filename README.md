# Description:-
My Shop is a demo ecommerce website which is used for testing. 
This project is based on Java with Selenium and a framework is created to test the website.

# Testing Includes-
Login test with valid credentials
Searching the product
Checking the product availability
Adding the product into cart
Verifying the total price of the purchase
Adding new address
Creating new accounts using multiple data

# Documentation Included-
Test cases
Test data
Test report
Screenshots of failed test cases

# Approach-
In this project the Page Object Model is used where each page acts as a repository of Webelements located on the particular webpage.
Using the POM makes the handling of code smoother and easy to use. The Webelements gets initialized while the page object is created which makes execution of script faster.

Note-
We need to change the test data because the email is stored in database and may get "email already in use" error. 
So while using the script we have to generate new email to test the Website.
If the copy of database is made available we can create copy of the database in original state and execute the test cases and remove the test data from database later
but doing this on production will increase the risk and also copy of database cannot be given to public. 
