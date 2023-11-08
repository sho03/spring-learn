# Spring Jpa Sample

# How to run
```shell
$ docker compose up -d
$ ./gradlew bootRun
$ curl -X POST localhost:8080/user
$ curl localhost:8080/users
```

`$ curl -X POST localhost:8080/user` can be used only once, because of the unique constraint of the `email` column.