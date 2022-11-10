## Validation Engine
- Define an `Item` object with the following fields. Feel free to browse real inventory to get a better understanding of how real items are structured 
  - Site ID 
  - Category ID 
  - Title 
  - Condition 
  - Price 
  - Quantity 
  - Image URL (List)
  - Item Specifics 
  - Description 
- Expose a single API that validates Items and returns a `Response` object with `Error ID` and `Error Message` that is specific for each validation that fails. Make sure the response object can support multiple errors.
- Design and implement an infrastructure to validate `Item`s. Your code must demonstrate flexibility and scalability by its design. Within this infrastructure, the following validations should be implemented for demonstration purposes:
  - Title length is under 85 characters
  - Number of Item Specifics between 2 - 4
  - Item Specifics must include a ‘Model` with a non empty value
  
- Note - Your design and architecture should support the premise that any number of validations can and will be added to the application within its lifetime. And so, the infrastructure should be easily extensible and should demonstrate how it’s complying with the appropriate programming principles.
  - Consider in your design that not all validations should run for each and every request. Design the decision making logic in a flexible way. Demonstrate this part of the application by implementing at least one condition, for example only validate `Item`s when the `Site ID` is between 0 - 100
  - Each `Item Specific` needs to be normalized before validations can be applied. To achieve this - Implement a class that mocks / mimics an integration with an external service that normalized each `Item Specific` separately with the following behavior:
    - Capitalize first letter and lower case all the rest of the letters
    - Add `Thread.sleep` to each call to mimic a slow response time of 1000ms
    - The application’s response time SLA should be less than 1500ms. Assume each `Item` includes at least 2 `Item Specific`s 

