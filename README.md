# ReadingIsGood-API
User can save new customer, place an order of books, list all orders (inactive and active), list all stock numbers of books.  

RestFul Service uses following Technologies:  

* Spring-boot
* Hibernate
* Spring-security
* H2 DB
* Swagger2  

### Documentation
For swagger documentation; 
```
http://localhost:8035/swagger-ui.html
```  

### Usage  

docker run : 
```
docker build -f Dockerfile -t ReadingIsGood-API .  
docker run -p 8035:8035 ReadingIsGood-API  
```  

First of all, user must get bearer token with username and password that provided. (For test usage, username is **test**, password is **1234**)    

Postman collection file can be found under /src/main/resources.  

```
http://localhost:8035/api/get-token
```

![Untitled](https://user-images.githubusercontent.com/7340804/117584864-fb18c200-b117-11eb-9704-1fd0792c7f12.png)
