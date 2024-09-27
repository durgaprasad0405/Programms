Feature: End to End Test for  Testing Book store API
Description:
Swagger URL: https://bookstore.toolsqa.com/swagger/index.html

  Background: User generates token for Authorization
  Given I am an authorized user
    
    Scenario Outline: Authorized user is able to Add and Remove a book.
    Given A list of books are available 
    When I add a book to my reading list
    Then The book is added
    When I remove a book from my reading list
    Then The book is removed