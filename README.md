## **H2 database**
[H2 database ui](http://localhost:8080/h2-console) \
database url `jdbc:h2:mem:testdb` \
database login `sa` \
database password `sa`

### Current API

#### Order
Create new order with products `curl -i --user user1:user1Pass -X POST -H "Content-Type: application/json" \
-d '{"productIds": [1]}' \
http://localhost:8080/orders/create`

Get all orders `curl -i --user user1:user1Pass http://localhost:8080/orders/`
#### Store
Get store info `curl -i --user user1:user1Pass http://localhost:8080/stores/1` 
#### Products
Get all products sorting by config `curl -i --user user1:user1Pass http://localhost:8080/stores/1/products/sort-by-price-rate-name` \
Get top 5 products sorting by price DESC `curl -i --user user1:user1Pass http://localhost:8080/stores/1/products/top-5-by-price`
#### Program
Quit program `curl -i --user user1:user1Pass -X POST http://localhost:8080/program/exit`