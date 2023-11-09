# Multi database
Try to connect multiple databases.

# Run
```shell
# up two database
$ docker compose up -d

# start Spring boot application.
$ ./gradlew bootrun

# execute api
# to primary database (users)
$ curl -X POST -H "Content-Type: application/json" -d '{"name":"hoge", "age":34}' localhost:8080/users
$ curl localhost:8080/users

# to secondary database (books)
$ curl -X POST -H "Content-Type: application/json" -d '{"name":"hoge", "author":"author1"}' localhost:8080/books
$ curl localhost:8080/books
```
